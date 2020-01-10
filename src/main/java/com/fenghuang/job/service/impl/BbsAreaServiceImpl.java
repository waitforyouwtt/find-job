package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.BbsAreaMapper;
import com.fenghuang.job.entity.BbsArea;
import com.fenghuang.job.request.ReqBbsArea;
import com.fenghuang.job.service.BbsAreaService;
import com.fenghuang.job.view.BbsAreaView;
import com.fenghuang.job.view.BbsAreaView2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/30 14:50
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class BbsAreaServiceImpl implements BbsAreaService {

    @Autowired
    BbsAreaMapper bbsAreaMapper;
    /**
     * 根据条件查询地址相关信息
     *
     * @param reqBbsArea
     * @return
     */
    @Override
    public List<BbsAreaView> findBbsArea(ReqBbsArea reqBbsArea) {
        log.info("根据条件查询地址相关信息 请求参数：{}", JSON.toJSONString(reqBbsArea));
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
     * 根据父级节点查询子节点相关信息:只查询省级直辖市参数传：0
     *
     * @param pid
     * @return
     */
    @Override
    public List<BbsAreaView2> findBbsAreaByPid(Integer pid) {
        log.info("根据父级节点查询子节点相关信息:只查询省级直辖市参数传：0 请求参数：{}",pid);
        List<BbsAreaView2> queryBbsAreas = bbsAreaMapper.findBbsAreaByPid(pid);
        if (CollectionUtils.isEmpty(queryBbsAreas)){
            return new ArrayList<>();
        }
        return queryBbsAreas;
    }
}
