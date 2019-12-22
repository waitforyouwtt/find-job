package com.fenghuang.job.controller;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqProject;
import com.fenghuang.job.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 12:09
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Api(value = "项目信息表相关接口",description = "项目信息表相关接口")
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @ApiOperation( value = "创建项目")
    @PostMapping("/insertProject")
    public Result insertProject(ReqProject reqProject){
        return Result.success(projectService.insertProject(reqProject));
    }

    @ApiOperation( value = "根据id更新项目相关字段")
    @PostMapping("/modifyProject")
    public Result modifyProject(ReqProject reqProject){
      return Result.success(projectService.modifyProject(reqProject));
    }

    @ApiOperation( value = "根据id更新项目状态")
    @PostMapping("/modifyProjectStatus")
    public Result modifyProjectStatus(ReqProject reqProject){
        return Result.success( projectService.modifyProjectStatus(reqProject) );
    }

    @ApiOperation( value = "根据条件查询项目信息")
    @PostMapping("/findProject")
    public Result findProject(ReqProject reqProject){
      return Result.success(projectService.findProject(reqProject));
    }

    @ApiOperation( value = "根据条件进行查询项目相关信息且分页")
    @PostMapping("/findProjectPage")
    public Result findProjectPage(ReqProject reqProject){
        return Result.success(projectService.findProjectPage(reqProject));
    }
}
