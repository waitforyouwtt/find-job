package com.fenghuang.job.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * @Author: luoxian
 * @Date: 2020/6/16 18:34
 * @Email: 15290810931@163.com
 */
@Data
public class ProjectESByParamsView implements Serializable {

    @ApiModelProperty("商家id")
    private Integer userId;

    @ApiModelProperty("项目类型id")
    private Integer projectTypeId;

    @ApiModelProperty("项目兼职标题")
    private String projectTitle;

    @ApiModelProperty("省份id")
    private Integer provinceId;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("地区id")
    private Integer areaId;

    @ApiModelProperty("项目标签：1长期工 2 短期工 3寒假工 4暑假工 5钟点工")
    private String projectLabel;

}
