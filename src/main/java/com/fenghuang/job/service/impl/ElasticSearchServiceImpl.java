package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.service.ElasticSearchService;
import com.fenghuang.job.service.ProjectInfoService;
import com.fenghuang.job.view.ProjectESByParamsView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.action.search.SearchRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.elasticsearch.search.builder.SearchSourceBuilder;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


/**
 * @Author: luoxian
 * @Date: 2020/6/16 17:10
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Autowired
    RestHighLevelClient restHighLevelClient;
    
    @Autowired
    ProjectInfoService projectInfoService;

    /**
     * 创建商品es索引库[不存在则创建，存在则修改]
     *
     * @return
     */
    @Override
    public Result createIndex() {

        List<ProjectInfo> projectInfoList = projectInfoService.findAll();

        if (CollectionUtils.isEmpty(projectInfoList)) {
            return Result.success();
        }

        projectInfoList.parallelStream().forEach(projectInfo -> {
            //文档内容
            //准备json数据
           // Map map = JSONObject.parseObject(JSONObject.toJSONString(projectInfo), Map.class);
            Map<String,Object> jsonMap = JSONObject.parseObject(JSON.toJSONString(projectInfo));
            //创建索引创建对象
            IndexRequest indexRequest = new IndexRequest(Constants.ES_PROJECT_INFO_INDEX, Constants.ES_DOC_TYPE,projectInfo.getId()+"");
            //文档内容
            indexRequest.source(jsonMap);
            //通过client进行http的请求
            IndexResponse indexResponse = null;
            try {
                indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            } catch (IOException e) {
               log.error("创建商品es索引库发生异常：{}",e.getMessage());
            }
            DocWriteResponse.Result result = indexResponse.getResult();
            log.info("创建商品es索引库的结果是：{}",JSON.toJSONString(result));
        });
        return Result.success();
    }

    /**
     * 保存或更新兼职项目
     *
     * @return
     */
    @Override
    public Result saveOrUpdateProjectByES() {
        List<ProjectInfo> projectInfoList = projectInfoService.findAll();

        if (CollectionUtils.isEmpty(projectInfoList)) {
            return Result.success();
        }
        projectInfoList.parallelStream().forEach(projectInfo -> {
            Map<String,Object> jsonMap = JSONObject.parseObject(JSON.toJSONString(projectInfo));
            //创建索引创建对象
            IndexRequest indexRequest = new IndexRequest(Constants.ES_PROJECT_INFO_INDEX, Constants.ES_DOC_TYPE);
            //文档内容
            indexRequest.source(jsonMap);
            //组装参数
            UpdateRequest updateRequest = new UpdateRequest(Constants.ES_PROJECT_INFO_INDEX, projectInfo.getId()+"").doc(jsonMap).upsert(indexRequest);
            UpdateResponse update = null;
            try {
                //通过client进行http的请求
                update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
            } catch (Exception e) {
                log.error("保存或更新兼职项目ES索引库发生异常：{}",e.getMessage());
            }
            DocWriteResponse.Result result = update.getResult();
            log.info("保存或更新兼职项目ES索引库的结果是：{}",JSON.toJSONString(result));
        });
        return Result.success();
    }

    /**
     * 通过es 自动生成的Id查询projectInfoES索引库
     *
     * @param id
     * @return
     */
    @Override
    public Result queryProjectESByAutoId(String id) throws ParseException {
        //搜索请求对象
        SearchRequest searchRequest = new SearchRequest(Constants.ES_PROJECT_INFO_INDEX);
        //指定类型
        searchRequest.types(Constants.ES_DOC_TYPE);
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        String[] ids = new String[]{id};
        searchSourceBuilder.query(QueryBuilders.termsQuery("_id",ids));

        //向搜索请求对象中设置搜索源
        searchRequest.source(searchSourceBuilder);
        //执行搜索,向ES发起http请求
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("通过Id查询projectInfoES索引库发生异常：{}",e.getMessage());
        }
        //搜索结果
        SearchHits hits = searchResponse.getHits();
        //匹配到的总记录数
        TotalHits totalHits = hits.getTotalHits();
        //得到匹配度高的文档
        SearchHit[] searchHits = hits.getHits();
        //日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ProjectInfo projectInfo = new ProjectInfo();

        for(SearchHit hit:searchHits){
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            projectInfo = JSON.parseObject(JSON.toJSONString(sourceAsMap), ProjectInfo.class);
        }
        return Result.success(projectInfo);
    }

    /**
     * 通过database Id查询projectInfoES索引库
     *
     * @param id
     * @return
     */
    @Override
    public Result queryProjectESById(String id) {
        //搜索请求对象
        SearchRequest searchRequest = new SearchRequest(Constants.ES_PROJECT_INFO_INDEX);
        //指定类型
        searchRequest.types(Constants.ES_DOC_TYPE);
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //搜索方式
        //MatchQuery
        searchSourceBuilder.query(QueryBuilders.matchQuery("id",id).minimumShouldMatch("80%"));

        //向搜索请求对象中设置搜索源
        searchRequest.source(searchSourceBuilder);
        //执行搜索,向ES发起http请求
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("通过database Id查询projectInfoES索引库发生异常：{}",e.getMessage());
        }
        //搜索结果
        SearchHits hits = searchResponse.getHits();
        //匹配到的总记录数
        TotalHits totalHits = hits.getTotalHits();
        //得到匹配度高的文档
        SearchHit[] searchHits = hits.getHits();
        //日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ProjectInfo projectInfo = new ProjectInfo();

        for(SearchHit hit:searchHits){
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            projectInfo = JSON.parseObject(JSON.toJSONString(sourceAsMap), ProjectInfo.class);
        }
        return Result.success(projectInfo);
    }

    /**
     * 通过条件查询projectInfoES索引库
     *
     * @param view
     * @return
     */
    @Override
    public Result queryProjectESByParams(ProjectESByParamsView view) {
        //填充查询条件
        BoolQueryBuilder boolQueryBuilder  = boolQueryBuilder(view);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(boolQueryBuilder);

        sourceBuilder.sort("createDate", SortOrder.fromString("desc"));
        SearchRequest searchRequest = new SearchRequest(Constants.ES_PROJECT_INFO_INDEX);
        searchRequest.types(Constants.ES_DOC_TYPE);
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("通过条件查询projectInfoES索引库发生异常：{}",e.getMessage());
        }
        //搜索结果
        SearchHits hits = searchResponse.getHits();
        //匹配到的总记录数
        TotalHits totalHits = hits.getTotalHits();
        //得到匹配度高的文档
        SearchHit[] searchHits = hits.getHits();
        //日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<ProjectInfo> projectInfoList = new ArrayList<>();
        for(SearchHit hit:searchHits){
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            ProjectInfo projectInfo = new ProjectInfo();
            projectInfo = JSON.parseObject(JSON.toJSONString(sourceAsMap), ProjectInfo.class);
            projectInfoList.add(projectInfo);
        }
        return Result.success(projectInfoList);
    }


    /**
     * 构建查询参数
     * @return
     */
    private static BoolQueryBuilder boolQueryBuilder(ProjectESByParamsView view){
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (view.getUserId() != null ){
            //匹配条件等于 xxx 的时候
            boolQueryBuilder.must(QueryBuilders.termQuery("userId", view.getUserId()));
        }
        if (view.getProvinceId() != null){
            //匹配条件不等于 xxx 的时候
            boolQueryBuilder.mustNot(QueryBuilders.termQuery("provinceId", view.getProvinceId()));
        }
        if (StringUtils.isNotBlank(view.getProjectTitle())){
            //模糊匹配
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("projectTitle", String.format("*%s*", view.getProjectTitle())));
        }
        if (StringUtils.isNotBlank(view.getProjectLabel())){
            List<String> projectLabelList = Arrays.asList(view.getProjectLabel().split(","));
            projectLabelList = projectLabelList.stream().map(String::toLowerCase).collect(Collectors.toList());
            boolQueryBuilder.must(QueryBuilders.termsQuery("projectLabel", projectLabelList));
        }

        /*if(StringUtils.isNotBlank(view.getProjectLabel())){
            //或关系的查询条件
            BoolQueryBuilder shouldBuilder = new BoolQueryBuilder();
            shouldBuilder.should(QueryBuilders.termsQuery("projectTitle.keyword", view.getProjectLabel()));
            shouldBuilder.should(QueryBuilders.termsQuery("projectTitle", view.getProjectLabel()));
            boolQueryBuilder.must(shouldBuilder);
        }*/

        return boolQueryBuilder;
    }
}
