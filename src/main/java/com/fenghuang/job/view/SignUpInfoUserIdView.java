package com.fenghuang.job.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 21:56
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class SignUpInfoUserIdView implements Serializable {

    private Integer id;

    private Integer projectId;

    private String projectTitle;

    @ApiModelProperty("报名状态：1 待录用 2 已录用 3已结算 4 待评价 5 已取消")
    private Integer signUpState;

    @ApiModelProperty("上班区域id")
    private Integer areaId;

    @ApiModelProperty("上班区域名称")
    private String  areaTitle;

    @ApiModelProperty("上班地址")
    private String workAddress;

    @ApiModelProperty("报名时间")
    private Date createDate;
}
