package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProjectInfo implements Serializable{

    private Integer id;

    private Integer userId;

    private String projectTitle;

    private String projectContent;

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

    private Integer projectLabels;

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

    private Date createTime;

    private Date updateTime;

}