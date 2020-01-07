package com.fenghuang.job.entity;

import java.util.Date;

public class ProjectInfo {
    private Integer id;

    private Integer userId;

    private String projectTitle;

    private String projectContent;

    private Integer projectTypeId;

    private String projectTypeName;

    private String projectAscriptionCompany;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String workAddress;

    private Integer projectState;

    private Integer examineStatus;

    private Integer isDelete;

    private Integer genderRequirement;

    private Integer projectLabel;

    private Integer salaryUnit;

    private Integer settlementCycle;

    private Integer workWelfaresId;

    private Integer projectNeedNum;

    private String projectContactsName;

    private String projectContactsMobile;

    private String projectContactsEmail;

    private String projectSkill;

    private Integer workTimeNum;

    private String workTimeUnit;

    private Date workTimeIntervalMin;

    private Date workTimeIntervalMax;

    private String workTimeRequirement;

    private Date projectBeginTime;

    private Date projectEndTime;

    private String projectRemark;

    private String founder;

    private String modifier;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle == null ? null : projectTitle.trim();
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
    }

    public Integer getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName == null ? null : projectTypeName.trim();
    }

    public String getProjectAscriptionCompany() {
        return projectAscriptionCompany;
    }

    public void setProjectAscriptionCompany(String projectAscriptionCompany) {
        this.projectAscriptionCompany = projectAscriptionCompany == null ? null : projectAscriptionCompany.trim();
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress == null ? null : workAddress.trim();
    }

    public Integer getProjectState() {
        return projectState;
    }

    public void setProjectState(Integer projectState) {
        this.projectState = projectState;
    }

    public Integer getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(Integer examineStatus) {
        this.examineStatus = examineStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getGenderRequirement() {
        return genderRequirement;
    }

    public void setGenderRequirement(Integer genderRequirement) {
        this.genderRequirement = genderRequirement;
    }

    public Integer getProjectLabel() {
        return projectLabel;
    }

    public void setProjectLabel(Integer projectLabel) {
        this.projectLabel = projectLabel;
    }

    public Integer getSalaryUnit() {
        return salaryUnit;
    }

    public void setSalaryUnit(Integer salaryUnit) {
        this.salaryUnit = salaryUnit;
    }

    public Integer getSettlementCycle() {
        return settlementCycle;
    }

    public void setSettlementCycle(Integer settlementCycle) {
        this.settlementCycle = settlementCycle;
    }

    public Integer getWorkWelfaresId() {
        return workWelfaresId;
    }

    public void setWorkWelfaresId(Integer workWelfaresId) {
        this.workWelfaresId = workWelfaresId;
    }

    public Integer getProjectNeedNum() {
        return projectNeedNum;
    }

    public void setProjectNeedNum(Integer projectNeedNum) {
        this.projectNeedNum = projectNeedNum;
    }

    public String getProjectContactsName() {
        return projectContactsName;
    }

    public void setProjectContactsName(String projectContactsName) {
        this.projectContactsName = projectContactsName == null ? null : projectContactsName.trim();
    }

    public String getProjectContactsMobile() {
        return projectContactsMobile;
    }

    public void setProjectContactsMobile(String projectContactsMobile) {
        this.projectContactsMobile = projectContactsMobile == null ? null : projectContactsMobile.trim();
    }

    public String getProjectContactsEmail() {
        return projectContactsEmail;
    }

    public void setProjectContactsEmail(String projectContactsEmail) {
        this.projectContactsEmail = projectContactsEmail == null ? null : projectContactsEmail.trim();
    }

    public String getProjectSkill() {
        return projectSkill;
    }

    public void setProjectSkill(String projectSkill) {
        this.projectSkill = projectSkill == null ? null : projectSkill.trim();
    }

    public Integer getWorkTimeNum() {
        return workTimeNum;
    }

    public void setWorkTimeNum(Integer workTimeNum) {
        this.workTimeNum = workTimeNum;
    }

    public String getWorkTimeUnit() {
        return workTimeUnit;
    }

    public void setWorkTimeUnit(String workTimeUnit) {
        this.workTimeUnit = workTimeUnit == null ? null : workTimeUnit.trim();
    }

    public Date getWorkTimeIntervalMin() {
        return workTimeIntervalMin;
    }

    public void setWorkTimeIntervalMin(Date workTimeIntervalMin) {
        this.workTimeIntervalMin = workTimeIntervalMin;
    }

    public Date getWorkTimeIntervalMax() {
        return workTimeIntervalMax;
    }

    public void setWorkTimeIntervalMax(Date workTimeIntervalMax) {
        this.workTimeIntervalMax = workTimeIntervalMax;
    }

    public String getWorkTimeRequirement() {
        return workTimeRequirement;
    }

    public void setWorkTimeRequirement(String workTimeRequirement) {
        this.workTimeRequirement = workTimeRequirement == null ? null : workTimeRequirement.trim();
    }

    public Date getProjectBeginTime() {
        return projectBeginTime;
    }

    public void setProjectBeginTime(Date projectBeginTime) {
        this.projectBeginTime = projectBeginTime;
    }

    public Date getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    public String getProjectRemark() {
        return projectRemark;
    }

    public void setProjectRemark(String projectRemark) {
        this.projectRemark = projectRemark == null ? null : projectRemark.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}