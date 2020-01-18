package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 21:55
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqSignUpInfoByUserQuery extends PageHelps implements Serializable {

    private Integer id;

    @ApiModelProperty("前端用户token")
    private String token;

    @ApiModelProperty("用户Id")
    private Integer userId;

    @ApiModelProperty("项目id")
    private Integer projectId;

    @ApiModelProperty("报名状态：1 待录用 2 已录用 3已结算 4 待评价 5 已取消")
    private Integer signUpState;
}
