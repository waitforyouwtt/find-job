package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 12:16
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqProjectInfoQuery4 implements Serializable {

    @ApiModelProperty("前端用户token")
    private String token;

    @ApiModelProperty("商家用户Id")
    private Integer businessId;

    @ApiModelProperty("申请状态")
    private Integer state;

    @ApiModelProperty("项目标题")
    private String projectTitle;

    @ApiModelProperty("项目类型")
    private String projectTypeName;

}
