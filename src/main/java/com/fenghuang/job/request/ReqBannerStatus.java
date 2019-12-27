package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/23 17:57
 * @Email: 15290810931@163.com
 */
@Data
public class ReqBannerStatus implements Serializable{

    private Integer id;

    private Integer activityId;

    private String activityImg;

    private Integer rankField;

    private Integer bannerImgStatus;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;
}
