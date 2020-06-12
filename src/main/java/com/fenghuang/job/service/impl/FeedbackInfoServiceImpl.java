package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.FeedbackInfoMapper;
import com.fenghuang.job.entity.FeedbackInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.ReadStatusEnum;
import com.fenghuang.job.service.FeedbackInfoService;
import com.fenghuang.job.view.FeedbackInfoView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/12 22:52
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class FeedbackInfoServiceImpl implements FeedbackInfoService {

    @Resource
    FeedbackInfoMapper feedbackInfoMapper;

    @Autowired
    UserInfoByTokenSerivce userInfoByTokenSerivce;

    /**
     * 用户添加意见或反馈
     * @param infoView
     * @return
     */
    @Override
    public Result insertFeedbackInfo(FeedbackInfoView infoView) {
        log.info( "用户添加意见或反馈请求参数：{}", JSON.toJSONString(infoView) );

        Integer userId;
        String  userName ;
        Result userInfoByToken = userInfoByTokenSerivce.getUserInfoByToken(infoView.getToken());
        if (userInfoByToken.getCode() == 2001){
            return Result.error( BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        Map user = (Map) userInfoByToken.getData();
        userId = Integer.valueOf(user.get("userId").toString());
        userName = user.get("userName").toString();
        log.info("解析token获取的结果{},{}",userId,userName);

        FeedbackInfo feedbackInfo = new FeedbackInfo();
        feedbackInfo.setUserId( userId );
        feedbackInfo.setUserName( userName );
        feedbackInfo.setIsRead( ReadStatusEnum.NO.getCode() );
        feedbackInfo.setCreateTime( new Date(  ) );
        feedbackInfo.setUpdateTime( new Date(  ) );
        feedbackInfo.setFounder( userName );
        feedbackInfo.setModifier( userName );
        return Result.success(feedbackInfoMapper.insertSelective( feedbackInfo ));
    }
}
