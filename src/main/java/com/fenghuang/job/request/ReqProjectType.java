package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 23:26
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqProjectType extends PageHelps implements Serializable {

    private Integer id;

    private Integer parentId;

    private String categoryName;

    private Double chargeRate;

    private Integer projectTypeStatus;

    private Double chargeRateMin;
    private Double chargeRateMax;

    @ApiModelProperty("创建人")
    private String founder;

    @ApiModelProperty("修改人")
    private String modifier;
}
