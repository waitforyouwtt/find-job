package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.SignUpInfoMapper;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.entity.SignUpInfo;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.enums.SignUpInfoEnum;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.request.ReqSignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoByUserQuery;
import com.fenghuang.job.request.ReqSignUpInfoQuery;
import com.fenghuang.job.request.ReqSignUpInfoUpdate;
import com.fenghuang.job.service.SignUpInfoService;
import com.fenghuang.job.view.ProjectInfoView;
import com.fenghuang.job.view.SignUpInfoUserIdView;
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

import java.util.*;

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
    public Result insertSignUpInfo(ReqSignUpInfo reqSignUpInfo) {
        log.info( "保存用户兼职报名信息 请求参数：{}", JSON.toJSONString(reqSignUpInfo) );
        ReqSignUpInfoQuery query = new ReqSignUpInfoQuery();
        query.setProjectId(reqSignUpInfo.getProjectId());
        query.setUserId(25);
        query.setUserMobile(reqSignUpInfo.getUserMobile());
        query.setStates(Arrays.asList(SignUpInfoEnum.WAIT_ADMISSION.getCode(),SignUpInfoEnum.HAD_ADMISSION.getCode()));
        //同一兼职项目同一用户处于待录用和已录用的状态不可以再次报名
        List<SignUpInfo> querySignUpInfo = signUpInfoMapper.findSignUpInfo(query);
        log.info("检索同一兼职项目同一用户处于待录用和已录用的状态 返回结果：{}",JSON.toJSONString(querySignUpInfo));
        if (!CollectionUtils.isEmpty(querySignUpInfo)){
            return Result.error(BusinessEnum.RECORD_ALREADY_EXISTS.getCode(),BusinessEnum.RECORD_ALREADY_EXISTS.getMsg(),null);
        }
        SignUpInfo signUpInfoParams = new SignUpInfo();
        BeanCopier beanCopier = BeanCopier.create( ReqSignUpInfo.class, SignUpInfo.class,false );
        beanCopier.copy( reqSignUpInfo,signUpInfoParams,null );
        signUpInfoParams.setUserId( 25 );
        signUpInfoParams.setCreateDate( new Date(  ) );
        signUpInfoParams.setUpdateDate( new Date(  ) );
        signUpInfoParams.setIsDelete( DeleteEnum.NO.getCode() );
        signUpInfoParams.setState( SignUpInfoEnum.WAIT_ADMISSION.getCode() );
        return Result.success(signUpInfoMapper.insertSelective( signUpInfoParams ));
    }

    /**
     * 修改用户兼职报名信息状态
     *
     * @param reqSignUpInfoUpdate
     * @return
     */
    @Override
    public Result updateSignUpInfoState(ReqSignUpInfoUpdate reqSignUpInfoUpdate) {
        log.info("修改用户兼职报名信息状态 请求参数：{}",JSON.toJSONString(reqSignUpInfoUpdate));
        if (reqSignUpInfoUpdate.getId() ==null){
            return Result.error(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg(),null);
        }
        SignUpInfo update = new SignUpInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqSignUpInfoUpdate.class,SignUpInfo.class,false);
        beanCopier.copy(reqSignUpInfoUpdate,update,null);
        return Result.success(signUpInfoMapper.updateByPrimaryKeySelective(update));
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
            List<SignUpInfo> querySignUpInfo = signUpInfoMapper.findSignUpInfo(reqSignUpInfoQuery);
            if (CollectionUtils.isEmpty(querySignUpInfo)){
                pageInfo = new PageInfo<>(new ArrayList<>());
            }else{
                List<SignUpInfoView> views = new ArrayList<>(16);
                convertView(querySignUpInfo, views);
                pageInfo = new PageInfo<>(views);
            }
            pageInfo.setPages(page.getPages());
            pageInfo.setTotal(page.getTotal());
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
    public List<SignUpInfoView> findSignUpInfo(ReqSignUpInfoQuery reqSignUpInfoQuery) {
        log.info("根据条件查询用户兼职报名记录信息 请求参数：{}",JSON.toJSONString(reqSignUpInfoQuery));
        List<SignUpInfo> querySignUpInfo = signUpInfoMapper.findSignUpInfo(reqSignUpInfoQuery);
        if (CollectionUtils.isEmpty(querySignUpInfo)){
           return new ArrayList<>();
        }
        List<SignUpInfoView> views  = new ArrayList<>();
        convertView(querySignUpInfo, views);
        return views;
    }

    private void convertView(List<SignUpInfo> querySignUpInfo, List<SignUpInfoView> views) {
        querySignUpInfo.stream().forEach(signUpInfo -> {
            SignUpInfoView view = new SignUpInfoView();
            BeanCopier beanCopier = BeanCopier.create(SignUpInfo.class,SignUpInfoView.class,false);
            beanCopier.copy(signUpInfo,view,null);
            views.add(view);
        });
    }

    /**
     * 根据id查询用户兼职报名记录详情
     * @param id
     * @return
     */
    @Override
    public SignUpInfoView findSignUpInfoById(Integer id) {
        SignUpInfo querySignUpInfo = signUpInfoMapper.findSignUpInfoById(id);
        if (querySignUpInfo == null){
            return null;
        }
        SignUpInfoView view = new SignUpInfoView();
        BeanCopier beanCopier = BeanCopier.create(SignUpInfo.class,SignUpInfoView.class,false);
        beanCopier.copy(querySignUpInfo,view,null);
        return view;
    }

    /**
     * 获取我的申请
     * @param reqSignUpInfoQuery
     * @return
     */
    @Override
    public PageInfo<SignUpInfoUserIdView> findUserInfoSignUpInfoPage(ReqSignUpInfoByUserQuery reqSignUpInfoQuery) {
        log.info( "获取我的申请 请求参数：{}",JSON.toJSONString( reqSignUpInfoQuery ) );
        Integer userId = 25;
        PageInfo<SignUpInfoUserIdView> pageInfo = null;
        try{
            Page<Object> page = PageHelper.startPage( reqSignUpInfoQuery.getPageNum(), reqSignUpInfoQuery.getPageSize() );
            reqSignUpInfoQuery.setUserId( 25 );
            List<SignUpInfoUserIdView> querySignUpInfoUserIdView =  signUpInfoMapper.findUserInfoSignUpInfoPage(reqSignUpInfoQuery);
            if (CollectionUtils.isEmpty( querySignUpInfoUserIdView )){
                pageInfo = new PageInfo<>(new ArrayList<>());
            }else{
                querySignUpInfoUserIdView.sort( Comparator.comparing(SignUpInfoUserIdView::getCreateDate).reversed());
                pageInfo = new PageInfo<>(querySignUpInfoUserIdView);
            }
            pageInfo.setPages(page.getPages());
            pageInfo.setTotal(page.getTotal());
        }catch (Exception e){
            log.info( "获取我的申请 查询异常：{}",e.getMessage() );
        }
        return pageInfo;
    }

    /**
     * 前端用户取消报名
     * @param reqSignUpInfoUpdate
     * @return
     */
    @Override
    public Result cancelSignUpInfo(ReqSignUpInfoUpdate reqSignUpInfoUpdate) {
        log.info( "前端用户取消报名 请求参数：{}",JSON.toJSONString( reqSignUpInfoUpdate ) );

        Integer userId = 25;
        ReqSignUpInfoQuery query = new ReqSignUpInfoQuery();
        query.setUserId( userId );
        query.setId(reqSignUpInfoUpdate.getSignUpId() );
        query.setProjectId( reqSignUpInfoUpdate.getProjectId() );
        query.setIsDelete(DeleteEnum.NO.getCode() );
        List<SignUpInfo> querySignUpInfo = signUpInfoMapper.findSignUpInfo(query);
        querySignUpInfo.sort(Comparator.comparing(SignUpInfo::getCreateDate).reversed());
        if (CollectionUtils.isEmpty( querySignUpInfo )){
           return Result.error( BusinessEnum.RECORD_NOT_EXIST.getCode(), BusinessEnum.RECORD_NOT_EXIST.getMsg(),null);
        }
        SignUpInfo signUpInfoOne =  querySignUpInfo.get( 0 );
        if (signUpInfoOne.getState().equals( SignUpInfoEnum.HAD_ADMISSION.getCode() ) || signUpInfoOne.getState().equals( SignUpInfoEnum.HAD_SETTLEMENT.getCode() )
          || signUpInfoOne.getState().equals( SignUpInfoEnum.WAIT_EVALUATE.getCode() ) || signUpInfoOne.getState().equals( SignUpInfoEnum.CANCEL.getCode() )){
            return Result.error( BusinessEnum.SIGNUPINFOENUM_CANCEL.getCode(),BusinessEnum.SIGNUPINFOENUM_CANCEL.getMsg(),null );
        }

        SignUpInfo signUpInfo = new SignUpInfo();
        signUpInfo.setState( 5 );
        signUpInfo.setId( reqSignUpInfoUpdate.getSignUpId() );
        signUpInfo.setProjectId( reqSignUpInfoUpdate.getProjectId() );
        signUpInfo.setUserId( userId );
        signUpInfo.setUpdateDate( new Date(  ) );
        int i = signUpInfoMapper.cancelSignUpInfo( signUpInfo );
        if (i > 0){
            return Result.success();
        }else{
            return Result.error( BusinessEnum.UPDATE_ERROR.getCode(),BusinessEnum.UPDATE_ERROR.getMsg(),null);
        }
    }
}
