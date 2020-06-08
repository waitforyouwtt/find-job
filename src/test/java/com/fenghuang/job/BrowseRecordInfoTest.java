package com.fenghuang.job;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqProjectInfoQuery;
import com.fenghuang.job.service.ProjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: luoxian
 * @Date: 2020/6/8 15:48
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class BrowseRecordInfoTest extends FindJobApplicationTests {

    @Autowired
    ProjectInfoService projectInfoService;

    @Test
    public void insertBrowseRecordInfo(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLlvKDmtIEiLCJtb2JpbGUiOiIxODIwMDAwMDAwIiwidXNlck5pY2tuYW1lIjoi5bCP6IOW5a2Q5Ye55Ye45pu8IiwidXNlck5hbWUiOiLlvKDmtIEiLCJleHAiOjE1OTE2MDkxMDksInVzZXJJZCI6MywiaWF0IjoxNTkxNjAzMTA5LCJqdGkiOiI2ZTQ1NGU5OS03NmUzLTQ2NmYtOTM1Ni0wNTk2NTAyZTA3NWQifQ.hyXM7St9mzrt_NiGquJWGlXP0hHTTBzncQZJAYdxOPc";

        ReqProjectInfoQuery queryParams = new ReqProjectInfoQuery ();
        queryParams.setId(1);
        queryParams.setToken(token);
        Result projectDetailsById = projectInfoService.findProjectDetailsById(queryParams);
        log.info("通过aop切面添加用户浏览记录：{}", JSON.toJSONString(projectDetailsById));
    }
}
