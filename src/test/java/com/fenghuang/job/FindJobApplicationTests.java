package com.fenghuang.job;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.request.ReqProjectInfoQuery3;
import com.fenghuang.job.service.ProjectInfoService;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.view.ProjectInfoView;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class FindJobApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private ProjectInfoService projectInfoService;

	@Test
	public void contextLoads() {
		Object data = userInfoService.findUserById(1).getData();
		log.info("得到的数据：{}", JSON.toJSONString(data));
	}

	@Test
	public void queryKeyTest(){
		ReqProjectInfoQuery3 query = new ReqProjectInfoQuery3();
		query.setQueryKey("厨师");
		List<ProjectInfoView> projectByParams = projectInfoService.findProjectByParams(query);
		log.info("获取的数据：{}",JSON.toJSONString(projectByParams));
	}

}
