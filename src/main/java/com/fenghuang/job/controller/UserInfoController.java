package com.fenghuang.job.controller;

import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.view.UserInfoView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 11:20
 * @Email: 15290810931@163.com
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "根据用户名获取记录")
    @GetMapping("/findUserInfoByUserName")
    public UserInfoView findUserInfoByUserName(@RequestParam("userName") String userName){
      return userInfoService.findUserInfo(userName);
    }

    @ApiOperation(value = "根据用户名获取记录")
    @GetMapping("/findUserInfoByUserName2")
    public UserInfoView findUserInfoByUserName2(@RequestParam("userName") String userName){
        return userInfoService.findUserInfo2(userName);
    }


}
