package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqSignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoByUserQuery;
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

    @ApiOperation(value = "前端用户点击报名保存兼职报名信息")
    @PostMapping("/insertSignUpInfo")
    public Result insertSignUpInfo(@RequestBody ReqSignUpInfo reqSignUpInfo,@RequestHeader("token") String token){
        reqSignUpInfo.setToken(token);
        return signUpInfoService.insertSignUpInfo(reqSignUpInfo);
    }

    @ApiOperation(value = "修改用户兼职报名信息状态")
    @PostMapping("/updateSignUpInfoState")
    public Result updateSignUpInfoState(ReqSignUpInfoUpdate reqSignUpInfoUpdate){
        return signUpInfoService.updateSignUpInfoState(reqSignUpInfoUpdate);
    }

    @ApiOperation(value = "前端用户取消报名")
    @PostMapping("/cancelSignUpInfo")
    public Result cancelSignUpInfo(@RequestBody ReqSignUpInfoUpdate reqSignUpInfoUpdate,@RequestHeader("token") String token){
        reqSignUpInfoUpdate.setToken(token);
        return signUpInfoService.cancelSignUpInfo(reqSignUpInfoUpdate);
    }

    @ApiOperation(value = "根据条件查询用户兼职报名记录且分页")
    @PostMapping("/findSignUpInfoPage")
    public Result findSignUpInfoPage(@RequestBody ReqSignUpInfoQuery reqSignUpInfoQuery){
        return Result.success( signUpInfoService.findSignUpInfoPage(reqSignUpInfoQuery) );
    }

    @ApiOperation(value = "根据条件查询用户兼职报名记录且分页[我的申请]")
    @PostMapping("/findUserInfoSignUpInfoPage")
    public Result findUserInfoSignUpInfoPage(@RequestBody ReqSignUpInfoByUserQuery reqSignUpInfoQuery,@RequestHeader("token") String token){
        reqSignUpInfoQuery.setToken(token);
        return signUpInfoService.findUserInfoSignUpInfoPage(reqSignUpInfoQuery);
    }

    @ApiOperation(value = "根据id查询用户兼职报名记录详情")
    @GetMapping("/findSignUpInfoById")
    public Result findSignUpInfoById(@RequestParam("id") Integer id,@RequestHeader("token") String token){
        return Result.success(signUpInfoService.findSignUpInfoById(id));
    }

}
