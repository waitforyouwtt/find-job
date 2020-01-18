package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "收藏记录表")
public class CollectionRecordInfo implements Serializable{

    private Integer id;

    private Integer userId;

    private Integer companyId;

    private String companyName;

    private Integer projectId;

    private String projectTitle;

    private BigDecimal salary;

    private Integer salaryUnit;

    private String projectLabel;

    private Integer provinceId;

    private String provinceTitle;

    private Integer cityId;

    private String cityTitle;

    private Integer areaId;

    private String areaTitle;

    private String workAddress;

    private Integer isCollection;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}