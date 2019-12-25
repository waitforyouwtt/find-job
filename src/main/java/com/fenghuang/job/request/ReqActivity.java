package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 14:18
 * @Email: 15290810931@163.com
 */
@Data
public class ReqActivity implements Serializable{

    private Integer id;

    private String activityTitle;

    private String activityContent;

    private Date activityCreateDate;

    private Date activityEndDate;

    private Integer activityStatus;

    private Integer examineStatus;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;
}
