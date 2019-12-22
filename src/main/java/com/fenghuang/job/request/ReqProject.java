package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 12:16
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqProject extends PageHelps implements Serializable {

    private Integer id;

    private Integer projectTypeId;

    private String projectTypeName;

    private String createUserId;

    private String createUserName;

    private String projectTitle;

    private String projectContent;

    private Long projectMinPrice;

    private Long projectMaxPrice;

    private Integer projectStatus;

    private Integer examineStatus;

    private Integer projectNeedPeople;

    private Integer isDirectHire;

    private Integer isTrusteeship;

    private Long trusteeshipAmount;

    private Integer rankField;

    private Date projectCreateDate;

    private Date projectEndDate;

    private String sortField;

    private String sort;

    private String projectCreateDateBegin;
    private String projectCreateDateEnd;
    private String projectEndDateBegin;
    private String projectEndDateEnd;

    private String projectDateBegin;
    private String projectDateEnd;
}
