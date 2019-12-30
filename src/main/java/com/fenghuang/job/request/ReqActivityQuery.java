package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 14:43
 * @Email: 15290810931@163.com
 */
@Data
public class ReqActivityQuery extends PageHelps implements Serializable{

    private Integer id;

    @ApiModelProperty("活动标题")
    private String activityTitle;
    @ApiModelProperty("活动状态：1 初始化 2 有效 3 失效")
    private Integer activityStatus;
    @ApiModelProperty("审核状态：1 待审核 2 已通过 3已驳回")
    private Integer examineStatus;
}
