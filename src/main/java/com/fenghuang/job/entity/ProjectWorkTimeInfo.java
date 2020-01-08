package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProjectWorkTimeInfo implements Serializable{
    private Integer id;

    private Integer projectId;

    private String workTimeBegin;

    private String workTimeEnd;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}