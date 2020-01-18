package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 21:50
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqSignUpInfo implements Serializable {

    private Integer id;

    @ApiModelProperty("用户token")
    private String token;

    @ApiModelProperty("项目id")
    private Integer projectId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户名字")
    private String userName;

    @ApiModelProperty("用户联系手机号")
    private String userMobile;

    @ApiModelProperty("用户特长")
    private String remarks;

    @ApiModelProperty("是否删除：1 删除 2 未删除")
    private Integer isDelete;

    @ApiModelProperty("是否删除：1 删除 2 未删除")
    private String isDeleteDesc;

    @ApiModelProperty("报名状态：1 待录用 2 已录用 3已结算 4 待评价 5 已取消")
    private Integer state;

    @ApiModelProperty("报名状态：1 待录用 2 已录用 3已结算 4 待评价 5 已取消")
    private String stateDesc;

    @ApiModelProperty("创建人")
    private String founder;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;
}
