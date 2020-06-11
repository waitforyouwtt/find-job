package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.*;
import com.fenghuang.job.request.ReqRegisterCode;
import com.fenghuang.job.view.UserInfoManagerView;
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
     * 根据用户名获取用户信息记录[可能有重名的人]
     * @param userName
     * @return
     */
    List<UserInfoView> findUserInfoByUserName(String userName);
    /**
     * 常规方式注册新用户且不允许昵称重复
     * @param reqUserInfo
     * @return
     */
    Result insertUser(ReqUserInfo reqUserInfo);

    /**
     * 更新用户信息
     * @param reqUserInfoUpdate
     * @return
     */
    Result modifyUserInfo(ReqUserInfoUpdate reqUserInfoUpdate);

    /**
     *根据用户id|用户昵称|用户手机号|身份证 获取唯一一条用户信息记录
     * @param reqUserInfoQuery
     * @return
     */
    UserInfoView findUserInfo(ReqUserInfoQuery reqUserInfoQuery);
    /**
     * 根据条件进行查询用户信息且进行分页
     * @param reqUserInfoQuery
     * @return
     */
    PageInfo <UserInfoView> findUserInfoPage(ReqUserInfoQuery reqUserInfoQuery);

    /**
     * 用户进行修改密码
     * @param reqUserInfoUpdate
     * @return
     */
    Result changePassword(ReqUserInfoUpdate reqUserInfoUpdate);

    /**
     * 用户短信注册，发送验证码
     * @return
     */
    Result messageRegister(String messageId,String signId,String mobile,String ip);

    /**
     *用户短信注册，输入密码并校验验证码，验证通过则注册成功，验证失败则注册失败
     * @param registerCode
     * @return
     */
    Result checkRegisterCode(ReqRegisterCode registerCode);

    /**
     * 根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录
     * @param reqLoginUserInfo
     * @return
     */
    Result ordinaryLogin(ReqLoginUserInfo reqLoginUserInfo);

    /**
     * 根据Id 获取用户记录详情
     * @param id
     * @return
     */
    Result findUserById(Integer id);

    /**
     * 根据Id 获取用户记录详情
     */
    UserInfoView findUserInfoById(Integer id);

    /**
     * 使用短信进行登录，发送验证码
     * @param
     * @return
     */
    Result loginByMessage(String messageId,String signId,String mobile,String ip);

    /**
     * 用户短信登录，输入验证码，验证通过则登录成功，验证失败则登录失败
     * @param reqLoginUserInfo
     * @return
     */
    Result checkLoginCode(ReqLoginUserInfo reqLoginUserInfo);

    /**
     * 根据登录token获取登录用户的昵称，头像，钱包余额，收藏数，浏览数，我的兼职等信息
     * @param token
     * @return
     */
    Result findMoWaByToken(String token);

    /**
     * 根据登录token获取个人信息
      * @param token
     * @return
     */
    Result findPersonalInformationByToken(String token);

    /**
     * 通过短信找回密码-发送短信
     * @param messageId
     * @param signId
     * @param mobile
     * @param ip
     * @return
     */
    Result messageFindPwd(String messageId,String signId,String mobile,String ip);

    /**
     * 通过短信找回密码-输入验证码，验证通过则修改密码成功，验证失败则修改密码失败
     * @param userInfo
     * @return
     */
    Result retrievePassword(ReqLoginUserInfo userInfo);
}
