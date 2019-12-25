package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 14:43
 * @Email: 15290810931@163.com
 */
@Data
public class ReqActivityQuery implements Serializable{

    private String activityTitle;

    private Integer activityStatus;
}
