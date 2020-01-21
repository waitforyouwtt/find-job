package com.fenghuang.job.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 16:30
 * @Email: 15290810931@163.com
 */
@Data
public class CollectionRecordInfoView implements Serializable{

    private String collectionRecordInfoId;

    private Integer userId;

    private Integer isCollection;

    private Date createDate;

    private Date updateDate;

    private String userName;

    private Integer projectTypeId;

    private String projectTypeName;

    private Integer projectId;

    private String projectTitle;

    private String projectContent;

    private String projectAscriptionCompany;

    private Integer provinceId;

    private String provinceTitle;

    private Integer cityId;

    private String cityTitle;

    private Integer areaId;

    private String areaTitle;

    private String workAddress;

    private Integer genderRequirement;

    private String genderRequirementDesc;

    private String projectLabel;

    private List<String> projectLabelsDesc;

    private BigDecimal salary;

    private Integer salaryUnit;

    private String salaryUnitDesc;

    private String settlementCycle;

    private String workWelfaresId;

    private List<String> workWelfaresIdDesc;

    private Integer projectNeedNum;

    private String projectContactsName;

    private String projectContactsMobile;

    private String projectContactsEmail;

    private String projectSkill;

    private String workTimeNum;

    private String workTimeUnit;

    private String workTimeRequirement;

    private Date projectBeginTime;

    private Date projectEndTime;

    private String projectRemark;

    private Integer projectState;

    private String projectStateDesc;

    private Integer examineStatus;

    private String examineStatusDesc;

}
