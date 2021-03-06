package com.fenghuang.job.controller.business;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.*;
import com.fenghuang.job.service.ProjectInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 12:09
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Api(value = "项目信息表相关接口",description = "项目信息表相关接口")
@RestController
public class ProjectInfoController {

    @Autowired
    ProjectInfoService projectService;

    @ApiOperation( value = "商家管理后台创建兼职项目")
    @PostMapping("/insertProject")
    public Result insertProject(@RequestBody ReqProjectInfo reqProject,@RequestHeader("token") String token){
        reqProject.setToken(token);
        return projectService.insertProject(reqProject);
    }

    @ApiOperation( value = "根据id更新项目相关字段")
    @PostMapping("/modifyProject")
    public Result modifyProject(@RequestBody ReqProjectInfo reqProject, @RequestHeader("token") String token) {
        reqProject.setToken(token);
        return projectService.modifyProject(reqProject);
    }

    @ApiOperation( value = "根据id更新项目状态")
    @PostMapping("/modifyProjectStatus")
    public Result modifyProjectStatus(@RequestBody ReqProjectStatus reqProjectStatus,@RequestHeader("token") String token){
        return Result.success( projectService.modifyProjectStatus(reqProjectStatus) );
    }

    @ApiOperation( value = "根据条件查询项目信息")
    @PostMapping("/findProject")
    public Result findProject(@RequestBody ReqProjectInfoQuery reqProjectInfoQuery){
      return Result.success(projectService.findProject(reqProjectInfoQuery));
    }

    @ApiOperation( value = "根据条件进行查询项目相关信息且分页")
    @PostMapping("/findProjectPage")
    public Result findProjectPage(@RequestBody ReqProjectInfoQuery2 reqProjectInfoQuery2){
        return Result.success(projectService.findProjectPage(reqProjectInfoQuery2));
    }

    @ApiOperation( value = "根据id查询项目信息详情")
    @PostMapping("/findProjectDetailsById")
    public Result findProjectDetailsById(@RequestBody ReqProjectInfoQuery queryParams,@RequestHeader("token") String token){
        queryParams.setToken(token);
        return projectService.findProjectDetailsById(queryParams);
    }

    @ApiOperation( value = "根据项目id查询项目已申请人数")
    @PostMapping("/findhadApplyNum")
    public Result findhadApplyNum(@RequestBody ReqProjectInfoQuery queryParams){
        return Result.success(projectService.findhadApplyNum(queryParams));
    }

    @ApiOperation( value = " 根据类型名称 | 项目标签 | 项目名字模糊匹配查询项目信息")
    @PostMapping("/findProjectByParams")
    public Result findProjectByParams(@RequestBody ReqProjectInfoQuery3 reqProjectInfoQuery){
        return Result.success(projectService.findProjectByParams(reqProjectInfoQuery));
    }

    @ApiOperation( value = "商家进入后台，查看待录用|已录用|已结算|已评价|已取消 兼职列表")
    @PostMapping("/partTimeJobList")
    public Result partTimeJobList(@RequestBody(required = false) ReqProjectInfoQuery4 reqProjectInfoQuery,@RequestHeader("token") String token){
        reqProjectInfoQuery.setToken(token);
        return Result.success(projectService.partTimeJobList(reqProjectInfoQuery));
    }

}
