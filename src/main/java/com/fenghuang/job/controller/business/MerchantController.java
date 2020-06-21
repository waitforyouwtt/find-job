package com.fenghuang.job.controller.business;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqLoginUserInfo;
import com.fenghuang.job.request.ReqMerchant;
import com.fenghuang.job.request.ReqMerchantLogin;
import com.fenghuang.job.request.ReqRegisterCode;
import com.fenghuang.job.service.MerchantService;
import com.fenghuang.job.utils.BusinessUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/20 11:10
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class MerchantController {

    @Value( "${message.messageId}" )
    private String messageId;

    @Value( "${message.signId}" )
    private String signId;

    @Autowired
    MerchantService merchantService;

    @ApiOperation(value = "商家使用短信注册，发送验证码")
    @PostMapping("/registerMerchantSendMessage")
    public Result registerMerchantSendMessage(@RequestBody ReqRegisterCode reqRegisterCode , HttpServletRequest request){
        return merchantService.registerMerchantSendMessage(messageId,signId,reqRegisterCode.getMobile(), BusinessUtils.getIp(request));
    }

    @PostMapping("/merchantValidateRegisterCode")
    @ApiOperation(value = "商家短信注册，输入验证码，验证通过则登录成功，验证失败则登录失败")
    public Result merchantValidateRegisterCode(@RequestBody ReqLoginUserInfo reqLoginUserInfo) {
        return merchantService.merchantValidateRegisterCode(reqLoginUserInfo);
    }

    @PostMapping("/merchantOrdinaryRegister")
    @ApiOperation(value = "商家普通方式注册")
    public Result merchantOrdinaryRegister(@RequestBody ReqMerchant reqMerchant) {
        return merchantService.merchantOrdinaryRegister(reqMerchant);
    }

    @PostMapping("/merchantLogin")
    @ApiOperation(value = "商家登录")
    public Result merchantLogin(@RequestBody ReqMerchantLogin reqMerchant) {
        return merchantService.merchantLogin(reqMerchant);
    }


}
