package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.UserSettingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserSettingInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserSettingInfo record);

    int insertSelective(UserSettingInfo record);

    UserSettingInfo selectByUerId(@Param( "userId" ) Integer userId);

    int updateByUserId(UserSettingInfo record);

    int updateByPrimaryKey(UserSettingInfo record);
}