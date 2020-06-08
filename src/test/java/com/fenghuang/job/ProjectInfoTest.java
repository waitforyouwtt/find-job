package com.fenghuang.job;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.ProjectInfoMapper;
import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.request.ReqProjectInfoQuery3;
import com.fenghuang.job.service.ProjectInfoService;
import com.fenghuang.job.view.ProjectInfoView;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: luoxian
 * @Date: 2020/6/8 10:07
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class ProjectInfoTest extends FindJobApplicationTests {

    @Autowired
    private ProjectInfoService projectInfoService;

    @Resource
    ProjectInfoMapper projectInfoMapper;


    @Test
    public void queryKeyTest() {
        ReqProjectInfoQuery3 query = new ReqProjectInfoQuery3();
        query.setQueryKey( "厨师" );
        List<ProjectInfoView> projectByParams = projectInfoService.findProjectByParams( query );
        log.info( "获取的数据：{}", JSON.toJSONString( projectByParams ) );
    }

    @Test
    public void filterTest() {
        List<ProjectInfo> projectInfo = projectInfoMapper.findAll( );
        List<ProjectInfo> chose = projectInfo.stream().filter( p -> ! p.getWorkWelfaresId().contains( "2" ) ).collect( Collectors.toList());
        List<Integer> ids = chose.stream().map( c -> c.getId() ).collect( Collectors.toList());
        log.info( "得到的结果：{}", JSON.toJSONString(ids) );
    }
}
