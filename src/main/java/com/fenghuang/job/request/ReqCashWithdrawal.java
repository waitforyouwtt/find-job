package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 10:56
 * @Email: 15290810931@163.com
 */
@Data
public class ReqCashWithdrawal extends PageHelps implements Serializable{

    private Integer id;

    private String cashWithdrawalOrderId;

    private Integer userId;

    private Long cashWithdrawalAmount;

    private String cashWithdrawalAccount;

    private Integer cashWithdrawalAccountType;

    private Integer cashWithdrawalStatus;

    private Date cashWithdrawalDate;

    private Date examineDate;

    private String cashWithdrawalDateBegin;
    private String cashWithdrawalDateEnd;

    private String examineDateBegin;
    private String examineDateEnd;
}
