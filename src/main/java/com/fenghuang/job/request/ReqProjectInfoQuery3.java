package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 12:16
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqProjectInfoQuery3 implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("前端用户userId")
    private String userId;

    @ApiModelProperty("前端用户token")
    private String token;

    @ApiModelProperty("搜索关键字")
    private String queryKey;

}
