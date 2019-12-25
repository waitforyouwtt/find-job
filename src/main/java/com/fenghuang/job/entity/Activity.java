package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "活动信息表")
public class Activity implements Serializable{
    private Integer id;

    private String activityTitle;

    private String activityContent;

    private Date activityCreateDate;

    private Date activityEndDate;

    private Integer activityStatus;

    private Integer examineStatus;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}