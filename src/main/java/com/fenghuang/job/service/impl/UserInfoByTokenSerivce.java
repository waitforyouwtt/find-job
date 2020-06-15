package com.fenghuang.job.service.impl;

import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.request.ReqMessageRecordQuery2;
import com.fenghuang.job.service.MessageRecordService;
import com.fenghuang.job.utils.JwtUtil;
import com.fenghuang.job.view.MessageRecordView;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luoxian
 * @Date: 2020/6/12 14:38
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class UserInfoByTokenSerivce {

    @Autowired
    MessageRecordService messageRecordService;

    /**
     * 通过token 获取用户信息
     * @param token
     * @return
     */
    public Result getUserInfoByToken(String token){
        String userId;
        String  userName;
        String mobile;
        String gender;
        Map<String,String> map = new HashMap<>();
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.get("userId").toString() ;
            userName = claims.get("userName").toString();
            mobile = claims.get("mobile").toString();
            gender = claims.get("gender").toString();
            map.put("userId",userId);
            map.put("userName",userName);
            map.put("mobile",mobile);
            map.put("gender",gender);
            log.info("通过token 解析的用户id：{},用户名：{}",userId,userName);
        }catch (Exception e){
            return Result.error(BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        return Result.success(map);
    }

    /**
     *
     * 统计30分钟内操作短信的频率，判断是否恶意攻击
     * 0 正常操作，1 正在遭受攻击
     * @param mobile
     * @param ip
     * @param messageType
     * @return
     */
    public int maliciousAttack(String mobile,String ip,int messageType){
        log.info("统计30分钟内操作短信的频率，判断是否恶意攻击请求参数：{},{},{}",mobile,ip,messageType);
        ReqMessageRecordQuery2 messageRecordParams = new ReqMessageRecordQuery2();
        messageRecordParams.setMessageType(messageType);
        messageRecordParams.setSendIp(ip);
        messageRecordParams.setMobile(mobile);
        messageRecordParams.setCurrentSendDate(new Date());
        List<MessageRecordView> queryMessageRecordSize = messageRecordService.countMessageRecordSize(messageRecordParams);
        log.info("当前手机号 | ip 30分钟之内发送的短信条数为：{}",queryMessageRecordSize.size());
        if (queryMessageRecordSize.size() > Constants.MESSAGE_COUNT){
            return 1;
        }
        return 0;
    }
}
