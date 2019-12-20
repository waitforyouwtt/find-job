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

    private String userName;

    private String userNickname;

    private String idCard;

    private String mobile;

    private String password;

    @ApiModelProperty(value = "登录方式：")
    private Integer loginType;
}
