package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/13 17:33
 * @Email: 15290810931@163.com
 */
@Data
public class UserInfoManagerView implements Serializable{

    private Integer userId;

    private String userName;

    private String userNickName;

    private String mobile;

    private Integer gender;

    private String  genderDesc;
}
