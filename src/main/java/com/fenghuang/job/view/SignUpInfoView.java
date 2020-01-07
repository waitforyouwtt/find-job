package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 21:56
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class SignUpInfoView implements Serializable {

    private Integer id;

    private Integer projectId;

    private Integer userId;

    private String userName;

    private String userMobile;

    private Integer isDelete;
    private String deleteDesc;

    private Integer state;
    private String  stateDesc;

    private String founder;

    private String modifier;

    private Date createTime;

    private Date updateTime;
}
