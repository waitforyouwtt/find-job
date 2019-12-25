package com.fenghuang.job.controller;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqActivity;
import com.fenghuang.job.request.ReqActivityUpdate;
import com.fenghuang.job.service.ActivityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 14:16
 * @Email: 15290810931@163.com
 */
@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @ApiOperation(value = "新增活动")
    @PostMapping(value = "/insertActivity")
    public Result insertActivity(ReqActivity reqActivity){
        return Result.success(activityService.insertActivity(reqActivity));
    }

    @ApiOperation(value = "根据ID修改活动相关信息")
    @PostMapping("/modifyActivity")
    public Result modifyActivity(ReqActivityUpdate reqActivityUpdate){
        return Result.success(activityService.modifyActivity(reqActivityUpdate));
    }

    @ApiOperation(value = "根据id 查询活动详情")
    @GetMapping("/findActivityById")
    public Result findActivityById(@RequestParam("id") Integer id){
        return Result.success(activityService.findActivityById(id));
    }

}
