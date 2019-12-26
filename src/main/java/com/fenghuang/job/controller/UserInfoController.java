package com.fenghuang.job.controller;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.*;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.utils.BusinessUtils;
import com.fenghuang.job.view.RegisterCodeView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 11:20
 * @Email: 15290810931@163.com
 */
@Api(value = "用户信息表相关接口",description = "用户信息表相关接口")
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
    public Result modifyUserStatus(@RequestBody ReqUserInfoUpdate reqUserInfoUpdate){
        return Result.success(userInfoService.modifyUserInfo(reqUserInfoUpdate));
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/modifyUserInfo")
    public Result modifyUserInfo(@RequestBody ReqUserInfoUpdate reqUserInfoUpdate){
        return Result.success(userInfoService.modifyUserInfo(reqUserInfoUpdate));
    }

    @ApiOperation(value = "根据用户名获取用户信息记录[可能有重名的人]")
    @GetMapping("/findUserInfoByUserName")
    public Result findUserInfoByUserName(@RequestParam("userName") String userName){
      return Result.success(userInfoService.findUserInfoByUserName(userName)) ;
    }

    @ApiOperation(value = "根据用户id|用户昵称|用户手机号|身份证 获取唯一一条用户信息记录")
    @PostMapping("/findUserInfo")
    public Result findUserInfo(@RequestBody ReqUserInfoQuery reqUserInfoQuery){
      return Result.success(userInfoService.findUserInfo(reqUserInfoQuery));
    }

    @PostMapping("/findUserInfoPage")
    @ApiOperation(value = "根据条件查询用户信息并进行分页")
    public Result findUserInfoPage(@RequestBody ReqUserInfoQuery reqUserInfoQuery){
       return Result.success(userInfoService.findUserInfoPage(reqUserInfoQuery));
    }

    @PostMapping("/changePassword")
    @ApiOperation(value = "用户进行修改密码")
    public Result changePassword(ReqUserInfoUpdate reqUserInfoUpdate){
        return Result.success(userInfoService.changePassword(reqUserInfoUpdate));
    }

    @PostMapping("/messageRegister")
    @ApiOperation(value = "用户短信注册，发送验证码")
    public Result messageRegister(ReqMessage reqMessage){
      return Result.success(userInfoService.messageRegister(reqMessage));
    }

    @PostMapping("/checkRegisterCode")
    @ApiOperation(value = "用户短信注册，输入密码并校验验证码，验证通过则注册成功，验证失败则注册失败")
    public Result checkRegisterCode(RegisterCodeView registerCodeView) {
        return Result.success(userInfoService.checkRegisterCode(registerCodeView));
    }

    @PostMapping("/login")
    @ApiOperation(value = "根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录")
    public Result login(ReqLoginUserInfo reqLoginUserInfo,HttpServletRequest request){
        String ip = BusinessUtils.getIpAddress(request);
        reqLoginUserInfo.setLoginIp(ip);
        return Result.success(userInfoService.login(reqLoginUserInfo));
    }

    @ApiOperation(value = "根据Id 获取用户记录详情")
    @GetMapping("/findUserById")
    public Result findUserById(@RequestParam("id") Integer id){
        return Result.success(userInfoService.findUserById(id));
    }


}
