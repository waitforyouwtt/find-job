package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 18:02
 * @Email: 15290810931@163.com
 */
@Data
public class ReqMessageCountQuery extends PageHelps implements Serializable{

    private Integer id;

    private Integer userId;

    private String mobile;

    private String sendContent;

    private Date sendDate;

    private String sendIp;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;
}