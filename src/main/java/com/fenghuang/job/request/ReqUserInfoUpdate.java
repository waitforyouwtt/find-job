package com.fenghuang.job.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 9:50
 * @Email: 15290810931@163.com
 */
@Data
@ApiModel
public class ReqUserInfoUpdate implements Serializable {

    private Integer id;

    private String userNickname;

    private String userHead;

    private String password;

    private String newPassword;

    private String mobile;

    private String address;

    private Integer userStatus;

    private Integer userType;

    private String modifier;

    private String emergencyContactName;

    private String emergencyContactMobile;

}
