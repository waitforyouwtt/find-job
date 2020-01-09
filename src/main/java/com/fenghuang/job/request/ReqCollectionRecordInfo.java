package com.fenghuang.job.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 16:25
 * @Email: 15290810931@163.com
 */
@Data
public class ReqCollectionRecordInfo implements Serializable{

    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("商家[公司]id")
    private Integer companyId;

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("兼职项目id")
    private Integer projectId;

    @ApiModelProperty("兼职项目标题")
    private String projectTitle;

    @ApiModelProperty("薪水")
    private BigDecimal salary;

    @ApiModelProperty("薪水单位：1 天 2 小时 3 月 4 次 5 单")
    private Integer salaryUnit;

    @ApiModelProperty("项目标签：1长期工 2 短期工 3寒假工 4暑假工 5钟点工 ")
    private String projectLabel;

    @ApiModelProperty("省份id")
    private Integer provinceId;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("区域id")
    private Integer areaId;

    @ApiModelProperty("上班详细地址")
    private String workAddress;

    @ApiModelProperty("是否收藏：1 已收藏 2 取消收藏")
    private Integer isCollection;

    @ApiModelProperty("是否删除：1 删除 2 未删除")
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
