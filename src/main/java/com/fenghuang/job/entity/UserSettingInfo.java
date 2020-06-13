package com.fenghuang.job.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserSettingInfo {

    private Integer id;

    private Integer userId;

    private Integer employmentIntention;

    private String personalSignature;

    private Integer sendLikeJob;

    private Integer sendEmail;

    private Integer sendMessage;

    private Integer sendWechant;

    private Integer sendPublicAccount;

    private String shieldCompanys;

    private Integer isPersonalInformationPublic;

    private Integer settingState;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;
}