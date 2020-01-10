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
public class BbsAreaView2 implements Serializable{

    @ApiModelProperty("上级id")
    private Integer parentId;

    @ApiModelProperty("上级名称")
    private String parentTitle;

    @ApiModelProperty("父级id")
    private Integer pid;

    @ApiModelProperty("子级id")
    private Integer sonId;

    @ApiModelProperty("子级名称")
    private String sonTitle;

    @ApiModelProperty("父级id")
    private Integer sonPid;

    @ApiModelProperty("县区级id")
    private Integer areaId;

    @ApiModelProperty("县区级名称")
    private String areaTitle;

    @ApiModelProperty("县区级id")
    private Integer areaPid;



}
