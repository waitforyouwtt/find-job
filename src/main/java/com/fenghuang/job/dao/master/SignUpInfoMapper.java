package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.SignUpInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignUpInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SignUpInfo record);

    int insertSelective(SignUpInfo record);

    SignUpInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SignUpInfo record);

    int updateByPrimaryKey(SignUpInfo record);
}