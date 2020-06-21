package com.fenghuang.job.aspect;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.UserInfoMapper;
import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.enums.LoginStatusEnum;
import com.fenghuang.job.request.ReqLoginLog;
import com.fenghuang.job.request.ReqLoginUserInfo;
import com.fenghuang.job.service.LoginLogService;
import com.fenghuang.job.service.MessageRecordService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: luoxian
 * @Date: 2020/6/8 11:22
 * @Email: 15290810931@163.com
 */
@Component
@Aspect
@Order(2)
@Slf4j
public class LogAndSendMessageAspect {

    @Autowired
    LoginLogService loginLogService;

    @Autowired
    MessageRecordService messageRecordService;

    @Resource
    UserInfoMapper userInfoMapper;

    //根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录
    private final static String SAVE_ORDINARY_LOGIN_METHOD = "ordinaryLogin";

    //使用短信进行登录，发送验证码
    private final static String SAVE_LOGIN_MESSAGE_METHOD = "loginByMessage";

    //用户短信注册，发送验证码
    private final static String MESSAGE_REGISTER_METHOD = "messageRegister";

    //通过短信找回密码-发送短信
    private final static String MESSAGE_FIND_PWD_METHOD = "messageFindPwd";

    //用户修改手机号-发送验证码
    private final static String MODIFY_MOBILE_MESSAGE_METHOD = "modifyMobileMessage";

    //商家使用短信注册，发送验证码
    private final static String REGISTER_MERCHANT_SENDMESSAGE_METHOD = "registerMerchantSendMessage";

    @Around(value = "@annotation(LogAndSendMessageAnnotation)")
    public Object interceptUpdatePrice(ProceedingJoinPoint pjp) {
        Object result = new Object();
        Method targetMethod = ((MethodSignature) (pjp.getSignature())).getMethod();
        String methodName = targetMethod.getName();
        Object[] args = pjp.getArgs();

        try{
            result = pjp.proceed(args);
            //可以拿到结果
            actionMthod(methodName, args, result);
        }catch (Throwable throwable){
            throwable.getMessage();
        }
        return result;
    }

    private void actionMthod(String methodName, Object[] args, Object ret) {
        switch(methodName){
            case SAVE_ORDINARY_LOGIN_METHOD :
                ReqLoginUserInfo loginUserInfo = (ReqLoginUserInfo) args[0];
                saveLoginLog(loginUserInfo);
                break;
            case SAVE_LOGIN_MESSAGE_METHOD :
                String mobile = args[2].toString();
                String ip = args[3].toString();
                Integer messageType = 3;
                saveSendMessageRecord(ip,mobile,messageType);
                break;
            case MESSAGE_REGISTER_METHOD :
                String registerPhone = args[2].toString();
                String registerIp = args[3].toString();
                Integer registerMessageType = 1;
                saveSendMessageRecord(registerIp,registerPhone,registerMessageType);
                break;
            case MESSAGE_FIND_PWD_METHOD :
                String  messageFindPwdPhone = args[2].toString();
                String  messageFindPwdIp = args[3].toString();
                Integer messageFindPwdType = 2;
                saveSendMessageRecord(messageFindPwdIp,messageFindPwdPhone,messageFindPwdType);
                break;
            case MODIFY_MOBILE_MESSAGE_METHOD :
                String  modifyPhone = args[2].toString();
                String  modifyIp = args[3].toString();
                Integer modifyType = 4;
                saveSendMessageRecord(modifyIp,modifyPhone,modifyType);
                break;
            case REGISTER_MERCHANT_SENDMESSAGE_METHOD :
                String  merchantResgisterPhone = args[2].toString();
                String  merchantResgisterIp = args[3].toString();
                Integer merchantResgisterType = 5;
                saveSendMessageRecord(merchantResgisterIp,merchantResgisterPhone,merchantResgisterType);
                break;
            default:
                break;
        }
    }

    /**
     * 通过aop 切面保存登录日志记录
     * @param loginUserInfo
     */
    private void saveLoginLog(ReqLoginUserInfo loginUserInfo){
        UserInfo queryUserInfo = userInfoMapper.loginQueryUserInfo(loginUserInfo.getLoginUser());
        if (queryUserInfo == null){
            ReqLoginLog loginLog = new ReqLoginLog();
            loginLog.setLoginDate(new Date());
            loginLog.setLoginIp(loginUserInfo.getLoginIp());
            loginLog.setUserId(null);
            loginLog.setLoginStatus(LoginStatusEnum.FAIL.getCode());
            loginLog.setFailRemark("登录失败，未找到该用户");
            log.info("记录登录日志请求参数：{}",JSON.toJSONString(loginLog));
            loginLogService.insertLoginLog(loginLog);
        }
        ReqLoginLog loginLog = new ReqLoginLog();
        loginLog.setLoginDate(new Date());
        loginLog.setLoginIp(loginUserInfo.getLoginIp());
        loginLog.setUserId(queryUserInfo.getId());
        loginLog.setLoginStatus(LoginStatusEnum.SUCCESS.getCode());
        loginLog.setFailRemark("登录成功");
        loginLog.setUserName(queryUserInfo.getUserName());
        log.info("记录登录日志请求参数：{}",JSON.toJSONString(loginLog));
        loginLogService.insertLoginLog(loginLog);
    }

    /**
     * 通过aop 切面保存短信发送统计日志记录
     */
    public void saveSendMessageRecord(String ip,String mobile,Integer messageType){
        messageRecordService.insertMessageRecordByType(ip, mobile, messageType);
    }
}
