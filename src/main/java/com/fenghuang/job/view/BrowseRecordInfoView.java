package com.fenghuang.job.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/10 18:50
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class BrowseRecordInfoView implements Serializable {

    @ApiModelProperty("浏览记录id")
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("商家[公司]id")
    private Integer companyId;

    @ApiModelProperty("商家[公司]名称")
    private String companyName;

    @ApiModelProperty("项目id")
    private Integer projectId;

    @ApiModelProperty("项目名称")
    private String projectTitle;

    @ApiModelProperty("薪水")
    private BigDecimal salary;

    @ApiModelProperty("薪水单位")
    private Integer salaryUnit;
    private String  salaryUnitDesc;

    @ApiModelProperty("项目标签")
    private String projectLabel;
    private List<String> projectLabelsDesc;

    @ApiModelProperty("省份id")
    private Integer provinceId;

    @ApiModelProperty("省份描述")
    private String provinceTitle;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("城市描述")
    private String cityTitle;

    @ApiModelProperty("区域id")
    private Integer areaId;

    @ApiModelProperty("区域描述")
    private String areaTitle;

    @ApiModelProperty("工作详细地址")
    private String workAddress;

    @ApiModelProperty("是否删除")
    private Integer isDelete;

    @ApiModelProperty("创建人")
    private String founder;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("修改时间")
    private Date updateDate;
}
