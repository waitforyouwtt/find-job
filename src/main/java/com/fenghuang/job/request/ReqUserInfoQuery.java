package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 13:58
 * @Email: 15290810931@163.com
 */
@Data
public class ReqUserInfoQuery extends PageHelps implements Serializable{

    private Integer id;

    private String userName;

    private String userNickname;

    private String userHead;

    private String idCard;

    private String password;

    private String newPassword;

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

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;
}
