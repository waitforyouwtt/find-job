package com.fenghuang.job.service;

import com.fenghuang.job.request.ReqUserInfo;
import com.fenghuang.job.view.UserInfoView;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 11:04
 * @Email: 15290810931@163.com
 */
public interface UserInfoService {

    /**
     * 根据用户名字获取一条记录
     * @param userName
     * @return
     */
    List<UserInfoView> findUserInfoByUserName(String userName);
    /**
     * 注册新用户
     * @param reqUserInfo
     * @return
     */
    int insertUser(ReqUserInfo reqUserInfo);

    /**
     * 更新用户信息
     * @param reqUserInfo
     * @return
     */
    int modifyUserInfo(ReqUserInfo reqUserInfo);

    /**
     *
     * @param reqUserInfo
     * @return
     */
    UserInfoView findUserInfo(ReqUserInfo reqUserInfo);
    /**
     * 根据条件进行查询且进行分页
     * @param reqUserInfo
     * @return
     */
    PageInfo <UserInfoView> findUserInfoPage(ReqUserInfo reqUserInfo);

    /**
     * 用户进行修改密码
     * @param reqUserInfo
     * @return
     */
    int changePassword(ReqUserInfo reqUserInfo);
}
