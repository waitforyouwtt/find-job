package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.ProjectWorkTimeInfoMapper;
import com.fenghuang.job.entity.ProjectWorkTimeInfo;
import com.fenghuang.job.request.ReqProjectWorkTimeInfo;
import com.fenghuang.job.service.ProjectWorkTimeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/7 11:10
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class ProjectWorkTimeInfoServiceImpl implements ProjectWorkTimeInfoService {

    @Autowired
    ProjectWorkTimeInfoMapper projectWorkTimeInfoMapper;
    /**
     * 添加上班时段
     *
     * @param reqProjectWorkTimeInfo
     */
    @Override
    public int insertProjectWorkTimeInfo(ReqProjectWorkTimeInfo reqProjectWorkTimeInfo) {
        log.info("添加上班时段 请求参数：{}", JSON.toJSONString(reqProjectWorkTimeInfo));
        ProjectWorkTimeInfo projectWorkTimeInfo = new ProjectWorkTimeInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqProjectWorkTimeInfo.class,ProjectWorkTimeInfo.class,false);
        beanCopier.copy(reqProjectWorkTimeInfo,projectWorkTimeInfo,null);
        return projectWorkTimeInfoMapper.insertSelective(projectWorkTimeInfo);
    }
}
