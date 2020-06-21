package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqLoginUserInfo;
import com.fenghuang.job.request.ReqMerchant;
import com.fenghuang.job.request.ReqMerchantLogin;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/20 11:11
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface MerchantService {

    /**
     * 商家使用短信注册，发送验证码
     * @param messageId
     * @param signId
     * @param mobile
     * @param ip
     * @return
     */
    Result registerMerchantSendMessage(String messageId, String signId, String mobile, String ip);

    /**
     * 商家短信注册，输入验证码，验证通过则登录成功，验证失败则登录失败
     * @param reqLoginUserInfo
     * @return
     */
    Result merchantValidateRegisterCode(ReqLoginUserInfo reqLoginUserInfo);

    /**
     * 商家普通方式注册
     * @return
     */
    Result merchantOrdinaryRegister(ReqMerchant reqMerchant);

    /**
     * 商家登录
     * @param reqMerchant
     * @return
     */
    Result merchantLogin(ReqMerchantLogin reqMerchant);
}
