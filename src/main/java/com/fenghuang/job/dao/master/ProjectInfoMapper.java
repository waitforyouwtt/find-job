package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.request.ReqProjectInfo;

import java.util.List;

public interface ProjectInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInfo record);

    int insertSelective(ProjectInfo record);

    ProjectInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectInfo record);

    int updateByPrimaryKey(ProjectInfo record);

    List<ProjectInfo> findProjectPage(ReqProjectInfo reqProject);

    ProjectInfo findProjectParams(ReqProjectInfo reqProject);

    List<ProjectInfo> findProject(ReqProjectInfo reqProject);
}