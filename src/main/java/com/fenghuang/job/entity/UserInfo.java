package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.io.Serializable;

@Data
@ApiModel(value = "用户信息表")
public class UserInfo implements Serializable{
    private Integer id;

    private String userName;

    private String userNickname;

    private String userHead;

    private String idCard;

    private String password;

    private String wechat;

    private Integer gender;

    private String mobile;

    private String address;

    private String idCardX;

    private String idCardY;

    private Integer userStatus;

    private Long amount;

    private Integer userType;

    private Integer userLevel;

    private String emergencyContactName;

    private String emergencyContactMobile;

}