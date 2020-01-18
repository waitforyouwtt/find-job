package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 21:51
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqSignUpInfoUpdate implements Serializable {

    private Integer id;

    private Integer signUpId;

    private Integer projectId;

    private String token;

    private Integer userId;

    private String userName;

    private String userMobile;

    private Integer state;

    private String founder;

    private String modifier;

    private Date createTime;

    private Date updateTime;
}
