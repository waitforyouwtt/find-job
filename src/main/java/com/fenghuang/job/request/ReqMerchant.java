package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/21 17:09
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqMerchant implements Serializable {

    private Integer id;

    @ApiModelProperty("商家账号")
    private String account;

    @ApiModelProperty("商家名称")
    private String merchantName;

    @ApiModelProperty("商家密码")
    private String password;

    @ApiModelProperty("商家用户头像")
    private String userHead;

    @ApiModelProperty("行业id")
    private Integer industryId;

    @ApiModelProperty("联系方式")
    private String mobile;

    @ApiModelProperty("省份id")
    private Integer provinceId;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("区域id")
    private Integer countyAreaId;

    @ApiModelProperty("商家详细地址")
    private String merchantAddress;

    @ApiModelProperty("营业执照")
    private String businessLicense;

}
