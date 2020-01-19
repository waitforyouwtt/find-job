package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/19 11:05
 * @Email: 15290810931@163.com
 */
@Data
public class ReqUserInfoMessageQuery implements Serializable{

    @ApiModelProperty("前台用户登录token")
    private String token;
}
