package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqSignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoByUserQuery;
import com.fenghuang.job.request.ReqSignUpInfoQuery;
import com.fenghuang.job.request.ReqSignUpInfoUpdate;
import com.fenghuang.job.view.SignUpInfoUserIdView;
import com.fenghuang.job.view.SignUpInfoView;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
    Result insertSignUpInfo(ReqSignUpInfo reqSignUpInfo);

    /**
     *修改用户兼职报名信息状态
     * @param reqSignUpInfoUpdate
     * @return
     */
    Result updateSignUpInfoState(ReqSignUpInfoUpdate reqSignUpInfoUpdate);

    /**
     * 根据条件查询用户兼职报名记录且分页
     * @param reqSignUpInfoQuery
     * @return
     */
    PageInfo <SignUpInfoView> findSignUpInfoPage(ReqSignUpInfoQuery reqSignUpInfoQuery);
    /**
     * 根据条件查询用户兼职报名记录信息
     * @param reqSignUpInfoQuery
     * @return
     */
    List<SignUpInfoView> findSignUpInfo(ReqSignUpInfoQuery reqSignUpInfoQuery);

    /**
     *根据id查询用户兼职报名记录详情
     * @param id
     * @return
     */
    SignUpInfoView findSignUpInfoById(Integer id);

    /**
     * 获取我的申请
     * @param reqSignUpInfoQuery
     * @return
     */
    PageInfo<SignUpInfoUserIdView> findUserInfoSignUpInfoPage(ReqSignUpInfoByUserQuery reqSignUpInfoQuery);
}
