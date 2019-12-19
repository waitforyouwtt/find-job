package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.request.ReqUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMasterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> findUserInfoByUserName(String userName);

    UserInfo findUserInfo(ReqUserInfo reqUserInfo);

    List<UserInfo> findUserInfoPage(ReqUserInfo reqUserInfo);

    UserInfo findUserByUserNameAndPassword(ReqUserInfo reqUserInfo);

    int changePassword(ReqUserInfo reqUserInfo);
}