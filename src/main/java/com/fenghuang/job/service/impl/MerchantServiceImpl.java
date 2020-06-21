package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.aspect.LogAndSendMessageAnnotation;
import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.dao.master.MerchantMapper;
import com.fenghuang.job.entity.Merchant;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.entity.UserInfo;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.MerchantStateEnum;
import com.fenghuang.job.enums.MessageTypeEnum;
import com.fenghuang.job.request.ReqLoginUserInfo;
import com.fenghuang.job.request.ReqMerchant;
import com.fenghuang.job.request.ReqMerchantLogin;
import com.fenghuang.job.service.MerchantService;
import com.fenghuang.job.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/20 11:14
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Resource
    MerchantMapper merchantMapper;

    @Autowired
    SmsSenderUtil smsSenderUtil;

    @Autowired
    UserInfoByTokenSerivce userInfoByTokenSerivce;

    /**
     * 商家使用短信注册，发送验证码
     *
     * @param messageId
     * @param signId
     * @param mobile
     * @param ip
     * @return
     */
    @Override
    @LogAndSendMessageAnnotation
    public Result registerMerchantSendMessage(String messageId, String signId, String mobile, String ip) {
        log.info( "商家使用短信注册，发送验证码请求参数：{}",mobile );
        //统计30分钟内操作短信的频率，判断是否恶意攻击
        if(userInfoByTokenSerivce.maliciousAttack(mobile,ip, MessageTypeEnum.MERCHANT_REGISTER.getCode()) ==1){
            return Result.error( BusinessEnum.FREQUENT_OPERATION_PLEASE_TRY_AGAIN_LATER.getCode(),BusinessEnum.FREQUENT_OPERATION_PLEASE_TRY_AGAIN_LATER.getMsg(),null);
        }

        String sendMsm = smsSenderUtil.sendMsm(mobile, signId, messageId);
        //如果调用发送短信返回信息为空，则抛出错误信息
        if (StringUtils.isEmpty(sendMsm)){
            return Result.error(BusinessEnum.CALL_SEND_MSM_NULL.getCode(),BusinessEnum.CALL_SEND_MSM_NULL.getMsg(),null);
        }
        return Result.success("短信发送成功");
    }

    /**
     * 商家短信注册，输入验证码，验证通过则登录成功，验证失败则登录失败
     *
     * @param reqLoginUserInfo
     * @return
     */
    @Override
    public Result merchantValidateRegisterCode(ReqLoginUserInfo reqLoginUserInfo) {
        log.info( "商家短信登录，输入验证码，验证通过则登录成功，验证失败则登录失败请求参数：{}", JSON.toJSONString( reqLoginUserInfo ) );

        if (StringUtils.isEmpty( reqLoginUserInfo.getMobile() )
                || StringUtils.isEmpty( reqLoginUserInfo.getVerificationCode() )) {
            return Result.error( BusinessEnum.MISSING_PARAMETERS.getCode(), BusinessEnum.MISSING_PARAMETERS.getMsg(), null );
        }
        //根据手机号查查询
        Merchant merchant = merchantMapper.queryMerchantByMobile( reqLoginUserInfo.getMobile() );
        if (merchant != null) {
            return Result.error( BusinessEnum.USERINFO_ALREADY_EXISTS.getCode(), BusinessEnum.USERINFO_ALREADY_EXISTS.getMsg(), null );
        }

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        String VerificationCode = request.getSession( true ).getServletContext().getAttribute( reqLoginUserInfo.getMobile() ).toString();

        //如果发送验证码的手机号和当前手机号不同，则抛出异常;
        //如果验证码错误，则抛出异常
        if (!reqLoginUserInfo.getVerificationCode().equals( VerificationCode )) {
            return Result.error( BusinessEnum.VERIFICATION_CODE_ERROR_PLEASE_TRY_AGAIN.getCode(), BusinessEnum.VERIFICATION_CODE_ERROR_PLEASE_TRY_AGAIN.getMsg(), null );
        }

        Merchant record = new Merchant();
        record.setAccount( StringCustomizedUtils.randomAlphabetic(5) );
        record.setCreateDate( new Date() );
        record.setUpdateDate( new Date() );
        record.setStatus( MerchantStateEnum.APPLY.getCode() );
        record.setMobile( reqLoginUserInfo.getMobile() );
        record.setUserLevel( 0 );
        record.setPassword( AesUtil.encrypt( Constants.SECRET_KEY, reqLoginUserInfo.getPassword() ) );
        int registerNum = merchantMapper.insertSelective( record );

        if (registerNum > 0) {
            //注册成功
            request.getSession( true ).getAttribute( "messageVerificationCode" );
            return Result.success( "恭喜您注册成功" );
        } else {
            return Result.success( "对不起，注册失败，请重新注册" );
        }
    }

    /**
     * 商家普通方式注册
     *
     * @param reqMerchant
     * @return
     */
    @Override
    public Result merchantOrdinaryRegister(ReqMerchant reqMerchant) {
        log.info( "商家普通方式注册请求参数：{}",JSON.toJSONString( reqMerchant ) );

        if (!StringUtils.isEmpty( reqMerchant.getMobile() )){
            Merchant merchant = merchantMapper.queryMerchantByMobile( reqMerchant.getMobile() );
            if (merchant != null){
                return Result.error( BusinessEnum.USERINFO_ALREADY_EXISTS.getCode(), BusinessEnum.USERINFO_ALREADY_EXISTS.getMsg(), null );
            }
        }
        Merchant record = new Merchant();
        BeanCopier beanCopier = BeanCopier.create(ReqMerchant.class,Merchant.class,false  );
        beanCopier.copy( reqMerchant,record,null );
        record.setAccount( StringCustomizedUtils.randomAlphabetic(5) );
        record.setCreateDate( new Date() );
        record.setUpdateDate( new Date() );
        record.setStatus( MerchantStateEnum.APPLY.getCode() );
        record.setMobile( reqMerchant.getMobile() );
        record.setUserLevel( 0 );
        record.setPassword( AesUtil.encrypt( Constants.SECRET_KEY, reqMerchant.getPassword() ) );
        int registerNum = merchantMapper.insertSelective( record );
        if (registerNum > 0) {
            return Result.success( "恭喜您注册成功" );
        } else {
            return Result.error( "对不起，注册失败，请重新注册" );
        }
    }

    /**
     * 商家登录
     *
     * @param reqMerchant
     * @return
     */
    @Override
    public Result merchantLogin(ReqMerchantLogin reqMerchant) {
        log.info( "商家登录请求参数：{}",JSON.toJSONString( reqMerchant ) );
        Merchant merchantByLogin = merchantMapper.findMerchantByLogin( reqMerchant.getMerchantLoginUser() );
        if (merchantByLogin == null){
            return Result.error( BusinessEnum.USERINFO_NOT_EXIST.getCode(), BusinessEnum.USERINFO_NOT_EXIST.getMsg(), null );
        }
        if (merchantByLogin.getStatus().equals( MerchantStateEnum.INVALID.getCode() )){
            return Result.error( BusinessEnum.USERINFO_FROZEN.getCode(), BusinessEnum.USERINFO_FROZEN.getMsg(), null );
        }
        if (!AesUtil.encrypt( Constants.SECRET_KEY, reqMerchant.getPassword() ).equals( merchantByLogin.getPassword() )){
            return Result.error( BusinessEnum.LOGIN_ERROR.getCode(), BusinessEnum.LOGIN_ERROR.getMsg(), null );
        }
        merchantByLogin.setPassword( "******" );

        String token = MerchantJwtUtil.createJWT(6000000, merchantByLogin);

        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("token",token);
        objectMap.put("merchant",merchantByLogin);
        return Result.success(objectMap);
    }
}
