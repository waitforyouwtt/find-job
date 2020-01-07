package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "上班时段信息表")
public class ProjectWorkTimeInfo implements Serializable {
    private Integer id;

    private Integer projectId;

    private Date workTimeBegin;

    private Date workTimeEnd;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}