package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 18:02
 * @Email: 15290810931@163.com
 */
@Data
public class ReqMessageCountQuery2 implements Serializable{

    private Integer userId;

    private String mobile;

    private Integer messageType;

    private String currentSendDate;
    private String oneHourAgoDate;

    private String sendIp;

}
