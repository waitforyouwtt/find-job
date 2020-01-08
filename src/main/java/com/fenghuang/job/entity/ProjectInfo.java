package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "项目兼职信息表")
public class ProjectInfo implements Serializable{
    private Integer id;

    private String orderId;

    private Integer userId;

    private String projectTitle;

    private String projectContent;

    private BigDecimal totalpayAmount;

    private BigDecimal serviceCharge;

    private BigDecimal serviceChargeRate;

    private Integer orderState;

    private Integer projectTypeId;

    private String projectTypeName;

    private String projectAscriptionCompany;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String workAddress;

    private Integer projectState;

    private Integer examineStatus;

    private Integer isDelete;

    private Integer genderRequirement;

    private Integer projectLabel;

    private Integer salaryUnit;

    private Integer settlementCycle;

    private Integer workWelfaresId;

    private Integer projectNeedNum;

    private String projectContactsName;

    private String projectContactsMobile;

    private String projectContactsEmail;

    private String projectSkill;

    private Integer workTimeNum;

    private String workTimeUnit;

    private Date workTimeIntervalMin;

    private Date workTimeIntervalMax;

    private String workTimeRequirement;

    private Date projectBeginTime;

    private Date projectEndTime;

    private String projectRemark;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}