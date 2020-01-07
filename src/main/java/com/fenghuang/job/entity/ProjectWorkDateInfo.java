package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "上班日期信息表")
public class ProjectWorkDateInfo implements Serializable {
    private Integer id;

    private Integer projectId;

    private Date workDateBegin;

    private Date workDateEnd;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;
}