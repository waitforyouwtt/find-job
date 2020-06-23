package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserUploadTaskVoucher implements Serializable{

    private Integer id;

    private Integer userId;

    private Integer merchantId;

    private String voucherImages;

    private String explain;

    private Integer voucherStatus;

    private Integer isDelete;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

}