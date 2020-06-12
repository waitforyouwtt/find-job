package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.service.FeedbackInfoService;
import com.fenghuang.job.view.FeedbackInfoView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/12 22:49
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class FeedbackInfoController {

    @Autowired
    FeedbackInfoService feedbackInfoService;

    @ApiOperation(value = "新增用户意见或反馈记录")
    @PostMapping("/insertFeedbackInfo")
    public Result insertFeedbackInfo(@RequestBody FeedbackInfoView infoView, @RequestHeader("token") String token ){
        infoView.setToken( token );
        return feedbackInfoService.insertFeedbackInfo( infoView );
    }
}
