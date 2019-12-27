package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 14:43
 * @Email: 15290810931@163.com
 */
@Data
public class ReqActivityQuery extends PageHelps implements Serializable{

    private Integer id;

    private String activityTitle;

    private Integer activityStatus;

    private Integer examineStatus;
}
