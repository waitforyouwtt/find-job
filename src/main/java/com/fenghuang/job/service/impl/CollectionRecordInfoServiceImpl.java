package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.CollectionRecordInfoMapper;
import com.fenghuang.job.entity.CollectionRecordInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.*;
import com.fenghuang.job.request.ReqCollectionRecordInfo;
import com.fenghuang.job.request.ReqCollectionRecordInfoQuery;
import com.fenghuang.job.request.ReqCollectionRecordInfoState;
import com.fenghuang.job.request.ReqProjectInfoQuery;
import com.fenghuang.job.service.CollectionRecordInfoService;
import com.fenghuang.job.service.ProjectInfoService;
import com.fenghuang.job.view.CollectionRecordInfoView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 16:32
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class CollectionRecordInfoServiceImpl implements CollectionRecordInfoService {

    @Autowired
    CollectionRecordInfoMapper collectionRecordInfoMapper;

    @Autowired
    ProjectInfoService projectInfoService;
    /**
     * 用户新增收藏记录
     *
     * @param recordInfo
     * @return
     */
    @Override
    public Result insertCollectionRecordInfo(ReqCollectionRecordInfo recordInfo) {
        log.info("用户新增收藏记录 请求参数{}", JSON.toJSONString(recordInfo));
        Integer userId = 25;

        //同一用户同一兼职项目未删除状态下不能重复收藏
        ReqCollectionRecordInfoQuery query = new ReqCollectionRecordInfoQuery();
        query.setIsDelete(  DeleteEnum.NO.getCode());
        query.setUserId( userId );
        query.setProjectId( recordInfo.getProjectId() );
        query.setIsCollection( CollectionEnum.YES.getCode() );
        List<CollectionRecordInfo> queryCollectionRecordInfo = collectionRecordInfoMapper.findCollectionRecordInfo( query );
        if (!CollectionUtils.isEmpty( queryCollectionRecordInfo )){
            return Result.error( BusinessEnum.RECORD_ALREADY_EXISTS.getCode(),BusinessEnum.RECORD_ALREADY_EXISTS.getMsg(),null );
        }

        CollectionRecordInfo collectionRecordInfo = new CollectionRecordInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqCollectionRecordInfo.class,CollectionRecordInfo.class,false);
        beanCopier.copy(recordInfo,collectionRecordInfo,null);
        collectionRecordInfo.setUserId( userId );
        collectionRecordInfo.setIsDelete(DeleteEnum.NO.getCode());
        collectionRecordInfo.setIsCollection(CollectionEnum.YES.getCode());
        collectionRecordInfo.setFounder(userId.toString());
        collectionRecordInfo.setModifier(userId.toString());
        collectionRecordInfo.setCreateDate(new Date());
        collectionRecordInfo.setUpdateDate(new Date());
        return Result.success(collectionRecordInfoMapper.insertSelective(collectionRecordInfo));
    }

    /**
     * 用户变更收藏记录状态
     *
     * @param recordInfoState
     * @return
     */
    @Override
    public Result updateCollectionRecordInfoState(ReqCollectionRecordInfoState recordInfoState) {
        log.info("用户变更收藏记录状态 请求参数：{}",JSON.toJSONString(recordInfoState));
        int i = collectionRecordInfoMapper.updateCollectionRecordInfoState(recordInfoState);

        if (i >0){
            return Result.success("修改成功");
        }else{
            return Result.error("修改失败");
        }
    }

    /**
     * 根据条件查询收藏记录且分页
     * @param recordInfoQuery
     * @return
     */
    @Override
    public PageInfo<CollectionRecordInfoView> findCollectionRecordInfoPage(ReqCollectionRecordInfoQuery recordInfoQuery) {
      log.info("根据条件查询收藏记录且分页 请求参数：{}",JSON.toJSONString(recordInfoQuery));
      PageInfo<CollectionRecordInfoView> pageInfo = null;
      try{
          Page<?> page = PageHelper.startPage(recordInfoQuery.getPageNum(),recordInfoQuery.getPageSize());
          recordInfoQuery.setUserId( 25 );
          List<CollectionRecordInfoView> queryCollectionRecordInfo = collectionRecordInfoMapper.findCollectionRecordInfoPage(recordInfoQuery);
          if (CollectionUtils.isEmpty(queryCollectionRecordInfo)){
              pageInfo = new PageInfo<>(new ArrayList<>());
          }else{
              List<CollectionRecordInfoView> views = new ArrayList<>();
              queryCollectionRecordInfo.stream().forEach(recordInfo->{
                  CollectionRecordInfoView view = new CollectionRecordInfoView();
                  BeanCopier beanCopier = BeanCopier.create(CollectionRecordInfo.class,CollectionRecordInfoView.class,false);
                  beanCopier.copy(recordInfo,view,null);
                  view.setSalaryUnitDesc(SalaryUnitEnum.fromValue(recordInfo.getSalaryUnit()).getMsg());
                  //标签转换：
                  List<String> projectLabels = Splitter.on(",").trimResults().splitToList(recordInfo.getProjectLabel());
                  List<String> labels = new ArrayList<>();
                  if (CollectionUtils.isEmpty(projectLabels)){
                      view.setProjectLabelsDesc(labels);
                  }else{
                      projectLabels.stream().forEach(s -> {
                          if (s.equals(ProjectLabelEnum.LONG_WORKER.getCode().toString())){
                              labels.add(ProjectLabelEnum.LONG_WORKER.getMsg());
                          }
                          if (s.equals(ProjectLabelEnum.SHORT_WORKER.getCode().toString())){
                              labels.add(ProjectLabelEnum.SHORT_WORKER.getMsg());
                          }
                          if (s.equals(ProjectLabelEnum.WINTER_WORKER.getCode().toString())){
                              labels.add(ProjectLabelEnum.WINTER_WORKER.getMsg());
                          }
                          if (s.equals(ProjectLabelEnum.SUMMER_WORKER.getCode().toString())){
                              labels.add(ProjectLabelEnum.SUMMER_WORKER.getMsg());
                          }
                          if (s.equals(ProjectLabelEnum.HOURLY_WORKER.getCode().toString())){
                              labels.add(ProjectLabelEnum.HOURLY_WORKER.getMsg());
                          }
                      });
                      view.setProjectLabelsDesc(labels);
                  }
                  views.add(view);
              });
              views.sort(Comparator.comparing(CollectionRecordInfoView::getCreateDate).reversed());
              pageInfo = new PageInfo<>(views);
          }
          log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
      }catch (Exception e){
          log.info("根据条件查询收藏记录且分页查询异常：{}",e.getMessage());
          e.printStackTrace();
      }
        return pageInfo;
    }

    /**
     * 根据项目id查询收藏记录详情
     * @param projectId
     * @return
     */
    @Override
    public Result findCollectionRecordInfoDetails(Integer projectId) {
        log.info("根据项目id查询收藏记录详情 请求参数：{}",projectId);
        ReqProjectInfoQuery query = new ReqProjectInfoQuery();
        query.setId( projectId );
        return  projectInfoService.findProjectDetailsById(query);
    }

    /**
     * 根据用户id 查询收藏记录
     * @param userId
     * @return
     */
    @Override
    public List<CollectionRecordInfo> findByUserId(Integer userId) {
        log.info("根据用户id 查询收藏记录 请求参数：{}",userId);
        return collectionRecordInfoMapper.findByUserId(userId);
    }

    /**
     * 用户取消收藏
     * @param recordInfoState
     * @return
     */
    @Override
    public Result cancelCollectionRecordInfo(ReqCollectionRecordInfoState recordInfoState) {
        log.info( "用户取消收藏 请求参数:{}",JSON.toJSONString( recordInfoState ) );
        recordInfoState.setUserId( 25 );
        recordInfoState.setCollectionState( 2 );
        return Result.success(collectionRecordInfoMapper.cancelCollectionRecordInfo(recordInfoState));
    }
}
