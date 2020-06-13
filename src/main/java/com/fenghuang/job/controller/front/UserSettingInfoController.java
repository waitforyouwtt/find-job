package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqUserSettingInfo;
import com.fenghuang.job.service.UserSettingInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/13 8:49
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class UserSettingInfoController {

    @Autowired
    UserSettingInfoService userSettingInfoService;

    @ApiOperation(value = "保存用户个性化设置")
    @PostMapping("/saveOrUpdateUserSettingInfo")
    public Result addUserSettingInfo(@RequestBody ReqUserSettingInfo reqUserSettingInfo, @RequestHeader("token") String token){
        reqUserSettingInfo.setToken(token);
      return userSettingInfoService.saveOrUpdateUserSettingInfo(reqUserSettingInfo);
    }

    @ApiOperation(value = "查询用户个性化设置")
    @PostMapping("/findUserSettingInfo")
    public Result findUserSettingInfo(@RequestHeader("token") String token){
        return userSettingInfoService.findUserSettingInfo(token);
    }

}
