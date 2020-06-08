package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 13:44
 * @Email: 15290810931@163.com
 */
@Data
public class ReqLoginUserInfo implements Serializable {

    //可以是：[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录
    @ApiModelProperty("登陆用户名|用户昵称|手机号|身份证")
    private String loginUser;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("验证码")
    private String verificationCode;

    @ApiModelProperty("客户端ip")
    private String LoginIp;

}
