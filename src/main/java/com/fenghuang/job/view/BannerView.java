package com.fenghuang.job.view;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/23 17:58
 * @Email: 15290810931@163.com
 */
@Data
@ApiModel(value = "banner")
public class BannerView implements Serializable {

    private Integer id;

    private Integer activityId;

    private String activityImg;

    private Integer rankField;

    private Integer bannerImgStatus;
}
