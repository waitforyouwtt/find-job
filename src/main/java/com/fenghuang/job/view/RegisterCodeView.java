package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/19 18:18
 * @Email: 15290810931@163.com
 */
@Data
public class RegisterCodeView implements Serializable{

    private String mobile;

    private String registerCode;

    private String password;

    private String repeatPassword;
}
