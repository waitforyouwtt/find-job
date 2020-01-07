package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.ProjectWorkDateInfo;

public interface ProjectWorkDateInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectWorkDateInfo record);

    int insertSelective(ProjectWorkDateInfo record);

    ProjectWorkDateInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectWorkDateInfo record);

    int updateByPrimaryKey(ProjectWorkDateInfo record);
}