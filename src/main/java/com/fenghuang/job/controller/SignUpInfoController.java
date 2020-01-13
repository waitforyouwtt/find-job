package com.fenghuang.job.controller;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqSignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoQuery;
import com.fenghuang.job.request.ReqSignUpInfoUpdate;
import com.fenghuang.job.service.SignUpInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 21:40
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Api(value = "用户兼职报名信息表相关接口",description = "用户兼职报名信息表相关接口")
@RestController
public class SignUpInfoController {

    @Autowired
    SignUpInfoService signUpInfoService;

    @ApiOperation(value = "保存用户兼职报名信息")
    @PostMapping("/insertSignUpInfo")
    public Result insertSignUpInfo(ReqSignUpInfo reqSignUpInfo){
        return signUpInfoService.insertSignUpInfo(reqSignUpInfo);
    }

    @ApiOperation(value = "修改用户兼职报名信息状态")
    @PostMapping("/updateSignUpInfoState")
    public Result updateSignUpInfoState(ReqSignUpInfoUpdate reqSignUpInfoUpdate){
        return signUpInfoService.updateSignUpInfoState(reqSignUpInfoUpdate);
    }

    @ApiOperation(value = "根据条件查询用户兼职报名记录且分页")
    @PostMapping("/findSignUpInfoPage")
    public Result findSignUpInfoPage(@RequestBody ReqSignUpInfoQuery reqSignUpInfoQuery){
        return Result.success( signUpInfoService.findSignUpInfoPage(reqSignUpInfoQuery) );
    }

    @ApiOperation(value = "根据id查询用户兼职报名记录详情")
    @GetMapping("/findSignUpInfoById")
    public Result findSignUpInfoById(@RequestParam("id") Integer id){
        return Result.success(signUpInfoService.findSignUpInfoById(id));
    }

}
