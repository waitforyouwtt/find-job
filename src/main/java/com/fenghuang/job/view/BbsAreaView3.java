package com.fenghuang.job.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/30 14:47
 * @Email: 15290810931@163.com
 */
@Data
public class BbsAreaView3 implements Serializable{

    @ApiModelProperty("省份Id")
    private Integer provinceId;

    @ApiModelProperty("省份描述")
    private String  provinceDesc;

    @ApiModelProperty("城市Id")
    private Integer cityId;

    @ApiModelProperty("城市描述")
    private String  cityDesc;

    @ApiModelProperty("区域Id")
    private Integer countyAreaId;

    @ApiModelProperty("区域描述")
    private String  countyAreaDesc;

}
