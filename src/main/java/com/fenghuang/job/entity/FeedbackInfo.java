package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FeedbackInfo implements Serializable {
    private Integer id;

    private Integer userId;

    private String userName;

    private String feedback;

    private Integer isRead;

    private Date createDate;

    private Date updateDate;

    private String founder;

    private String modifier;

}