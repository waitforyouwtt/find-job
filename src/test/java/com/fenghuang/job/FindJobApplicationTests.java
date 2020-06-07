package com.fenghuang.job;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.ProjectInfoMapper;
import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.request.ReqProjectInfoQuery3;
import com.fenghuang.job.service.ProjectInfoService;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.view.ProjectInfoView;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class FindJobApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private ProjectInfoService projectInfoService;

	@Autowired
    ProjectInfoMapper mapper;

	@Test
	public void contextLoads() {
		Object data = userInfoService.findUserById(1).getData();
		log.info("得到的数据：{}", JSON.toJSONString(data));
	}

	@Test
	public void queryKeyTest() {
        ReqProjectInfoQuery3 query = new ReqProjectInfoQuery3();
        query.setQueryKey( "厨师" );
        List<ProjectInfoView> projectByParams = projectInfoService.findProjectByParams( query );
        log.info( "获取的数据：{}", JSON.toJSONString( projectByParams ) );
    }

    @Test
	public void filterTest() {
		List<ProjectInfo> projectInfo = mapper.findAll( );
		List<ProjectInfo> chose = projectInfo.stream().filter( p -> ! p.getWorkWelfaresId().contains( "2" ) ).collect( Collectors.toList());
		List<Integer> ids = chose.stream().map( c -> c.getId() ).collect( Collectors.toList());
		log.info( "得到的结果：{}", JSON.toJSONString(ids) );
	}

}
