package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/21 17:09
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqMerchantLogin implements Serializable {

    @ApiModelProperty("商家登录账号：可以是account | mobile")
    private String merchantLoginUser;

    @ApiModelProperty("商家密码")
    private String password;

}
