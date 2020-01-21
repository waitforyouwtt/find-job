package com.fenghuang.job.view;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/21 15:20
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ProjectTypeSearchView implements Serializable {

    private Integer id;
    private String text;
    private List<ProjectTypeSearchView> children;

}
