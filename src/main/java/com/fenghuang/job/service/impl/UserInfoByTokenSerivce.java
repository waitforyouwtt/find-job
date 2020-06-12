package com.fenghuang.job.service.impl;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luoxian
 * @Date: 2020/6/12 14:38
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class UserInfoByTokenSerivce {

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
}
