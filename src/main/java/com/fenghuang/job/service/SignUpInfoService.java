package com.fenghuang.job.service;

import com.fenghuang.job.request.ReqSignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoQuery;
import com.fenghuang.job.request.ReqSignUpInfoUpdate;
import com.fenghuang.job.view.SignUpInfoView;
import com.github.pagehelper.PageInfo;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 21:49
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface SignUpInfoService {

    /**
     * 保存用户兼职报名信息
     * @param reqSignUpInfo
     * @return
     */
    int insertSignUpInfo(ReqSignUpInfo reqSignUpInfo);

    /**
     *修改用户兼职报名信息状态
     * @param reqSignUpInfoUpdate
     * @return
     */
    int updateSignUpInfoState(ReqSignUpInfoUpdate reqSignUpInfoUpdate);

    /**
     * 根据条件查询用户兼职报名记录且分页
     * @param reqSignUpInfoQuery
     * @return
     */
    PageInfo <SignUpInfoView> findSignUpInfoPage(ReqSignUpInfoQuery reqSignUpInfoQuery);
}
