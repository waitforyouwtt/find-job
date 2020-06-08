package com.fenghuang.job.request;

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
    private String loginUser;

    private String mobile;

    private String password;

    private String verificationCode;

    private String LoginIp;

}
