package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CollectionRecordInfo implements Serializable {

    private Integer id;

    private Integer userId;

    private Integer projectId;

    private String projectTitle;

    private Integer isCollection;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}