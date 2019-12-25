package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.ActivityMapper;
import com.fenghuang.job.entity.Activity;
import com.fenghuang.job.enums.ActivityStatusEnum;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.ExamineStatusEnum;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.request.ReqActivity;
import com.fenghuang.job.request.ReqActivityUpdate;
import com.fenghuang.job.service.ActivityService;
import com.fenghuang.job.view.ActivityView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 14:30
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityMapper activityMapper;
    /**
     * 新增活动
     *
     * @param reqActivity
     * @return
     */
    @Override
    public int insertActivity(ReqActivity reqActivity) {
        log.info("新增活动请求参数：{}", JSON.toJSONString(reqActivity));
        Activity queryActivity = activityMapper.queryActivityByTitle(reqActivity.getActivityTitle());
        if (queryActivity != null){
            throw new BusinessException(BusinessEnum.RECORD_ALREADY_EXISTS.getCode(),BusinessEnum.RECORD_ALREADY_EXISTS.getMsg());
        }
        Activity activity = new Activity();
        BeanCopier beanCopier = BeanCopier.create(ReqActivity.class,Activity.class,false);
        beanCopier.copy(reqActivity,activity,null);
        activity.setActivityStatus(ActivityStatusEnum.INIT.getCode());
        activity.setExamineStatus(ExamineStatusEnum.AUDITED.getCode());
        activity.setCreateDate(new Date());
        activity.setUpdateDate(new Date());
        return activityMapper.insertSelective(activity);
    }

    /**
     * 根据ID修改活动相关信息
     *
     * @param reqActivityUpdate
     * @return
     */
    @Override
    public int modifyActivity(ReqActivityUpdate reqActivityUpdate) {
        log.info("根据ID修改活动相关信息 请求参数：{}",JSON.toJSONString(reqActivityUpdate));
        Activity activity = new Activity();
        BeanCopier beanCopier = BeanCopier.create(ReqActivity.class,Activity.class,false);
        beanCopier.copy(reqActivityUpdate,activity,null);
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    /**
     * 根据id 查询活动详情
     *
     * @param id
     * @return
     */
    @Override
    public ActivityView findActivityById(Integer id) {
        log.info("根据id 查询活动详情 请求参数：{}",id);
        Activity activity = activityMapper.selectByPrimaryKey(id);
        if (activity == null){
            return null;
        }
        ActivityView view = new ActivityView();
        BeanCopier copier = BeanCopier.create(Activity.class,ActivityView.class,false);
        copier.copy(activity,view,null);
        return view;
    }
}
