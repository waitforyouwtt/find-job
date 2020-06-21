package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.IndustryTypeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndustryTypeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndustryTypeInfo record);

    int insertSelective(IndustryTypeInfo record);

    IndustryTypeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndustryTypeInfo record);

    int updateByPrimaryKey(IndustryTypeInfo record);

    List<IndustryTypeInfo> findIndustryTypeInfoByPid(@Param( "pid" ) Integer pid);
}