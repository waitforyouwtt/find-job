package com.fenghuang.job.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/13 17:33
 * @Email: 15290810931@163.com
 */
@Data
public class UserInfoManagerView implements Serializable{

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String userNickName;

    @ApiModelProperty("用户手机号")
    private String mobile;

    @ApiModelProperty("余额")
    private BigDecimal amount;

    @ApiModelProperty("用户性别")
    private Integer gender;

    @ApiModelProperty("用户性别：1 男 2 女")
    private String  genderDesc;

    @ApiModelProperty("用户收藏数量")
    private Integer collectionNum;

    @ApiModelProperty("用户浏览记录数量")
    private Integer browseNum;
}
