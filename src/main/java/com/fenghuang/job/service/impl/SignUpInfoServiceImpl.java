package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.SignUpInfoMapper;
import com.fenghuang.job.entity.SignUpInfo;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.enums.SignUpInfoEnum;
import com.fenghuang.job.request.ReqSignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoQuery;
import com.fenghuang.job.request.ReqSignUpInfoUpdate;
import com.fenghuang.job.service.SignUpInfoService;
import com.fenghuang.job.view.SignUpInfoView;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 21:58
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class SignUpInfoServiceImpl implements SignUpInfoService {

    @Autowired
    SignUpInfoMapper signUpInfoMapper;
    /**
     * 保存用户兼职报名信息
     *
     * @param reqSignUpInfo
     * @return
     */
    @Override
    public int insertSignUpInfo(ReqSignUpInfo reqSignUpInfo) {
        log.info( "保存用户兼职报名信息 请求参数：{}", JSON.toJSONString(reqSignUpInfo) );
        //SignUpInfoView signUpInfoView = signUpInfoMapper.findSignUpInfo(reqSignUpInfo);

        SignUpInfo signUpInfo = new SignUpInfo();
        BeanCopier beanCopier = BeanCopier.create( ReqSignUpInfo.class, SignUpInfo.class,false );
        beanCopier.copy( reqSignUpInfo,signUpInfo,null );
        signUpInfo.setCreateTime( new Date(  ) );
        signUpInfo.setUpdateTime( new Date(  ) );
        signUpInfo.setIsDelete( DeleteEnum.NO.getCode() );
        signUpInfo.setState( SignUpInfoEnum.WAIT_ADMISSION.getCode() );
        int i = signUpInfoMapper.insertSelective( signUpInfo );
        return 0;
    }

    /**
     * 修改用户兼职报名信息状态
     *
     * @param reqSignUpInfoUpdate
     * @return
     */
    @Override
    public int updateSignUpInfoState(ReqSignUpInfoUpdate reqSignUpInfoUpdate) {
        return 0;
    }

    /**
     * 根据条件查询用户兼职报名记录且分页
     *
     * @param reqSignUpInfoQuery
     * @return
     */
    @Override
    public PageInfo<SignUpInfoView> findSignUpInfoPage(ReqSignUpInfoQuery reqSignUpInfoQuery) {
        return null;
    }
}
