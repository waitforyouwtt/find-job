package com.fenghuang.job.controller;

import com.fenghuang.job.exception.Result;
import com.fenghuang.job.request.ReqUserInfo;
import com.fenghuang.job.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 11:20
 * @Email: 15290810931@163.com
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "注册新用户")
    @PostMapping("/userRegister")
    public Result userRegister(@RequestBody ReqUserInfo reqUserInfo){
        return Result.success(userInfoService.insertUser(reqUserInfo));
    }

    @ApiOperation(value = "更新用户状态信息")
    @PostMapping("/modifyUserStatus")
    public Result modifyUserStatus(@RequestBody ReqUserInfo reqUserInfo){
        return Result.success(userInfoService.modifyUserInfo(reqUserInfo));
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/modifyUserInfo")
    public Result modifyUserInfo(@RequestBody ReqUserInfo reqUserInfo){
        return Result.success(userInfoService.modifyUserInfo(reqUserInfo));
    }

    @ApiOperation(value = "根据用户名获取一条或多条记录")
    @GetMapping("/findUserInfoByUserName")
    public Result findUserInfoByUserName(@RequestParam("userName") String userName){
      return Result.success(userInfoService.findUserInfoByUserName(userName)) ;
    }

    @ApiOperation(value = "根据用户id|用户昵称|用户手机号|身份证 获取唯一一条记录")
    @PostMapping("/findUserInfo")
    public Result findUserInfo(@RequestBody ReqUserInfo reqUserInfo){
      return Result.success(userInfoService.findUserInfo(reqUserInfo));
    }

    @PostMapping("/findUserInfoPage")
    @ApiOperation(value = "根据条件查询并进行分页")
    public Result findUserInfoPage(@RequestBody ReqUserInfo reqUserInfo){
       return Result.success(userInfoService.findUserInfoPage(reqUserInfo));
    }

    @PostMapping("/changePassword")
    @ApiOperation(value = "用户进行修改密码")
    public Result changePassword(ReqUserInfo reqUserInfo){
        return Result.success(userInfoService.changePassword(reqUserInfo));
    }

    @PostMapping("/messageRegister")
    public Result messageRegister(){
      return Result.success();
    }


}
