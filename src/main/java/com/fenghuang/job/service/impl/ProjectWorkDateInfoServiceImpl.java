package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.ProjectWorkDateInfoMapper;
import com.fenghuang.job.entity.ProjectWorkDateInfo;
import com.fenghuang.job.request.ReqProjectWorkDateInfo;
import com.fenghuang.job.service.ProjectWorkDateInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/7 10:59
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class ProjectWorkDateInfoServiceImpl implements ProjectWorkDateInfoService {

    @Autowired
    ProjectWorkDateInfoMapper projectWorkDateInfoMapper;
    /**
     * 新增上班日期
     *
     * @param reqProjectWorkDateInfo
     */
    @Override
    public int insertProjectWorkDateInfo(ReqProjectWorkDateInfo reqProjectWorkDateInfo) {
        log.info("新增上班日期 请求参数：{}", JSON.toJSONString(reqProjectWorkDateInfo));
        ProjectWorkDateInfo projectWorkDateInfo = new ProjectWorkDateInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqProjectWorkDateInfo.class,ProjectWorkDateInfo.class,false);
        beanCopier.copy(reqProjectWorkDateInfo,projectWorkDateInfo,null);
        return projectWorkDateInfoMapper.insertSelective(projectWorkDateInfo);
    }

    /**
     * 新增
     *
     * @param workDateInfo
     */
    @Override
    public int saveProjectWorkDateInfo(ProjectWorkDateInfo workDateInfo) {
        log.info("新增参数：{}",JSON.toJSONString(workDateInfo));
        return projectWorkDateInfoMapper.insertSelective(workDateInfo);
    }
}
