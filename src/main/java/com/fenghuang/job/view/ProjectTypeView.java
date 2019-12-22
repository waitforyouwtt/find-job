package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 10:44
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ProjectTypeView implements Serializable {

    private Integer id;

    private Integer parentId;

    private String categoryName;

    private Double chargeRate;

    private Integer projectTypeStatus;
}
