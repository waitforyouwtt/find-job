package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: luoxian
 * @Date: 2020/6/10 18:28
 * @Email: 15290810931@163.com
 */
@Data
public class PartTimeJobListView implements Serializable {

    private String projectId;

    private String projectTitle;

    private String projectTypeName;

    private String businessId;

    private String businessName;

    private String applyUserId;

    private String applyUserName;

    private Integer state;

    private Date applyTime;

    private Date approveTime;
}
