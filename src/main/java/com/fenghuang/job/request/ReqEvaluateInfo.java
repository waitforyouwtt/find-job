package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 11:24
 * @Email: 15290810931@163.com
 */
@Data
public class ReqEvaluateInfo implements Serializable{

    private Integer id;

    @ApiModelProperty("用户token")
    private String token;

    @ApiModelProperty("项目id")
    private Integer projectId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("商家[公司]id")
    private Integer companyId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户手机号")
    private String userMobile;

    @ApiModelProperty("是否删除：1 删除 2 未删除")
    private Integer isDelete;

    @ApiModelProperty("评价星级")
    private Integer starLevel;

    @ApiModelProperty("评价内容")
    private String evaluateContent;

    @ApiModelProperty("评价来源： 1 用户对商家[公司]  2商家[公司]对用户")
    private Integer evaluateSource;

    @ApiModelProperty("创建人")
    private String founder;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("修改时间")
    private Date updateDate;
}
