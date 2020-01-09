package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "评价表")
public class EvaluateInfo implements Serializable{

    private Integer id;

    private Integer projectId;

    private Integer userId;

    private Integer companyId;

    private String userName;

    private String userMobile;

    private Integer isDelete;

    private Integer starLevel;

    private String evaluateContent;

    private Integer evaluateSource;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}