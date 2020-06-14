package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.UserSettingInfoMapper;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.entity.UserSettingInfo;
import com.fenghuang.job.enums.AllowStatusEnum;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.EmploymentIntentionEnum;
import com.fenghuang.job.request.ReqUserSettingInfo;
import com.fenghuang.job.service.UserSettingInfoService;
import com.fenghuang.job.view.UserSettingInfoView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/13 8:57
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class UserSettingInfoServiceImpl implements UserSettingInfoService {

    @Resource
    UserSettingInfoMapper userSettingInfoMapper;

    @Autowired
    UserInfoByTokenSerivce userInfoByTokenSerivce;

    @Value( "${app.version}" )
    private String version;

    /**
     * 保存用户个性化设置
     *
     * @param reqUserSettingInfo
     * @return
     */
    @Override
    public Result saveOrUpdateUserSettingInfo(ReqUserSettingInfo reqUserSettingInfo) {
        log.info( "保存用户个性化设置请求参数：{}", JSON.toJSONString(reqUserSettingInfo) );

        Integer userId;
        String  userName ;
        Result userInfoByToken = userInfoByTokenSerivce.getUserInfoByToken(reqUserSettingInfo.getToken());
        if (userInfoByToken.getCode() == 2001){
            return Result.error( BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        Map user = (Map) userInfoByToken.getData();
        userId = Integer.valueOf(user.get("userId").toString());
        userName = user.get("userName").toString();
        log.info("解析token获取的结果{},{}",userId,userName);
        //判断数据库是否存在，如果存在，则只能修改
        UserSettingInfo queryUserSettingInfo = userSettingInfoMapper.selectByUerId( userId );

        UserSettingInfo userSettingInfo = new UserSettingInfo();
        BeanCopier beanCopier = BeanCopier.create( ReqUserSettingInfo.class,UserSettingInfo.class,false );
        beanCopier.copy( reqUserSettingInfo,userSettingInfo,null );
        userSettingInfo.setUserId( userId );
        userSettingInfo.setFounder( userName );
        userSettingInfo.setModifier( userName );
        userSettingInfo.setSettingState( 2 );
        if (queryUserSettingInfo == null){
            userSettingInfo.setCreateDate( new Date(  ) );
            userSettingInfo.setUpdateDate( new Date(  ) );
            return Result.success(userSettingInfoMapper.insertSelective( userSettingInfo ));
        }else{
            userSettingInfo.setUpdateDate( new Date(  ) );
            return Result.success(userSettingInfoMapper.updateByUserId( userSettingInfo ));
        }
    }

    /**
     * 查询用户个性化设置
     *
     * @param token
     * @return
     */
    @Override
    public Result findUserSettingInfo(String token) {
        log.info( "查询用户个性化设置" );

        Integer userId;
        String  userName ;
        Result userInfoByToken = userInfoByTokenSerivce.getUserInfoByToken(token);
        if (userInfoByToken.getCode() == 2001){
            return Result.error( BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        Map user = (Map) userInfoByToken.getData();
        userId = Integer.valueOf(user.get("userId").toString());
        userName = user.get("userName").toString();
        log.info("解析token获取的结果{},{}",userId,userName);
        //判断数据库是否存在，如果存在，则只能修改
        UserSettingInfo settingInfo = userSettingInfoMapper.selectByUerId( userId );
        UserSettingInfoView view = new UserSettingInfoView();

        BeanCopier beanCopier = BeanCopier.create( UserSettingInfo.class, UserSettingInfoView.class,false);
        beanCopier.copy( settingInfo,view,null );
        if (!StringUtils.isEmpty( settingInfo.getEmploymentIntention() )){
            view.setEmploymentIntentionDesc( EmploymentIntentionEnum.fromValue(settingInfo.getEmploymentIntention()).getMsg() );
        }
        if (!StringUtils.isEmpty(settingInfo.getSendLikeJob()  )){
            view.setSendLikeJobDesc( AllowStatusEnum.fromValue( settingInfo.getSendLikeJob() ).getMsg() );
        }
        if (!StringUtils.isEmpty( settingInfo.getSendEmail() )){
            view.setSendEmailDesc( AllowStatusEnum.fromValue( settingInfo.getSendEmail() ).getMsg() );
        }
        if (!StringUtils.isEmpty( settingInfo.getSendMessage()  )){
            view.setSendMessageDesc( AllowStatusEnum.fromValue( settingInfo.getSendMessage() ).getMsg() );
        }
        if (!StringUtils.isEmpty( settingInfo.getSendWechat() )){
            view.setSendWechantDesc( AllowStatusEnum.fromValue( settingInfo.getSendWechat() ).getMsg() );
        }
        if (!StringUtils.isEmpty( settingInfo.getSendPublicAccount() )){
            view.setSendPublicAccountDesc( AllowStatusEnum.fromValue( settingInfo.getSendPublicAccount() ).getMsg() );        }
        if (!StringUtils.isEmpty(settingInfo.getIsPersonalInformationPublic()   )){
            view.setIsPersonalInformationPublicDesc( AllowStatusEnum.fromValue( settingInfo.getIsPersonalInformationPublic() ).getMsg() );
        }
        view.setVersion(version);
        return Result.success(view);
    }

    @Override
   public String findpersonalSignatureByUserId(Integer userId){
        UserSettingInfo settingInfo = userSettingInfoMapper.selectByUerId( userId );
        if (settingInfo == null || StringUtils.isEmpty( settingInfo.getPersonalSignature() )){
            return null;
        }
        return settingInfo.getPersonalSignature();
    }
}
