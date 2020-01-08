package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqProjectInfo;
import com.fenghuang.job.request.ReqProjectInfoQuery;
import com.fenghuang.job.request.ReqProjectStatus;
import com.fenghuang.job.view.ProjectInfoView;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 12:11
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface ProjectInfoService {
    /**
     * 创建项目
     * @param reqProject
     * @return
     */
    Result insertProject(ReqProjectInfo reqProject);

    /**
     * 根据id更新项目相关字段
      * @param reqProject
     * @return
     */
    Result modifyProject(ReqProjectInfo reqProject);

    /**
     *根据id更新项目状态
     * @param reqProjectStatus
     * @return
     */
    Result modifyProjectStatus(ReqProjectStatus reqProjectStatus);

    /**
     *根据条件查询项目信息
     * @param reqProjectInfoQuery
     * @return
     */
    List<ProjectInfoView> findProject(ReqProjectInfoQuery reqProjectInfoQuery);

    /**
     *根据条件进行查询项目相关信息且分页
      * @param reqProject
     * @return
     */
    PageInfo<ProjectInfoView> findProjectPage(ReqProjectInfo reqProject);
}
