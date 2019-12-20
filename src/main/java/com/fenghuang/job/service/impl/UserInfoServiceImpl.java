package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.dao.cluster.UserInfoClusterMapper;
import com.fenghuang.job.dao.master.UserInfoMasterMapper;
import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.LoginStatus;
import com.fenghuang.job.enums.SystemCodeEnum;
import com.fenghuang.job.enums.UserInfoStatusEnum;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.request.ReqLoginLog;
import com.fenghuang.job.request.ReqLoginUserInfo;
import com.fenghuang.job.request.ReqMessage;
import com.fenghuang.job.request.ReqUserInfo;
import com.fenghuang.job.service.LoginLogService;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.utils.AesUtil;
import com.fenghuang.job.utils.SmsSenderUtil;
import com.fenghuang.job.utils.StringCustomizedUtils;
import com.fenghuang.job.view.JSONMessage;
import com.fenghuang.job.view.MessageView;
import com.fenghuang.job.view.RegisterCodeView;
import com.fenghuang.job.view.UserInfoView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    LoginLogService loginLogService;

    @Autowired
    SmsSenderUtil smsSenderUtil;

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
        UserInfo queryUserInfo = userInfoMasterMapper.findUserInfoByUserNameAndPassword(reqUserInfo);
        if (queryUserInfo == null){
            throw new BusinessException(BusinessEnum.RECORD_NOT_EXIST.getCode(),BusinessEnum.RECORD_NOT_EXIST.getMsg());
        }
        reqUserInfo.setNewPassword(AesUtil.encrypt(Constants.SECRET_KEY,reqUserInfo.getNewPassword()));
        return userInfoMasterMapper.changePassword(reqUserInfo);
    }

    /**
     * 用户短信注册，发送验证码
     *
     * @param reqMessage
     * @return
     */
    @Override
    public MessageView messageRegister(ReqMessage reqMessage) {
        log.info("用户短信注册，发送验证码 请求参数：{}",JSON.toJSONString(reqMessage));
        ReqUserInfo reqUserInfo = new ReqUserInfo();
        reqUserInfo.setMobile(reqMessage.getMobile());
        UserInfo userInfo = userInfoMasterMapper.findUserInfo(reqUserInfo);
        if (userInfo != null){
            throw new BusinessException(BusinessEnum.USERINFO_NOT_EXIST.getCode(),BusinessEnum.USERINFO_NOT_EXIST.getMsg());
        }
        String sendMsm = smsSenderUtil.sendMsm(reqMessage.getMobile(), reqMessage.getSignId(), reqMessage.getMessageId());
        if (StringUtils.isEmpty(sendMsm)){
            throw new BusinessException(BusinessEnum.CALL_SEND_MSM_NULL.getCode(),BusinessEnum.CALL_SEND_MSM_NULL.getMsg());
        }
        JSONObject json = JSON.parseObject(sendMsm);
        JSONMessage jsonMessage = JSONObject.toJavaObject(json, JSONMessage.class);
        MessageView messageView = new MessageView();
        if (jsonMessage.getCode().equals(SystemCodeEnum.SUCCESS.getCode())){
            messageView.setCode(SystemCodeEnum.SUCCESS.getCode());
            messageView.setDesc("短信发送成功");
        }else if (jsonMessage.getCode().equals(SystemCodeEnum.EXCEPTION.getCode()) ){
            messageView.setCode(SystemCodeEnum.ERROR.getCode());
            messageView.setDesc("短信发送异常");
        }else{
            messageView.setCode(SystemCodeEnum.ERROR.getCode());
            messageView.setDesc("网络问题，请稍后重试");
        }
        return messageView;
    }

    /**
     * 用户短信注册，输入密码并校验验证码，验证通过则注册成功，验证失败则注册失败
     *
     * @param registerCodeView
     * @return
     */
    @Override
    public MessageView checkRegisterCode(RegisterCodeView registerCodeView) {
        if (StringUtils.isEmpty(registerCodeView.getMobile())
                || StringUtils.isEmpty(registerCodeView.getPassword())
                || StringUtils.isEmpty(registerCodeView.getRepeatPassword())
                || StringUtils.isEmpty(registerCodeView.getRegisterCode())){
            throw new BusinessException(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg());
        }
        if (!StringCustomizedUtils.stringTrim(registerCodeView.getPassword()).equals(StringCustomizedUtils.stringTrim(registerCodeView.getRepeatPassword()))){
            throw new BusinessException(BusinessEnum.PASSWORDS_INCONSISTENT.getCode(),BusinessEnum.PASSWORDS_INCONSISTENT.getMsg());
        }

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();

        String mobile = (String) request.getSession(true).getAttribute("mobile");
        String VerificationCode = (String) request.getSession(true).getAttribute("messageVerificationCode");

        if (!registerCodeView.getMobile().equals(mobile)){
            throw new BusinessException(BusinessEnum.REGISTER_VERIFICATION_MOBILE_DIFFERENT.getCode(),BusinessEnum.REGISTER_VERIFICATION_MOBILE_DIFFERENT.getMsg());
        }else if (!registerCodeView.getRegisterCode().equals(VerificationCode)){
            throw new BusinessException(BusinessEnum.VERIFICATION_CODE_ERROR_PLEASE_TRY_AGAIN.getCode(),BusinessEnum.VERIFICATION_CODE_ERROR_PLEASE_TRY_AGAIN.getMsg());
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setMobile(registerCodeView.getMobile());
        userInfo.setPassword(AesUtil.encrypt(Constants.SECRET_KEY,registerCodeView.getPassword()));
        userInfo.setUserStatus(UserInfoStatusEnum.NORMAL.getCode());
        int registerNum = userInfoMasterMapper.insertSelective(userInfo);

        MessageView messageView = new MessageView();
        if (registerNum > 0){
            messageView.setCode(SystemCodeEnum.SUCCESS.getCode());
            messageView.setDesc("恭喜您注册成功");
        }else{
            messageView.setCode(SystemCodeEnum.ERROR.getCode());
            messageView.setDesc("对不起，注册失败，请重新注册");
        }
        return messageView;
    }

    /**
     * 根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录
     *
     * @param reqLoginUserInfo
     * @return
     */
    @Override
    public UserInfoView login(ReqLoginUserInfo reqLoginUserInfo) {
        if (StringUtils.isEmpty(reqLoginUserInfo.getLoginType())){
            throw new BusinessException(BusinessEnum.LOGIN_TYPE_NULL.getCode(),BusinessEnum.LOGIN_TYPE_NULL.getMsg());
        }
        Integer loginType = reqLoginUserInfo.getLoginType();
        //首先去判断数据库有没有该用户 & 登录者的账号是否是正常账号
        ReqUserInfo reqUserInfo = new ReqUserInfo();
        BeanCopier copier = BeanCopier.create(ReqLoginUserInfo.class, ReqUserInfo.class, false);
        copier.copy(reqLoginUserInfo,reqUserInfo,null);
        UserInfo queryUserInfo = userInfoMasterMapper.loginQueryUserInfo(reqUserInfo);

        if (queryUserInfo == null){
            ReqLoginLog loginLog = new ReqLoginLog();
            loginLog.setLoginDate(new Date());
            loginLog.setLoginIp(reqLoginUserInfo.getLoginIp());
            loginLog.setUserId(0);
            loginLog.setLoginStatus(LoginStatus.FAIL.getCode());
            loginLog.setFailRemark(BusinessEnum.USERINFO_EXIST.getMsg());
            log.info("记录登录日志请求参数：{}");
            loginLogService.insertLoginLog(loginLog);
            throw new BusinessException(BusinessEnum.USERINFO_EXIST.getCode(),BusinessEnum.USERINFO_EXIST.getMsg());
        }else if(queryUserInfo != null & queryUserInfo.getUserStatus().equals(UserInfoStatusEnum.FROZEN.getCode())){
            ReqLoginLog loginLog = new ReqLoginLog();
            loginLog.setLoginDate(new Date());
            loginLog.setLoginIp(reqLoginUserInfo.getLoginIp());
            loginLog.setUserId(queryUserInfo.getId());
            loginLog.setLoginStatus(LoginStatus.FAIL.getCode());
            loginLog.setFailRemark(BusinessEnum.USERINFO_FROZEN.getMsg());
            log.info("记录登录日志请求参数：{}");
            loginLogService.insertLoginLog(loginLog);
            throw new BusinessException(BusinessEnum.USERINFO_FROZEN.getCode(),BusinessEnum.USERINFO_FROZEN.getMsg());
        }

        UserInfo userInfo = null;
        UserInfoView userInfoView = new UserInfoView();
        switch (loginType){
            case 1:
                userInfo = userInfoMasterMapper.findUserByUserNameAndPassword(reqLoginUserInfo.getUserName(),AesUtil.encrypt(Constants.SECRET_KEY,reqLoginUserInfo.getPassword()));
                break;
            case 2:
                userInfo = userInfoMasterMapper.findUserByUserNicknameAndPassword(reqLoginUserInfo.getUserNickname(),AesUtil.encrypt(Constants.SECRET_KEY,reqLoginUserInfo.getPassword()));
                break;
            case 3:
                userInfo = userInfoMasterMapper.findMobileAndPassword(reqLoginUserInfo.getMobile(),AesUtil.encrypt(Constants.SECRET_KEY,reqLoginUserInfo.getPassword()));
                break;
            case 4:
                userInfo = userInfoMasterMapper.findIdCardAndPassword(reqLoginUserInfo.getIdCard(),AesUtil.encrypt(Constants.SECRET_KEY,reqLoginUserInfo.getPassword()));
                break;
            default:
                userInfo = userInfoMasterMapper.findUserByUserNameAndPassword(reqLoginUserInfo.getUserName(),AesUtil.encrypt(Constants.SECRET_KEY,reqLoginUserInfo.getPassword()));
                break;
        }
        if (userInfo == null){
            ReqLoginLog loginLog = new ReqLoginLog();
            loginLog.setLoginDate(new Date());
            loginLog.setLoginIp(reqLoginUserInfo.getLoginIp());
            loginLog.setUserId(queryUserInfo.getId());
            loginLog.setLoginStatus(LoginStatus.FAIL.getCode());
            loginLog.setFailRemark(BusinessEnum.LOGIN_ERROR.getMsg());
            log.info("记录登录日志请求参数：{}");
            loginLogService.insertLoginLog(loginLog);
            throw new BusinessException(BusinessEnum.LOGIN_ERROR.getCode(),BusinessEnum.LOGIN_ERROR.getMsg());
        }else{
            ReqLoginLog loginLog = new ReqLoginLog();
            loginLog.setLoginDate(new Date());
            loginLog.setLoginIp(reqLoginUserInfo.getLoginIp());
            loginLog.setUserId(queryUserInfo.getId());
            loginLog.setLoginStatus(LoginStatus.SUCCESS.getCode());
            loginLog.setFailRemark("登录成功");
            log.info("记录登录日志请求参数：{}",JSON.toJSONString(loginLog));
            loginLogService.insertLoginLog(loginLog);
        }
        BeanCopier beanCopier = BeanCopier.create(UserInfo.class, UserInfoView.class, false);
        beanCopier.copy(userInfo,userInfoView,null);
        return userInfoView;
    }

    public static String dateToString(){
       return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());
    }



}
