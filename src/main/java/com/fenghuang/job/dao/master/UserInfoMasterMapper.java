package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.request.ReqUserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMasterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo findUserInfoByUserName(String userName);

    UserInfo findUserInfo(ReqUserInfo reqUserInfo);
}