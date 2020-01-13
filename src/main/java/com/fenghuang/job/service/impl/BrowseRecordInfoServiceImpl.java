package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.BrowseRecordInfoMapper;
import com.fenghuang.job.entity.BrowseRecordInfo;
import com.fenghuang.job.request.ReqBrowseRecordInfoQuery;
import com.fenghuang.job.service.BrowseRecordInfoService;
import com.fenghuang.job.view.BrowseRecordInfoView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/10 18:54
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class BrowseRecordInfoServiceImpl implements BrowseRecordInfoService {

    @Autowired
    BrowseRecordInfoMapper browseRecordInfoMapper;
    /**
     * 根据条件查询浏览记录相关信息且分页
     *
     * @param recordInfoQuery
     * @return
     */
    @Override
    public PageInfo<BrowseRecordInfoView> findBrowseRecordInfoPage(ReqBrowseRecordInfoQuery recordInfoQuery) {
        log.info( "根据条件查询浏览记录相关信息且分页 请求参数：{}", JSON.toJSONString( recordInfoQuery ) );
        PageInfo<BrowseRecordInfoView> pageInfo = null;
        try{
            Page<?> page = PageHelper.startPage(recordInfoQuery.getPageNum(),recordInfoQuery.getPageSize());
            List<BrowseRecordInfo> queryBrowseRecordInfo = browseRecordInfoMapper.findBrowseRecordInfo(recordInfoQuery);
            if (CollectionUtils.isEmpty( queryBrowseRecordInfo )){
                pageInfo = new PageInfo<>(new ArrayList<>(16));
            }else{
                List<BrowseRecordInfoView> views = new ArrayList<>(  16);
                queryBrowseRecordInfo.stream().forEach( browseRecordInfo -> {
                    BrowseRecordInfoView view = new BrowseRecordInfoView();
                    BeanCopier beanCopier = BeanCopier.create( BrowseRecordInfo.class,BrowseRecordInfoView.class,false );
                    beanCopier.copy( browseRecordInfo,view,null );
                    views.add( view );
                } );
                pageInfo = new PageInfo<>(views);
            }
            log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        }catch (Exception e){
            log.info( "根据条件查询浏览记录相关信息且分页 查询异常：{}",e.getMessage() );
        }
        return pageInfo;
    }

    /**
     * 根据用户id 查询收藏记录
     * @param userId
     * @return
     */
    @Override
    public List<BrowseRecordInfo> findByUserId(Integer userId) {
        log.info("根据用户id 查询收藏记录 请求参数：{}",userId);
        return browseRecordInfoMapper.findByUserId(userId);
    }
}
