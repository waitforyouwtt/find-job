package com.fenghuang.job.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/2 10:34
 * @Email: 15290810931@163.com
 */
@Data
@AllArgsConstructor
public class RequestResult {

    /** 状态码 */
    private int code;

    /** 返回body */
    private  String body;
}
