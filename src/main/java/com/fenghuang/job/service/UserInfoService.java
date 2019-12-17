package com.fenghuang.job.service;

import com.fenghuang.job.request.ReqUserInfo;
import com.fenghuang.job.view.UserInfoView;

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
    UserInfoView findUserInfo(String userName);
    /**
     * 注册新用户
     * @param reqUserInfo
     * @return
     */
    int insertUser(ReqUserInfo reqUserInfo);
}
