package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/19 16:05
 * @Email: 15290810931@163.com
 */
@Data
public class LoginLogView implements Serializable{

    private Integer id;

    private Integer userId;

    private Integer loginStatus;

    private Date loginDate;

    private String failRemark;

    private String loginIp;
}
