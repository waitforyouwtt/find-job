package com.fenghuang.job.controller;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.utils.UUID;
import com.fenghuang.job.weixinpay.MyWXConfig;
import com.github.wxpay.sdk.WXPay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/2 11:13
 * @Email: 15290810931@163.com
 */
@Api(value = "wechatPay 支付相关接口",description = "wechatPay 支付相关接口")
@Slf4j
@RestController
public class WeiXinPayController {

    @ApiOperation(value = "返回微信支付二维码")
    @PostMapping("/payCodeUrl")
    public Result WXPayOrder(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                             @RequestHeader("token") @ApiParam(value = "权限校验") String token,
                             @RequestParam("orderID") @ApiParam(value = "订单ID") String orderID,
                             HttpServletRequest request) throws Exception {

        MyWXConfig config = new MyWXConfig();
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "i");
        String out_trade_no = String.valueOf(UUID.next());
        System.out.println("out_trade_no"+out_trade_no);
        data.put("out_trade_no", out_trade_no);//商户订单号
        data.put("total_fee", "1");
        data.put("spbill_create_ip", request.getRemoteAddr());
        data.put("notify_url", "http://www.baidu.com");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            log.info("微信支付返回支付二维码：{}",resp);
            return Result.success(resp.get("code_url"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error();
    }

    /**
     * 订单查询
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "微信订单查询")
    @PostMapping("/trackOrder")
    @ResponseBody
    public Result trackOrder(@RequestParam("out_trade_no") String out_trade_no)
            throws Exception {
        MyWXConfig config = new MyWXConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", out_trade_no);
        try {
            Map<String, String> resp = wxpay.orderQuery(data);
            log.info("微信支付订单查询返回结果：{}", JSON.toJSONString(resp));
            return Result.success(resp.get("code_url"));
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }


}
