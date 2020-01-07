package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "用户兼职报名表")
public class SignUpInfo implements Serializable{

    private Integer id;

    private Integer projectId;

    private Integer userId;

    private String userName;

    private String userMobile;

    private Integer isDelete;

    private Integer state;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;
}