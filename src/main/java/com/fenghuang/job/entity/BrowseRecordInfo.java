package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "浏览记录表信息")
public class BrowseRecordInfo implements Serializable {

    private Integer id;

    private Integer userId;

    private Integer companyId;

    private String companyName;

    private Integer projectId;

    private String projectTitle;

    private Long salary;

    private Integer salaryUnit;

    private String projectLabel;

    private Integer provinceId;

    private String provinceTitle;

    private Integer cityId;

    private String cityTitle;

    private Integer areaId;

    private String areaTitle;

    private String workAddress;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}