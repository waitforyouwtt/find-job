package com.fenghuang.job.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/23 17:23
 * @Email: 15290810931@163.com
 */
@Data
public class ReqProjectStatus implements Serializable {

    private Integer id;

    private Integer projectStatus;

    private Integer examineStatus;

}
