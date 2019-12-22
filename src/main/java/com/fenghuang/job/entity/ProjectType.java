package com.fenghuang.job.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectType implements Serializable {

    private Integer id;

    private Integer parentId;

    private String categoryName;

    private Double chargeRate;

    private Integer projectTypeStatus;

}