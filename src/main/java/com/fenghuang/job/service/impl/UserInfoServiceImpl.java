package com.fenghuang.job.service.impl;

import com.fenghuang.job.dao.cluster.UserInfoClusterMapper;
import com.fenghuang.job.dao.master.UserInfoMasterMapper;
import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.service.UserInfoService;
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
        return view;
    }

    @Override
    public UserInfoView findUserInfo2(String userName) {
        log.info("根据用户名字获取一条记录");
        UserInfo userInfo = userInfoClusterMapper.findUserInfoByUserName(userName);
        if (userInfo == null) {
            return null;
        }
        UserInfoView view = new UserInfoView();
        BeanCopier beanCopier = BeanCopier.create(UserInfo.class, UserInfoView.class, false);
        beanCopier.copy(userInfo, view, null);
        return view;
    }
}
