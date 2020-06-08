package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.request.ReqUserInfoQuery;
import com.fenghuang.job.request.ReqUserInfoUpdate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    //根据用户名查询列表信息
    List<UserInfo> findUserInfoByUserName(String userName);
    //注册新用户，根据注册填充数据[昵称|手机号|身份证]去查询数据库(因为姓名可以重复)，如果存在则不允许注册新用户
    UserInfo findUserInfo(ReqUserInfoQuery reqUserInfoQuery);
    //分页查询
    List<UserInfo> findUserInfoPage(ReqUserInfoQuery reqUserInfoQuery);
    //根据用户名和密码进行查询
    UserInfo findUserInfoByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
    //修改密码
    int changePassword(ReqUserInfoUpdate reqUserInfoUpdate);
    //登录前根据[用户名 or 昵称 or 身份证id or 手机号]查询数据库，判断数据库有没有该用户 & 检查登录者的账号是否是正常账号
    UserInfo loginQueryUserInfo(@Param("loginUser") String loginUser);
    //根据用户名 & 密码进行登录
    UserInfo findUserByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);
    //根据用户昵称 & 密码进行登录
    UserInfo findUserByUserNicknameAndPassword(@Param("userNickname") String userNickname,@Param("password") String password);
    //根据用户手机号 & 密码进行登录
    UserInfo findMobileAndPassword(@Param("mobile") String mobile,@Param("password") String password);
    //根据用户身份证id & 密码进行登录
    UserInfo findIdCardAndPassword(@Param("idCard") String idCard, @Param("password") String password);
}