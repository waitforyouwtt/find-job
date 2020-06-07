package com.fenghuang.job;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.ProjectInfoMapper;
import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.service.ProjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class FindJobApplicationTests {

	@Autowired
	ProjectInfoMapper mapper;
	@Test
	void contextLoads() {
		List<ProjectInfo> projectInfo = mapper.findAll( );
		List<ProjectInfo> chose = projectInfo.stream().filter( p -> ! p.getWorkWelfaresId().contains( "2" ) ).collect( Collectors.toList());
		List<Integer> ids = chose.stream().map( c -> c.getId() ).collect( Collectors.toList());
		log.info( "得到的结果：{}", JSON.toJSONString(ids) );
	}

}
