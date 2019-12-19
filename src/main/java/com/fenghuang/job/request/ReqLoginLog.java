package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/19 16:03
 * @Email: 15290810931@163.com
 */
@Data
public class ReqLoginLog extends PageHelps implements Serializable{

    private Integer id;

    private Integer userId;

    private Integer loginStatus;

    private Date loginDate;

    private String failRemark;

    private String loginIp;

    private String loginDateBegin;

    private String loginDateEnd;
}
