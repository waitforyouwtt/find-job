package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.dao.master.BbsAreaMapper;
import com.fenghuang.job.entity.BbsArea;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqBbsArea;
import com.fenghuang.job.service.BbsAreaService;
import com.fenghuang.job.view.BbsAreaSearchView;
import com.fenghuang.job.view.BbsAreaView;
import com.fenghuang.job.view.BbsAreaView2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.FixedOrderComparator;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/30 14:50
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class BbsAreaServiceImpl implements BbsAreaService {

    @Resource
    BbsAreaMapper bbsAreaMapper;
    /**
     * 根据area_id or title or pid 查询地址相关信息
     *
     * @param reqBbsArea
     * @return
     */
    @Override
    public List<BbsAreaView> findBbsArea(ReqBbsArea reqBbsArea) {
        log.info("根据area_id or title or pid 查询地址相关信息请求参数：{}", JSON.toJSONString(reqBbsArea));
        List<BbsArea> queryBbsAreas = bbsAreaMapper.findBbsArea(reqBbsArea);
        List<BbsAreaView> views  = new ArrayList<>();
        if (CollectionUtils.isEmpty(queryBbsAreas)){
           return new ArrayList<>();
        }else{
            queryBbsAreas.stream().forEach(bbsArea -> {
                BbsAreaView view = new BbsAreaView();
                BeanCopier beanCopier = BeanCopier.create(BbsArea.class, BbsAreaView.class, false);
                beanCopier.copy(bbsArea,view,null);
                views.add(view);
            });
        }
        return views;
    }

    /**
     * 初始化地理位置信息：递归方法
     * @return
     */
    @Override
    public List<BbsAreaSearchView> findBbsAreaList() {
        ReqBbsArea reqBbsArea = new ReqBbsArea();
        List<BbsArea> queryBbsAreas = bbsAreaMapper.findBbsArea(reqBbsArea  );
        List<BbsAreaSearchView> result = Lists.newArrayList();
        queryBbsAreas.stream().forEach( bbsArea -> {
            BbsAreaSearchView bbsAreaSearchView = new BbsAreaSearchView();
            bbsAreaSearchView.setText( bbsArea.getTitle() );
            bbsAreaSearchView.setId( bbsArea.getAreaId() );
            reqBbsArea.setPid( bbsArea.getAreaId());
            reqBbsArea.setAreaId( null );
            List<BbsArea> list = bbsAreaMapper.findBbsArea( reqBbsArea );
            List<BbsAreaSearchView> collect = list.stream().map( item -> {
                BbsAreaSearchView bbsAreaSearchView1 = new BbsAreaSearchView();
                bbsAreaSearchView1.setText( item.getTitle() );
                bbsAreaSearchView1.setId( item.getAreaId() );
                return bbsAreaSearchView1;
            } ).collect( Collectors.toList() );
            bbsAreaSearchView.setChildren( collect );
            result.add( bbsAreaSearchView );
        } );
        return result;
    }

    @Override
    public Result findBbsAreaByUPid(Integer upid) {
        List<BbsAreaView> bbsAreaViewList = new ArrayList<>();
        List<BbsAreaView> unionList = new ArrayList<>();
        if (StringUtils.isEmpty( upid ) || upid == 0) {
            upid = 0;
            bbsAreaViewList = bbsAreaMapper.findBbsAreaByUPid( upid );
            List<BbsAreaView> citys = bbsAreaMapper.findBbsAreaByUPid2();

            Set<BbsAreaView> setOne = new HashSet<>( bbsAreaViewList );
            Set<BbsAreaView> setTwo = new HashSet<>( citys );
            Sets.SetView<BbsAreaView> union = Sets.union( setOne, setTwo );
            unionList = union.parallelStream().collect( Collectors.toList() );
            Collections.sort(unionList, new BeanComparator<BbsAreaView>("areaId", new FixedOrderComparator( Constants.sortList() )));
            return Result.success( unionList );
        }
        return Result.success( bbsAreaMapper.findBbsAreaByUPid( upid ) );
    }
}
