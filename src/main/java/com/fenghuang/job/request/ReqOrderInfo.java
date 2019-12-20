package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 21:22
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqOrderInfo extends PageHelps implements Serializable {

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

    private String orderDateBegin;
    private String orderDateEnd;

    private String orderPayDateBegin;
    private String orderPayDateEnd;

}
