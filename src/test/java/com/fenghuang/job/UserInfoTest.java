package com.fenghuang.job;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.GenderEnum;
import com.fenghuang.job.request.ReqLoginUserInfo;
import com.fenghuang.job.request.ReqUserInfo;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.utils.JwtUtil;
import com.fenghuang.job.view.UserInfoManagerView;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luoxian
 * @Date: 2020/6/8 10:05
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class UserInfoTest extends FindJobApplicationTests {

    public static final String messageId = "102";
    public static final String signId = "103";

    @Autowired
    private UserInfoService userInfoService;

   /* @Test
    public void ordinaryRegisterTest(){
        ReqUserInfo reqUserInfo = new ReqUserInfo();
        reqUserInfo.setUserName("张洁");
        reqUserInfo.setUserNickname("小胖子凹凸曼");
        reqUserInfo.setUserHead("www.baidu.com");
        reqUserInfo.setIdCard("411421199308236039");
        reqUserInfo.setPassword("577521");
        reqUserInfo.setNewPassword("577521");
        reqUserInfo.setWechat("zhangjie521");
        reqUserInfo.setQq("zhangjie521");
        reqUserInfo.setEmail("zhangjie521@163.com");
        reqUserInfo.setGender(GenderEnum.WOMAN.getCode());
        reqUserInfo.setMobile("1820000000");
        reqUserInfo.setProvinceId(1);
        reqUserInfo.setCityId(2);
        reqUserInfo.setCountyAreaId(3);
        reqUserInfo.setAddress("江苏省盐城市");
        Result result = userInfoService.insertUser(reqUserInfo);
        log.info("普通注册的结果：{}",JSON.toJSONString(result));
    }

    @Test
    public void messageRegisterTest(){
        Result result = userInfoService.messageRegister(messageId, signId, "17621007255", "127.0.0.1");
        log.info("短信注册返回信息：{}",JSON.toJSONString(result));
    }

    @Test
    public void ordinaryLoginTest(){
        ReqLoginUserInfo reqLoginUserInfo = new ReqLoginUserInfo();
        reqLoginUserInfo.setLoginUser("411421199308236039");
        reqLoginUserInfo.setPassword("577521");
        Result result = userInfoService.ordinaryLogin(reqLoginUserInfo);
        log.info("普通登录的结果：{}",JSON.toJSONString(result));
    }

    @Test
    public void messageLoginTest(){
        Result result = userInfoService.loginByMessage(messageId, signId, "17621007255", "127.0.0.1");
        log.info("短信登录发送验证码：{}",JSON.toJSONString(result));
    }

    @Test
    public void parseToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLlvKDmtIEiLCJtb2JpbGUiOiIxODIwMDAwMDAwIiwidXNlck5pY2tuYW1lIjoi5bCP6IOW5a2Q5Ye55Ye45pu8IiwidXNlck5hbWUiOiLlvKDmtIEiLCJleHAiOjE1OTE2MDEwNTEsInVzZXJJZCI6MywiaWF0IjoxNTkxNTk1MDUxLCJqdGkiOiI4M2I3NzZiZi0yZWQ5LTQ2OWEtYWVmMS04YzY0ZjgwMzEwZWQifQ.rdMGyTTlFsf6rh7ma6KAaT356rdV3IHnpGYAhsq-1QA";
        Claims claims = JwtUtil.parseJWT(token);
        Map<String ,String> userMap = new HashMap<>();
        userMap.put("userId",claims.get("userId").toString());
        userMap.put("userName",claims.get("userName").toString());
        log.info("claims:{}",JSON.toJSONString(userMap));
    }

    @Test
    public void userInfoManagerTest() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLlvKDmtIEiLCJtb2JpbGUiOiIxODIwMDAwMDAwIiwidXNlck5pY2tuYW1lIjoi5bCP6IOW5a2Q5Ye55Ye45pu8IiwidXNlck5hbWUiOiLlvKDmtIEiLCJleHAiOjE1OTE2MDEwNTEsInVzZXJJZCI6MywiaWF0IjoxNTkxNTk1MDUxLCJqdGkiOiI4M2I3NzZiZi0yZWQ5LTQ2OWEtYWVmMS04YzY0ZjgwMzEwZWQifQ.rdMGyTTlFsf6rh7ma6KAaT356rdV3IHnpGYAhsq-1QA";
        UserInfoManagerView userInfoManager = userInfoService.findMoWaByToken(token);
        log.info("根据登录token获取登录用户的昵称，头像，钱包余额，收藏数，浏览数，我的兼职等信息:{}",
                JSON.toJSONString(userInfoManager));

    }

    @Test
    public void findUserByIdTest() {
        Object data = userInfoService.findUserById(1).getData();
        log.info("根据用户ID查询的数据：{}", JSON.toJSONString(data));
    }*/


}
