package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 10:28
 * @Email: 15290810931@163.com
 */
@Data
public class CashWithdrawalView implements Serializable{

    private Integer id;

    private String cashWithdrawalOrderId;

    private Integer userId;

    private BigDecimal cashWithdrawalAmount;

    private String cashWithdrawalAccount;

    private Integer cashWithdrawalAccountType;

    private Integer cashWithdrawalStatus;

    private Date cashWithdrawalDate;

    private Date examineDate;

}
