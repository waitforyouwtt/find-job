package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 21:34
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class OrderInfoView implements Serializable {

    private Integer id;

    private String orderId;

    private Integer businessId;

    private Integer userId;

    private Integer projectTypeId;

    private String projectTypeName;

    private BigDecimal projectAmount;

    private BigDecimal orderAmount;

    private Integer projectId;

    private String projectName;

    private Integer orderStatus;

    private String remark;

    private Date orderDate;

    private Date orderPayDate;
}
