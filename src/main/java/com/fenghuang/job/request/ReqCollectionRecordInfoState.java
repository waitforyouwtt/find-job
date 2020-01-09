package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 16:26
 * @Email: 15290810931@163.com
 */
@Data
public class ReqCollectionRecordInfoState implements Serializable{

    private Integer id;

    @ApiModelProperty("项目id")
    private Integer projectId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("是否收藏：1 已收藏 2 取消收藏")
    private Integer collectionState;
}
