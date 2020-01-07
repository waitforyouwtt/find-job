package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/7 10:49
 * @Email: 15290810931@163.com
 */
@Data
public class ReqProjectWorkDateInfo implements Serializable{

    private Integer id;

    private Integer projectId;

    private Date workDateBegin;

    private Date workDateEnd;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createTime;

    private Date updateTime;
}
