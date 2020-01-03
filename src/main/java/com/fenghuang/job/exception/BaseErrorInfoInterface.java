package com.fenghuang.job.exception;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/3 13:49
 * @Email: 15290810931@163.com
 */
public interface BaseErrorInfoInterface {

    /** 错误码*/
    Integer getCode();

    /** 错误描述*/
    String getMsg();
}
