package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.ProjectWorkTimeInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectWorkTimeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectWorkTimeInfo record);

    int insertSelective(ProjectWorkTimeInfo record);

    ProjectWorkTimeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectWorkTimeInfo record);

    int updateByPrimaryKey(ProjectWorkTimeInfo record);
}