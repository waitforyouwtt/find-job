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
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<UserInfoView> findUserInfoByUserName(String userName) {
        log.info("根据用户名字获取一条记录");
        List<UserInfo> userInfos = userInfoMasterMapper.findUserInfoByUserName(userName);
        if (CollectionUtils.isEmpty(userInfos)) {
            return new ArrayList<>();
        }
        List<UserInfoView> userInfoViews = new ArrayList<>();
        convertToUserInfoView(userInfos, userInfoViews);

        log.info("根据用户名字获取记录返回结果：{}",userInfoViews);
        return userInfoViews;
    }

    private void convertToUserInfoView(List<UserInfo> userInfos, List<UserInfoView> userInfoViews) {
        userInfos.stream().forEach( userInfo -> {
            UserInfoView view = new UserInfoView();
            BeanCopier beanCopier = BeanCopier.create(UserInfo.class, UserInfoView.class, false);
            beanCopier.copy(userInfo, view, null);
            userInfoViews.add(view);
        });
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

    /**
     * 更新用户信息
     *
     * @param reqUserInfo
     * @return
     */
    @Override
    public int modifyUserInfo(ReqUserInfo reqUserInfo) {
        log.info("更新用户信息请求参数：{}", JSON.toJSONString(reqUserInfo));
        UserInfo queryUserInfo = userInfoMasterMapper.findUserInfo(reqUserInfo);
        if (queryUserInfo == null){
            throw new BusinessException(BusinessEnum.RECORD_NOT_EXIST.getCode(),BusinessEnum.RECORD_NOT_EXIST.getMsg());
        }
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqUserInfo.class, UserInfo.class, false);
        beanCopier.copy(reqUserInfo,userInfo,null);
        return userInfoMasterMapper.updateByPrimaryKeySelective(userInfo);
    }

    /**
     * 根据用户id|用户昵称|用户手机号|身份证 获取唯一一条用户信息记录
     * @param reqUserInfo
     * @return
     */
    @Override
    public UserInfoView findUserInfo(ReqUserInfo reqUserInfo) {
        log.info("根据用户id|用户昵称|用户手机号|身份证 获取唯一一条记录 请求参数：{}",JSON.toJSON(reqUserInfo));
        UserInfo queryUserInfo = userInfoMasterMapper.findUserInfo(reqUserInfo);
        if (queryUserInfo == null){
            return null;
        }
        UserInfoView view = new UserInfoView();
        BeanCopier beanCopier = BeanCopier.create(ReqUserInfo.class, UserInfo.class, false);
        beanCopier.copy(queryUserInfo,view,null);
        return view;
    }

    /**
     * 根据条件进行查询用户信息且进行分页
     *
     * @param reqUserInfo
     * @return
     */
    @Override
    public PageInfo<UserInfoView> findUserInfoPage(ReqUserInfo reqUserInfo) {
        log.info("根据条件进行查询且进行分页请求参数：{}",JSON.toJSON(reqUserInfo));
        PageInfo<UserInfoView> pageInfo = null;
        try {
            Page<?> page = PageHelper.startPage(reqUserInfo.getPageNum(),reqUserInfo.getPageSize());
            List<UserInfo> userInfoList = userInfoMasterMapper.findUserInfoPage(reqUserInfo);
            if (CollectionUtils.isEmpty(userInfoList)){
                pageInfo = new PageInfo<>(new ArrayList<>());
            }else{
                List<UserInfoView> userInfoViews = new ArrayList<>();
                convertToUserInfoView(userInfoList, userInfoViews);
                pageInfo = new PageInfo<>(userInfoViews);
            }
            log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        } catch (Exception e) {
            log.error("根据条件进行查询用户信息且进行分页 查询异常"+e.getMessage());
        }
        return pageInfo;
    }

    /**
     * 用户进行修改密码
     *
     * @param reqUserInfo
     * @return
     */
    @Override
    public int changePassword(ReqUserInfo reqUserInfo) {
        log.info("用户进行修改密码 请求参数：{}",JSON.toJSON(reqUserInfo));
        UserInfo queryUserInfo = userInfoMasterMapper.findUserByUserNameAndPassword(reqUserInfo);
        if (queryUserInfo == null){
            throw new BusinessException(BusinessEnum.RECORD_NOT_EXIST.getCode(),BusinessEnum.RECORD_NOT_EXIST.getMsg());
        }
        reqUserInfo.setNewPassword(AesUtil.encrypt(Constants.SECRET_KEY,reqUserInfo.getNewPassword()));
        return userInfoMasterMapper.changePassword(reqUserInfo);
    }

    public static String dateToString(){
       return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());
    }



}
