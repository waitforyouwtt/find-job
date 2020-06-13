package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqUserSettingInfo;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/13 8:52
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface UserSettingInfoService {

    /**
     * 保存用户个性化设置
     * @param reqUserSettingInfo
     * @return
     */
    Result saveOrUpdateUserSettingInfo(ReqUserSettingInfo reqUserSettingInfo);

    /**
     * 查询用户个性化设置
     * @param token
     * @return
     */
    Result findUserSettingInfo(String token);
}
