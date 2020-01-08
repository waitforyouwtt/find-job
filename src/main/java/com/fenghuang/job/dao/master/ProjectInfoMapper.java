package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.request.ReqProjectInfo;
import com.fenghuang.job.request.ReqProjectInfoQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInfo record);

    int insertSelective(ProjectInfo record);

    ProjectInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectInfo record);

    int updateByPrimaryKey(ProjectInfo record);

    List<ProjectInfo> findProjectPage(ReqProjectInfo reqProject);

    ProjectInfo findProjectParams(ReqProjectInfoQuery reqProjectInfoQuery);

    List<ProjectInfo> findProject(ReqProjectInfo reqProject);
}