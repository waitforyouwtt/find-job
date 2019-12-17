package com.fenghuang.job.controller;

import com.fenghuang.job.request.ReqUserInfo;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.view.UserInfoView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
    public int userRegister(@RequestBody ReqUserInfo reqUserInfo){
        return userInfoService.insertUser(reqUserInfo);
    }

    @ApiOperation(value = "根据用户名获取记录")
    @GetMapping("/findUserInfoByUserName")
    public UserInfoView findUserInfoByUserName(@RequestParam("userName") String userName){
      return userInfoService.findUserInfo(userName);
    }


}
