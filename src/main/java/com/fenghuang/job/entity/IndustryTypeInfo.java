package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class IndustryTypeInfo implements Serializable {

    private Integer id;

    private Integer parentId;

    private String industryName;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;
}