package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 11:04
 * @Email: 15290810931@163.com
 */
@Data
public class UserInfoView implements Serializable{

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

    private BigDecimal amount;

    private Integer userType;

    private Integer userLevel;

    private String emergencyContactName;

    private String emergencyContactMobile;
}
