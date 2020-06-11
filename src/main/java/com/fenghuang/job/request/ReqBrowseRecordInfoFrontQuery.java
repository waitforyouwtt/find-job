package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/10 18:48
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqBrowseRecordInfoFrontQuery extends PageHelps implements Serializable {

    private Integer id;

    @ApiModelProperty("用户token")
    private String token;

    @ApiModelProperty("用户id")
    private Integer userId;

}
