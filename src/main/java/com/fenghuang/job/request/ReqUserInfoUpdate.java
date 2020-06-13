package com.fenghuang.job.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 9:50
 * @Email: 15290810931@163.com
 */
@Data
@ApiModel
public class ReqUserInfoUpdate implements Serializable {

    private Integer id;

    @ApiModelProperty("用户Id")
    private Integer userId;

    @ApiModelProperty("用户名token")
    private String token;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("生日")
    private String birthday;

    @ApiModelProperty("用户性别")
    private Integer gender;

    @ApiModelProperty("用户昵称")
    private String userNickname;

    @ApiModelProperty("用户头像")
    private String userHead;

    @ApiModelProperty("用户qq")
    private String qq;

    @ApiModelProperty("用户微信")
    private String wechat;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("新密码")
    private String newPassword;

    @ApiModelProperty("用户手机号")
    private String mobile;

    @ApiModelProperty("用户身份证号")
    private String idCard;

    @ApiModelProperty("用户身份证正面")
    private String idCardX;

    @ApiModelProperty("用户身份证反面")
    private String idCardY;

    @ApiModelProperty("省份ID")
    private Integer provinceId;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("县区ID")
    private Integer countyAreaId;

    @ApiModelProperty("用户详细地址")
    private String address;

    @ApiModelProperty("用户状态：1冻结，2正常")
    private Integer userStatus;

    @ApiModelProperty("用户类型：1个人 2 公司")
    private Integer userType;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("教育状态")
    private Integer educationStatus;

    @ApiModelProperty("学历")
    private Integer education;

    @ApiModelProperty("紧急联系人")
    private String emergencyContactName;

    @ApiModelProperty("紧急联系人手机号")
    private String emergencyContactMobile;

}
