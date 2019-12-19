package com.fenghuang.job.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/19 13:54
 * @Email: 15290810931@163.com
 */
@Slf4j
public class SmsSenderUtil {

    @Autowired
    HttpClientUtil httpClientUtil;

    private static long getCurrentTime() {
        return System.currentTimeMillis() / 1000;
    }

    public static int getRandom() {
        return (new Random(SmsSenderUtil.getCurrentTime())).nextInt(900000) + 100000;
    }

    /**
     * 发送验证码
     * @param phoneNumber
     * @return
     */
    public String sendMsm(String phoneNumber, String signId, String templateId) {
        try {
            int random = getRandom();
            String result = httpClientUtil.sendSms(signId, templateId, phoneNumber, random + "");
            JSONObject jsonObject = JSON.parseObject(result);
            Integer code = jsonObject.getInteger("code");
            if (code.equals(200)) {
                return random + "";
            } else {
                log.info("发送短信失败，返回参数：{}", result);
            }
        } catch (Exception e) {
            // JSON 解析错误
            log.error("发送验证码失败", e);
        }
        throw new RuntimeException("短信发送失败");
    }
}
