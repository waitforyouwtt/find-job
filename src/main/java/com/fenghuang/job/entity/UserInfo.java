package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserInfo implements Serializable{
    private Integer id;

    private String userName;

    private String userNickname;

    private String idCard;

    private String userHead;

    private String password;

    private String wechat;

    private Integer gender;

    private String mobile;

    private Integer provinceId;

    private Integer cityId;

    private Integer countyAreaId;

    private String address;

    private String idCardX;

    private String idCardY;

    private Integer userStatus;

    private BigDecimal amount;

    private Integer userType;

    private Integer userLevel;

    private String emergencyContactName;

    private String emergencyContactMobile;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}