package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.view.FeedbackInfoView;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/12 22:49
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface FeedbackInfoService {

    /**
     * 用户添加意见或反馈
     * @param infoView
     * @return
     */
    Result insertFeedbackInfo(FeedbackInfoView infoView);
}
