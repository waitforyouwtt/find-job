package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Merchant implements Serializable {

    private Integer id;

    private String account;

    private String merchantName;

    private String password;

    private String userHead;

    private Integer industryId;

    private String mobile;

    private Integer provinceId;

    private Integer cityId;

    private Integer countyAreaId;

    private String merchantAddress;

    private String businessLicense;

    private String idCard;

    private String idCardX;

    private String idCardY;

    private Integer userLevel;

    private Integer status;

    private Date createDate;

    private Date updateDate;
}