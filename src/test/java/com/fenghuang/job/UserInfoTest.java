package com.fenghuang.job;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: luoxian
 * @Date: 2020/6/8 10:05
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class UserInfoTest extends FindJobApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void contextLoads() {
        Object data = userInfoService.findUserById(1).getData();
        log.info("得到的数据：{}", JSON.toJSONString(data));
    }
}
