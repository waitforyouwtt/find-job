package com.fenghuang.job.service;

import com.fenghuang.job.request.ReqLoginUserInfo;
import com.fenghuang.job.request.ReqMessage;
import com.fenghuang.job.request.ReqUserInfo;
import com.fenghuang.job.view.MessageView;
import com.fenghuang.job.view.RegisterCodeView;
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
     * 根据用户名获取一条或多条用户信息记录
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
     *根据用户id|用户昵称|用户手机号|身份证 获取唯一一条用户信息记录
     * @param reqUserInfo
     * @return
     */
    UserInfoView findUserInfo(ReqUserInfo reqUserInfo);
    /**
     * 根据条件进行查询用户信息且进行分页
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

    /**
     * 用户短信注册，发送验证码
     * @param reqMessage
     * @return
     */
    MessageView messageRegister(ReqMessage reqMessage);

    /**
     *用户短信注册，输入密码并校验验证码，验证通过则注册成功，验证失败则注册失败
     * @param registerCodeView
     * @return
     */
    MessageView checkRegisterCode(RegisterCodeView registerCodeView);

    /**
     * 根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录
     * @param reqLoginUserInfo
     * @return
     */
    UserInfoView login(ReqLoginUserInfo reqLoginUserInfo);
}
