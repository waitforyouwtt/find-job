package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/10 18:48
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqBrowseRecordInfoQuery extends PageHelps implements Serializable {

    private Integer id;

    @ApiModelProperty("用户token")
    private String token;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("商家[用户]id")
    private Integer companyId;

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("兼职项目id")
    private Integer projectId;

    @ApiModelProperty("兼职项目名称")
    private String projectTitle;

    @ApiModelProperty("薪水")
    private BigDecimal salary;

    @ApiModelProperty("薪水单位：1 天 2 小时 3 月 4 次 5 单")
    private Integer salaryUnit;

    @ApiModelProperty("项目标签：1长期工 2 短期工 3寒假工 4暑假工 5钟点工")
    private String projectLabel;

    @ApiModelProperty("省份id")
    private Integer provinceId;

    @ApiModelProperty("省份名称")
    private String provinceTitle;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("城市名称")
    private String cityTitle;

    @ApiModelProperty("区域id")
    private Integer areaId;

    @ApiModelProperty("区域名称")
    private String areaTitle;

    @ApiModelProperty("上班详细地址")
    private String workAddress;

    @ApiModelProperty("是否删除：1 删除 2 未删除")
    private Integer isDelete;

    @ApiModelProperty("创建者")
    private String founder;

    @ApiModelProperty("修改者")
    private String modifier;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("修改时间")
    private Date updateDate;
}
