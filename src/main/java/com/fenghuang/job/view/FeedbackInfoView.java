package com.fenghuang.job.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/12 22:51
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class FeedbackInfoView implements Serializable {

    private String token;

    @ApiModelProperty("意见或反馈内容")
    private String feedback;
}
