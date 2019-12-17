package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.dao.cluster.UserInfoClusterMapper;
import com.fenghuang.job.dao.master.UserInfoMasterMapper;
import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.UserInfoStatusEnum;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.request.ReqUserInfo;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.utils.AesUtil;
import com.fenghuang.job.view.UserInfoView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 11:13
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMasterMapper userInfoMasterMapper;

    @Autowired
    UserInfoClusterMapper userInfoClusterMapper;

    /**
     * 根据用户名字获取一条记录
     *
     * @param userName
     * @return
     */
    @Override
    public UserInfoView findUserInfo(String userName) {
        log.info("根据用户名字获取一条记录");
        UserInfo userInfo = userInfoMasterMapper.findUserInfoByUserName(userName);
        if (userInfo == null) {
            return null;
        }
        UserInfoView view = new UserInfoView();
        BeanCopier beanCopier = BeanCopier.create(UserInfo.class, UserInfoView.class, false);
        beanCopier.copy(userInfo, view, null);
        log.info("根据用户名字获取记录返回结果：{}",view);
        return view;
    }

    /**
     * 注册新用户
     *
     * @param reqUserInfo
     * @return
     */
    @Override
    public int insertUser(ReqUserInfo reqUserInfo) {
        log.info("注册新用户，请求参数：{}", JSON.toJSONString(reqUserInfo));
        UserInfo queryUserInfo = userInfoMasterMapper.findUserInfo(reqUserInfo);
        if (queryUserInfo != null){
            throw new BusinessException(BusinessEnum.RECORD_ALREADY_EXISTS.getCode(),BusinessEnum.RECORD_ALREADY_EXISTS.getMsg());
        }
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqUserInfo.class, UserInfo.class, false);
        beanCopier.copy(reqUserInfo,userInfo,null);
        userInfo.setPassword(AesUtil.encrypt(Constants.SECRET_KEY,reqUserInfo.getPassword()));
        userInfo.setUserStatus(UserInfoStatusEnum.NORMAL.getCode());
        return userInfoMasterMapper.insertSelective(userInfo);
    }
}
