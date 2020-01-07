package com.fenghuang.job.request;

import com.fenghuang.job.utils.PageHelps;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 12:16
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqProjectInfo extends PageHelps implements Serializable {

    private Integer id;

    @ApiModelProperty("商家用户id")
    private Integer userId;

    @ApiModelProperty("项目兼职标题")
    private String projectTitle;

    @ApiModelProperty("项目兼职内容描述")
    private String projectContent;

    @ApiModelProperty("项目类型id")
    private Integer projectTypeId;

    @ApiModelProperty("项目类型名称")
    private String projectTypeName;

    @ApiModelProperty("项目所属公司")
    private String projectAscriptionCompany;

    @ApiModelProperty("省份id")
    private Integer provinceId;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("地区id")
    private Integer areaId;

    @ApiModelProperty("上班详细地址")
    private String workAddress;

    @ApiModelProperty("项目状态：1 项目发布 2 用户报名 3 开始工作 4交易完成")
    private Integer projectState;

    @ApiModelProperty("审核状态 1待审核 2 已通过 3 已驳回")
    private Integer examineStatus;

    @ApiModelProperty("是否删除：1 删除 2 未删除")
    private Integer isDelete;

    @ApiModelProperty("性别要求：1 男 2 女 3 不限")
    private Integer genderRequirement;

    @ApiModelProperty("项目标签：1长期工 2 短期工 3寒假工 4暑假工 5钟点工")
    private Integer projectLabel;

    @ApiModelProperty("工资单位：1 天 2 小时 3 月 4 次 5 单")
    private Integer salaryUnit;

    @ApiModelProperty("结算周期：1 完工结 2 日结 3 周结 4 月结")
    private Integer settlementCycle;

    @ApiModelProperty("工作福利")
    private Integer workWelfaresId;

    @ApiModelProperty("项目需要人数")
    private Integer projectNeedNum;

    @ApiModelProperty("项目联系人姓名")
    private String projectContactsName;

    @ApiModelProperty("项目联系人手机号")
    private String projectContactsMobile;

    @ApiModelProperty("项目联系人邮箱")
    private String projectContactsEmail;

    @ApiModelProperty("项目要求技能")
    private String projectSkill;

    @ApiModelProperty("工作时间数")
    private Integer workTimeNum;

    @ApiModelProperty("工作时间单位：1.小时 2.天 3.月 4年")
    private String workTimeUnit;

    @ApiModelProperty("上班时段[开始时间]")
    private Date workTimeIntervalMin;

    @ApiModelProperty("上班时段[结束时间]")
    private Date workTimeIntervalMax;

    @ApiModelProperty("上班时间要求")
    private String workTimeRequirement;

    @ApiModelProperty("项目开始时间")
    private Date projectBeginTime;

    @ApiModelProperty("项目结束时间")
    private Date projectEndTime;

    @ApiModelProperty("项目备注")
    private String projectRemark;

    @ApiModelProperty("创建人")
    private String founder;

    @ApiModelProperty("修改人")
    private String modifier;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("修改时间")
    private Date updateDate;


    @ApiModelProperty("项目标签")
    private List<String> projectLabels;

    @ApiModelProperty("项目金额min")
    private BigDecimal projectMinPrice;

    @ApiModelProperty("项目金额max")
    private BigDecimal projectMaxPrice;

    @ApiModelProperty("项目状态： 1 初始化 2进行中 3 结束")
    private Integer projectStatus;



    @ApiModelProperty("项目需要人数")
    private Integer projectNeedPeople;

    @ApiModelProperty("是否直接雇佣：1 是 2 否")
    private Integer isDirectHire;

    @ApiModelProperty("项目是否托管： 1 托管 2 不托管，3 已付定金")
    private Integer isTrusteeship;

    @ApiModelProperty("项目托管金额")
    private BigDecimal trusteeshipAmount;

    @ApiModelProperty("排序")
    private Integer rankField;

    @ApiModelProperty("项目创建时间")
    private Date projectCreateDate;

    @ApiModelProperty("项目截止时间")
    private Date projectEndDate;

    @ApiModelProperty("排序字段")
    private String sortField;

    @ApiModelProperty("排序类型：1升序 2 降序")
    private String sort;

    @ApiModelProperty("按项目创建时间查询：开始时间")
    private String projectCreateDateBegin;

    @ApiModelProperty("按项目创建时间查询：结束时间")
    private String projectCreateDateEnd;

    @ApiModelProperty("按项目截止时间查询：开始时间")
    private String projectEndDateBegin;

    @ApiModelProperty("按项目截止时间查询：结束时间")
    private String projectEndDateEnd;

    @ApiModelProperty("按项目时间查询：开始时间")
    private String projectDateBegin;

    @ApiModelProperty("按项目时间查询：开始时间")
    private String projectDateEnd;
}
