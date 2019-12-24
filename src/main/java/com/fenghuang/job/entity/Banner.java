package com.fenghuang.job.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "轮播图")
public class Banner implements Serializable {

    private Integer id;

    private Integer activityId;

    private String activityImg;

    private Integer rankField;

    private Integer bannerImgStatus;

}