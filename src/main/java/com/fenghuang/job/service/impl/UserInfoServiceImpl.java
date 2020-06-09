package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fenghuang.job.aspect.LoginLogAnnotation;
import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.dao.master.UserInfoMapper;
import com.fenghuang.job.entity.BrowseRecordInfo;
import com.fenghuang.job.entity.CollectionRecordInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.enums.*;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.request.*;
import com.fenghuang.job.service.*;
import com.fenghuang.job.utils.*;
import com.fenghuang.job.view.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import static java.util.stream.Collectors.toList;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 11:13
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Autowired
    SmsSenderUtil smsSenderUtil;

    @Autowired
    MessageRecordService messageCountService;

    @Autowired
    CollectionRecordInfoService recordInfoService;
    
    @Autowired
    BrowseRecordInfoService browseRecordInfoService;

    @Autowired
    SignUpInfoService signUpInfoService;

    /**
     * 根据用户名字获取记录[可能有重名的人]
     *
     * @param userName
     * @return
     */
    @Override
    public List<UserInfoView> findUserInfoByUserName(String userName) {
        log.info("根据用户名字获取一条记录");
        if (StringUtils.isEmpty(userName)){
            throw new BusinessException(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg());
        }
        List<UserInfo> userInfos = userInfoMapper.findUserInfoByUserName(userName);
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
            view.setGenderDesc(GenderEnum.fromValue(userInfo.getGender()).getMsg());
            view.setUserStatusDesc(UserInfoStatusEnum.fromValue(userInfo.getUserStatus()).getMsg());
            view.setUserTypeDesc(UserTypeEnum.fromValue(userInfo.getUserType()).getMsg());
            userInfoViews.add(view);
        });
    }

    /**
     * 常规方式注册新用户且不允许昵称重复
     *
     * @param reqUserInfo
     * @return
     */
    @Override
    public Result insertUser(ReqUserInfo reqUserInfo) {
        log.info("常规方式注册新用户且不允许昵称重复请求参数：{}", JSON.toJSONString(reqUserInfo));
        ReqUserInfoQuery reqUserInfoQuery = new ReqUserInfoQuery();
        reqUserInfoQuery.setUserNickname(reqUserInfo.getUserNickname());
        reqUserInfoQuery.setIdCard(reqUserInfo.getIdCard());
        reqUserInfoQuery.setMobile(reqUserInfo.getMobile());
        reqUserInfoQuery.setIsDelete(DeleteEnum.NO.getCode());
        //注册新用户，根据注册填充数据[昵称|手机号|身份证]去查询数据库(因为姓名可以重复)，如果存在则不允许注册新用户
        UserInfo queryUserInfo = userInfoMapper.findUserInfo(reqUserInfoQuery);
        if (!StringUtils.isEmpty(reqUserInfo.getUserName()) && queryUserInfo != null && reqUserInfo.getUserName().equals(queryUserInfo.getUserName())){
            return Result.error(BusinessEnum.USERINFO_EXIST.getCode(),BusinessEnum.USERINFO_EXIST.getMsg(),null);
        }
        if (!StringUtils.isEmpty(reqUserInfo.getUserNickname()) && queryUserInfo != null && reqUserInfo.getUserNickname().equals(queryUserInfo.getUserNickname())){
            return Result.error(BusinessEnum.USERINFO_EXIST.getCode(),BusinessEnum.USERINFO_EXIST.getMsg(),null);
        }
        if (!StringUtils.isEmpty(reqUserInfo.getIdCard()) && queryUserInfo != null && reqUserInfo.getIdCard().equals(queryUserInfo.getIdCard())){
            return Result.error(BusinessEnum.USERINFO_EXIST.getCode(),BusinessEnum.USERINFO_EXIST.getMsg(),null);
        }
        if (!StringUtils.isEmpty(reqUserInfo.getMobile()) && queryUserInfo != null && reqUserInfo.getMobile().equals(queryUserInfo.getMobile())){
            return Result.error(BusinessEnum.USERINFO_EXIST.getCode(),BusinessEnum.USERINFO_EXIST.getMsg(),null);
        }
        if (queryUserInfo != null && queryUserInfo.getUserStatus().equals(UserInfoStatusEnum.FROZEN.getCode())){
            return Result.error(BusinessEnum.USERINFO_STATUS_FROZENT.getCode(),BusinessEnum.USERINFO_STATUS_FROZENT.getMsg(),null);
        }
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqUserInfo.class, UserInfo.class, false);
        beanCopier.copy(reqUserInfo,userInfo,null);
        //新用户默认正常用户且进行密码加密
        userInfo.setPassword(AesUtil.encrypt(Constants.SECRET_KEY,reqUserInfo.getPassword()));
        userInfo.setUserStatus(UserInfoStatusEnum.NORMAL.getCode());
        userInfo.setFounder(reqUserInfo.getUserName());
        userInfo.setModifier(reqUserInfo.getUserName());
        userInfo.setIsDelete(DeleteEnum.NO.getCode());
        userInfo.setUserLevel(0);
        userInfo.setCreateDate(new Date());
        userInfo.setUpdateDate(new Date());
        return Result.success(userInfoMapper.insertSelective(userInfo));
    }

    /**
     * 更新用户信息
     *
     * @param reqUserInfoUpdate
     * @return
     */
    @Override
    public Result modifyUserInfo(ReqUserInfoUpdate reqUserInfoUpdate) {
        log.info("更新用户信息请求参数：{}", JSON.toJSONString(reqUserInfoUpdate));
        //更新用户信息先去检索数据库是否有该用户，查询结果为空则提示用户不存在
        UserInfo queryUserInfo = userInfoMapper.selectByPrimaryKey(reqUserInfoUpdate.getId());
        if (queryUserInfo == null){
            return Result.error(BusinessEnum.RECORD_NOT_EXIST.getCode(),BusinessEnum.RECORD_NOT_EXIST.getMsg(),null);
        }

        ReqUserInfoQuery reqUserInfoQuery = new ReqUserInfoQuery();
        reqUserInfoQuery.setUserStatus( UserInfoStatusEnum.NORMAL.getCode() );
        reqUserInfoQuery.setUserNickname(reqUserInfoUpdate.getUserNickname());
        reqUserInfoQuery.setMobile(reqUserInfoUpdate.getMobile());
        reqUserInfoQuery.setIsDelete(DeleteEnum.NO.getCode());
        //注册新用户，根据注册填充数据[昵称|手机号|身份证]去查询数据库(因为姓名可以重复)，如果存在则不允许注册新用户
        UserInfo updateBeforeQueryUserInfo = userInfoMapper.findUserInfo(reqUserInfoQuery);
        if (updateBeforeQueryUserInfo != null){
            return Result.error(BusinessEnum.USERINFO_MESSAGE_ALREADY_EXISTS.getCode(),BusinessEnum.USERINFO_MESSAGE_ALREADY_EXISTS.getMsg(),null);
        }

        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqUserInfoUpdate.class, UserInfo.class, false);
        beanCopier.copy(reqUserInfoUpdate,userInfo,null);
        if (!StringUtils.isEmpty(reqUserInfoUpdate.getPassword())){
            userInfo.setPassword(AesUtil.encrypt(Constants.SECRET_KEY,reqUserInfoUpdate.getPassword()));
        }
        return Result.success(userInfoMapper.updateByPrimaryKeySelective(userInfo));
    }

    /**
     * 根据用户id|用户昵称|用户手机号|身份证 获取唯一一条用户信息记录
     * @param reqUserInfoQuery
     * @return
     */
    @Override
    public UserInfoView findUserInfo(ReqUserInfoQuery reqUserInfoQuery) {
        log.info("根据用户id|用户昵称|用户手机号|身份证 获取唯一一条记录 请求参数：{}",JSON.toJSON(reqUserInfoQuery));
        reqUserInfoQuery.setUserStatus(UserInfoStatusEnum.NORMAL.getCode());
        reqUserInfoQuery.setIsDelete(DeleteEnum.NO.getCode());
        UserInfo queryUserInfo = userInfoMapper.findUserInfo(reqUserInfoQuery);
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
     * @param reqUserInfoQuery
     * @return
     */
    @Override
    public PageInfo<UserInfoView> findUserInfoPage(ReqUserInfoQuery reqUserInfoQuery) {
        log.info("根据条件进行查询且进行分页请求参数：{}",JSON.toJSON(reqUserInfoQuery));
        PageInfo<UserInfoView> pageInfo = null;
        try {
            Page<?> page = PageHelper.startPage(reqUserInfoQuery.getPageNum(),reqUserInfoQuery.getPageSize());
            List<UserInfo> userInfoList = userInfoMapper.findUserInfoPage(reqUserInfoQuery);
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
     * @param reqUserInfoUpdate
     * @return
     */
    @Override
    public Result changePassword(ReqUserInfoUpdate reqUserInfoUpdate) {
        log.info("用户进行修改密码 请求参数：{}",JSON.toJSON(reqUserInfoUpdate));
        UserInfo queryUserInfo = userInfoMapper.findUserInfoByUserNameAndPassword(reqUserInfoUpdate.getUserName(),AesUtil.encrypt(Constants.SECRET_KEY,reqUserInfoUpdate.getPassword()));
        if (queryUserInfo == null){
            return Result.error(BusinessEnum.RECORD_NOT_EXIST.getCode(),BusinessEnum.RECORD_NOT_EXIST.getMsg(),null);
        }
        reqUserInfoUpdate.setNewPassword(AesUtil.encrypt(Constants.SECRET_KEY,reqUserInfoUpdate.getNewPassword()));
        return Result.success(userInfoMapper.changePassword(reqUserInfoUpdate));
    }

    /**
     * 用户短信注册，发送验证码
     * @return
     */
    @Override
    @LoginLogAnnotation
    public Result messageRegister(String messageId,String signId,String mobile,String ip) {
        log.info("用户短信注册，发送验证码 请求参数：{},{},{},{}",messageId,signId,mobile,ip);
        if (StringUtils.isEmpty(mobile)){
            return Result.error(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg(),null);
        }
        ReqUserInfoQuery reqUserInfoQuery = new ReqUserInfoQuery();
        reqUserInfoQuery.setMobile(mobile);
        reqUserInfoQuery.setIsDelete(DeleteEnum.NO.getCode());
        //如果当前手机号已在系统中存在，则进行提示：该手机号用户已存在，不能重复注册
        UserInfo userInfo = userInfoMapper.findUserInfo(reqUserInfoQuery);
        if (userInfo != null){
            return Result.error(BusinessEnum.USERINFO_EXIST.getCode(),BusinessEnum.USERINFO_EXIST.getMsg(),null);
        }
        //发送短信为注册时,如果当前手机号| ip 30分钟内频繁的发送短信超过5条，则视为用户进行恶意攻击
        ReqMessageRecordQuery2 messageCountQuery2 = new ReqMessageRecordQuery2();
        messageCountQuery2.setMessageType(MessageTypeEnum.REGISTER.getCode());
        //messageCountQuery2.setSendIp(ip);
        messageCountQuery2.setMobile(mobile);
        messageCountQuery2.setCurrentSendDate(DateUtil.dateToString(new Date()));
        List<MessageRecordView> messageCount = messageCountService.findMessageCount(messageCountQuery2);
        if (messageCount.size() > Constants.MESSAGE_COUNT){
            return Result.error(BusinessEnum.FREQUENT_OPERATION_PLEASE_TRY_AGAIN_LATER.getCode(),BusinessEnum.FREQUENT_OPERATION_PLEASE_TRY_AGAIN_LATER.getMsg(),null);
        }
        log.info("当前手机号 | ip 30分钟之内发送的短信条数为：{}",messageCount.size());
        String sendMsm = smsSenderUtil.sendMsm(mobile, signId,messageId);
        //如果调用发送短信返回信息为空，则抛出错误信息
        if (StringUtils.isEmpty(sendMsm)){
            return Result.error(BusinessEnum.CALL_SEND_MSM_NULL.getCode(),BusinessEnum.CALL_SEND_MSM_NULL.getMsg(),null);
        }
        JSONObject json = JSON.parseObject(sendMsm);
        JSONMessage jsonMessage = JSONObject.toJavaObject(json, JSONMessage.class);
        log.info("用户短信注册，发送验证码:{}",JSON.toJSONString(jsonMessage));
        return Result.success("短信发送成功");
    }

    /**
     * 用户短信注册，输入密码并校验验证码，验证通过则注册成功，验证失败则注册失败
     *
     * @param registerCode
     * @return
     */
    @Override
    public Result checkRegisterCode(ReqRegisterCode registerCode) {
        if (StringUtils.isEmpty(registerCode.getMobile())
                || StringUtils.isEmpty(registerCode.getPassword())
                || StringUtils.isEmpty(registerCode.getRegisterCode())){
            return Result.error(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg(),null);
        }
        ReqUserInfoQuery reqUserInfoQuery = new ReqUserInfoQuery();
        reqUserInfoQuery.setMobile(registerCode.getMobile());
        reqUserInfoQuery.setIsDelete(DeleteEnum.NO.getCode());
        //如果当前手机号已在系统中存在，则进行提示：该手机号用户已存在，不能重复注册
        UserInfo userInfo = userInfoMapper.findUserInfo(reqUserInfoQuery);
        if (userInfo != null){
            return Result.error(BusinessEnum.USERINFO_NOT_EXIST.getCode(),BusinessEnum.USERINFO_NOT_EXIST.getMsg(),null);
        }

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        String VerificationCode =  request.getSession(true).getServletContext().getAttribute(registerCode.getMobile()).toString();

        //如果发送验证码的手机号和当前手机号不同，则抛出异常;
        //如果验证码错误，则抛出异常
        if (!registerCode.getRegisterCode().equals(VerificationCode)){
            return Result.error(BusinessEnum.VERIFICATION_CODE_ERROR_PLEASE_TRY_AGAIN.getCode(),BusinessEnum.VERIFICATION_CODE_ERROR_PLEASE_TRY_AGAIN.getMsg(),null);
        }
        UserInfo userInfoParams = new UserInfo();
        userInfoParams.setMobile(registerCode.getMobile());
        //密码加密，默认正常用户
        userInfoParams.setPassword(AesUtil.encrypt(Constants.SECRET_KEY,registerCode.getPassword()));
        userInfoParams.setUserStatus(UserInfoStatusEnum.NORMAL.getCode());
        userInfoParams.setIsDelete(DeleteEnum.NO.getCode());
        int registerNum = userInfoMapper.insertSelective(userInfoParams);

        if (registerNum > 0){
            //注册成功
            request.getSession(true).getAttribute("messageVerificationCode");
           return Result.success("恭喜您注册成功");
        }else{
            return Result.success("对不起，注册失败，请重新注册");
        }
    }

    /**
     * 根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录
     *
     * @param reqLoginUserInfo
     * @return
     */
    @Override
    @LoginLogAnnotation
    public Result ordinaryLogin(ReqLoginUserInfo reqLoginUserInfo) {
        log.info(" 根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录请求参数：{}",JSON.toJSONString(reqLoginUserInfo));

        //登录前根据[用户名 or 昵称 or 身份证id or 手机号]查询数据库，判断数据库有没有该用户 & 检查登录者的账号是否是正常账号
        UserInfo queryUserInfo = userInfoMapper.loginQueryUserInfo(reqLoginUserInfo.getLoginUser());
        //根据条件查询数据库:
        // 1.不存在则抛出异常;
        // 2.存在，但状态为冻结，则抛出异常
        if (queryUserInfo == null){
            return Result.error(BusinessEnum.USERINFO_NOT_EXIST.getCode(),BusinessEnum.USERINFO_NOT_EXIST.getMsg(),null);
        }else if(queryUserInfo != null && queryUserInfo.getUserStatus().equals(UserInfoStatusEnum.FROZEN.getCode())){
            return Result.error(BusinessEnum.USERINFO_FROZEN.getCode(),BusinessEnum.USERINFO_FROZEN.getMsg(),null);
        }else if(!queryUserInfo.getPassword().equals(AesUtil.encrypt(Constants.SECRET_KEY,reqLoginUserInfo.getPassword()))){
            return Result.error(BusinessEnum.LOGIN_ERROR.getCode(),BusinessEnum.LOGIN_ERROR.getMsg(),null);
        }

        Map<String,Object> objectMap = new HashMap<>();

        String token = JwtUtil.createJWT(6000000, queryUserInfo);
        objectMap.put("token",token);
        objectMap.put("userInfo",queryUserInfo);
        return Result.success(objectMap);
    }

    /**
     * 根据Id 获取用户记录详情
     *
     * @param id
     * @return
     */
    @Override
    public Result findUserById(Integer id) {
        log.info("根据Id 获取用户记录详情 请求参数：{}",id);
        if (StringUtils.isEmpty(id.toString())){
            return Result.error(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg(),null);
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if (userInfo == null){
            return null;
        }
        UserInfoView view = new UserInfoView();
        BeanCopier beanCopier = BeanCopier.create(UserInfo.class,UserInfoView.class,false);
        beanCopier.copy(userInfo,view,null);
        return Result.success(view);
    }

    /**
     * 根据Id 获取用户记录详情
     *
     * @param id
     * @return
     */
    @Override
    public UserInfoView findUserInfoById(Integer id) {
        log.info("根据Id 获取用户记录详情 请求参数：{}",id);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if (userInfo == null){
            return null;
        }
        UserInfoView view = new UserInfoView();
        BeanCopier beanCopier = BeanCopier.create(UserInfo.class,UserInfoView.class,false);
        beanCopier.copy(userInfo,view,null);
        return view;
    }

    /**
     * 使用短信进行登录，发送验证码
     * @return
     */
    @Override
    @LoginLogAnnotation
    public Result loginByMessage(String messageId,String signId,String mobile,String ip) {
        log.info("使用短信进行登录，发送验证码 请求参数：{},{},{},{}",messageId,signId,mobile,ip);
        String sendMsm = smsSenderUtil.sendMsm(mobile, signId, messageId);
        //如果调用发送短信返回信息为空，则抛出错误信息
        if (StringUtils.isEmpty(sendMsm)){
            return Result.error(BusinessEnum.CALL_SEND_MSM_NULL.getCode(),BusinessEnum.CALL_SEND_MSM_NULL.getMsg(),null);
        }
        JSONObject json = JSON.parseObject(sendMsm);
        JSONMessage jsonMessage = JSONObject.toJavaObject(json, JSONMessage.class);
        log.info("使用短信进行登录，发送验证码:{}",JSON.toJSONString(jsonMessage));
        return Result.success("短信发送成功");
    }

    /**
     * 用户短信登录，输入验证码，验证通过则登录成功，验证失败则登录失败
     *
     * @param reqLoginUserInfo
     * @return
     */
    @Override
    public Result checkLoginCode(ReqLoginUserInfo reqLoginUserInfo) {
        if (StringUtils.isEmpty(reqLoginUserInfo.getMobile())
                || StringUtils.isEmpty(reqLoginUserInfo.getVerificationCode())){
            return Result.error(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg(),null);
        }

        UserInfoView userInfoView = new UserInfoView();

        ReqUserInfo reqUserInfo = new ReqUserInfo();
        BeanCopier copier = BeanCopier.create(ReqLoginUserInfo.class, ReqUserInfo.class, false);
        copier.copy(reqLoginUserInfo,reqUserInfo,null);
        //首先去判断数据库有没有该用户 & 登录者的账号是否是正常账号
        // 1.为空则记录日志，抛出异常；2 不为空判断验证码
        UserInfo queryUserInfo = userInfoMapper.loginQueryUserInfo(reqLoginUserInfo.getMobile());
        if (queryUserInfo == null){
            return Result.error(BusinessEnum.USERINFO_NOT_EXIST.getCode(),BusinessEnum.USERINFO_NOT_EXIST.getMsg(),null);
        }else{
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();

            String mobile = (String) request.getSession(true).getAttribute("mobile");
            String VerificationCode = (String) request.getSession(true).getAttribute("messageVerificationCode");

            if (!reqLoginUserInfo.getMobile().equals(mobile)){
                return Result.error(BusinessEnum.LOGIN_VERIFICATION_MOBILE_DIFFERENT.getCode(),BusinessEnum.LOGIN_VERIFICATION_MOBILE_DIFFERENT.getMsg(),null);
            }else if (!reqLoginUserInfo.getVerificationCode().equals(VerificationCode)){
                return Result.error(BusinessEnum.VERIFICATION_CODE_ERROR_PLEASE_TRY_AGAIN.getCode(),BusinessEnum.VERIFICATION_CODE_ERROR_PLEASE_TRY_AGAIN.getMsg(),null);
            }else{
                BeanCopier beanCopier = BeanCopier.create(UserInfo.class,UserInfoView.class,false);
                beanCopier.copy(queryUserInfo,userInfoView,null);

                ReqLoginLog loginLog = new ReqLoginLog();
                loginLog.setLoginDate(new Date());
                loginLog.setLoginIp(reqLoginUserInfo.getLoginIp());
                loginLog.setUserId(0);
                loginLog.setLoginStatus(LoginStatusEnum.SUCCESS.getCode());
                loginLog.setFailRemark("短信登录成功");
                log.info("记录登录日志请求参数：{}");

                String token = JwtUtil.createJWT(6000000, queryUserInfo);
                Map<String,Object> objectMap = new HashMap<>();
                objectMap.put("token",token);
                objectMap.put("userInfo",queryUserInfo);
                return Result.success(objectMap);
            }
        }
    }

    /**
     * 根据登录token获取登录用户的昵称，头像，钱包余额，收藏数，浏览数，我的兼职等信息
     *
     * @param token
     * @return
     */
    @Override
    public UserInfoManagerView findMoWaByToken(String token) {
        Claims claims = JwtUtil.parseJWT(token);
        Integer userId = Integer.parseInt(claims.get("userId").toString()) ;

        //用户信息
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        //用户收藏数量
        List<CollectionRecordInfo> byUserIdCollection = recordInfoService.findByUserId(userId);
        //用户浏览数量
        List<BrowseRecordInfo> byUserIdBrowse = browseRecordInfoService.findByUserId(userId);
        //用户已报名数量
        ReqSignUpInfoQuery signUpInfoQuery = new ReqSignUpInfoQuery();
        signUpInfoQuery.setUserId( userId );
        signUpInfoQuery.setIsDelete( DeleteEnum.NO.getCode() );
        List<SignUpInfoView> signUpInfoViews = signUpInfoService.findSignUpInfo( signUpInfoQuery );
        Integer hadApplyNum = signUpInfoViews.stream().filter(sign -> sign.getState().equals(SignUpInfoEnum.WAIT_ADMISSION.getCode())).collect(toList()).size();
        Integer hadAdmissionNum = signUpInfoViews.stream().filter(sign -> sign.getState().equals(SignUpInfoEnum.HAD_ADMISSION.getCode())).collect(toList()).size();
        Integer hadSettlementNum = signUpInfoViews.stream().filter(sign -> sign.getState().equals(SignUpInfoEnum.HAD_SETTLEMENT.getCode())).collect(toList()).size();
        Integer waitEvaluateNum = signUpInfoViews.stream().filter(sign -> sign.getState().equals(SignUpInfoEnum.WAIT_EVALUATE.getCode())).collect(toList()).size();

        UserInfoManagerView view = new UserInfoManagerView();
        view.setUserNickName( userInfo.getUserNickname() );
        view.setHeadImg( userInfo.getUserHead() );
        view.setAmount(userInfo.getAmount() == null? null: userInfo.getAmount());
        view.setCollectionNum(byUserIdCollection.size());
        view.setBrowseNum(byUserIdBrowse.size());
        view.setHadApplyNum(hadApplyNum );
        view.setHadAdmissionNum( hadAdmissionNum );
        view.setHadSettlementNum( hadSettlementNum );
        view.setWaitEvaluateNum( waitEvaluateNum );
        return view;
    }

}
