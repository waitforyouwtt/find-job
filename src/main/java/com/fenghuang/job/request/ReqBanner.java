package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/23 17:51
 * @Email: 15290810931@163.com
 */
@Data
public class ReqBanner implements Serializable {

    private Integer id;

    private Integer activityId;

    private String activityImg;

    private Integer rankField;

    private Integer bannerImgStatus;
}
