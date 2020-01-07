package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.SignUpInfoMapper;
import com.fenghuang.job.entity.SignUpInfo;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.enums.SignUpInfoEnum;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.request.ReqSignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoQuery;
import com.fenghuang.job.request.ReqSignUpInfoUpdate;
import com.fenghuang.job.service.SignUpInfoService;
import com.fenghuang.job.view.SignUpInfoView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
        //同一兼职项目不可以再次报名
        ReqSignUpInfoQuery query = new ReqSignUpInfoQuery();
        query.setProjectId(reqSignUpInfo.getProjectId());
        query.setUserId(reqSignUpInfo.getUserId());
        query.setUserMobile(reqSignUpInfo.getUserMobile());
        query.setStates(Arrays.asList(SignUpInfoEnum.WAIT_ADMISSION.getCode(),SignUpInfoEnum.HAD_ADMISSION.getCode()));
        List<SignUpInfo> signUpInfo = signUpInfoMapper.findSignUpInfo(query);
        if (!CollectionUtils.isEmpty(signUpInfo)){
            throw new BusinessException(BusinessEnum.RECORD_ALREADY_EXISTS.getCode(),BusinessEnum.RECORD_ALREADY_EXISTS.getMsg());
        }

        SignUpInfo signUpInfoParams = new SignUpInfo();
        BeanCopier beanCopier = BeanCopier.create( ReqSignUpInfo.class, SignUpInfo.class,false );
        beanCopier.copy( reqSignUpInfo,signUpInfoParams,null );
        signUpInfoParams.setCreateTime( new Date(  ) );
        signUpInfoParams.setUpdateTime( new Date(  ) );
        signUpInfoParams.setIsDelete( DeleteEnum.NO.getCode() );
        signUpInfoParams.setState( SignUpInfoEnum.WAIT_ADMISSION.getCode() );
        return signUpInfoMapper.insertSelective( signUpInfoParams );
    }

    /**
     * 修改用户兼职报名信息状态
     *
     * @param reqSignUpInfoUpdate
     * @return
     */
    @Override
    public int updateSignUpInfoState(ReqSignUpInfoUpdate reqSignUpInfoUpdate) {
        log.info("修改用户兼职报名信息状态 请求参数：{}",JSON.toJSONString(reqSignUpInfoUpdate));
        if (!StringUtils.isEmpty(reqSignUpInfoUpdate.getId().toString())){
            throw new BusinessException(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg());
        }
        SignUpInfo update = new SignUpInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqSignUpInfoUpdate.class,SignUpInfo.class,false);
        beanCopier.copy(reqSignUpInfoUpdate,update,null);
        return signUpInfoMapper.updateByPrimaryKeySelective(update);
    }

    /**
     * 根据条件查询用户兼职报名记录且分页
     *
     * @param reqSignUpInfoQuery
     * @return
     */
    @Override
    public PageInfo<SignUpInfoView> findSignUpInfoPage(ReqSignUpInfoQuery reqSignUpInfoQuery) {
        log.info("根据条件查询用户兼职报名记录且分页 请求参数：{}",JSON.toJSONString(reqSignUpInfoQuery));
        PageInfo<SignUpInfoView> pageInfo = null;
        try{
            Page<?> page = PageHelper.startPage(reqSignUpInfoQuery.getPageNum(),reqSignUpInfoQuery.getPageSize());
            List<SignUpInfo> signUpInfoList = signUpInfoMapper.findSignUpInfo(reqSignUpInfoQuery);
            if (CollectionUtils.isEmpty(signUpInfoList)){
                pageInfo = new PageInfo<>(new ArrayList<>());
            }else{
                List<SignUpInfoView> views = new ArrayList<>(16);
                signUpInfoList.stream().forEach(signUpInfo -> {
                    SignUpInfoView view = new SignUpInfoView();
                    BeanCopier beanCopier = BeanCopier.create(SignUpInfo.class,SignUpInfoView.class,false);
                    beanCopier.copy(signUpInfo,view,null);
                    views.add(view);
                });
                pageInfo = new PageInfo<>(views);
            }
            log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        }catch (Exception e){
           log.info("根据条件查询用户兼职报名记录且分页 查询异常：{}",JSON.toJSONString(e.getMessage()));
        }
        return pageInfo;
    }

    /**
     * 根据条件查询用户兼职报名记录信息
     *
     * @param reqSignUpInfoQuery
     * @return
     */
    @Override
    public List<SignUpInfo> findSignUpInfo(ReqSignUpInfoQuery reqSignUpInfoQuery) {
        log.info("根据条件查询用户兼职报名记录信息 请求参数：{}",JSON.toJSONString(reqSignUpInfoQuery));
        List<SignUpInfo> signUpInfoList = signUpInfoMapper.findSignUpInfo(reqSignUpInfoQuery);
        if (CollectionUtils.isEmpty(signUpInfoList)){
           return new ArrayList<>();
        }
        return signUpInfoList;
    }
}
