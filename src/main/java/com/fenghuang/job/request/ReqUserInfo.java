package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 13:58
 * @Email: 15290810931@163.com
 */
@Data
public class ReqUserInfo implements Serializable{

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
