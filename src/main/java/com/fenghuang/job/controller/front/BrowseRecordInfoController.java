package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqBrowseRecordInfoFrontQuery;
import com.fenghuang.job.service.BrowseRecordInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/10 18:44
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
@Api(value = "用户浏览记录信息相关接口",description = "用户浏览记录信息相关接口")
public class BrowseRecordInfoController {

    @Autowired
    BrowseRecordInfoService browseRecordInfoService;

    @ApiOperation( "根据条件查询浏览记录相关信息且分页" )
    @PostMapping("/findBrowseRecordInfoPage")
    public Result findBrowseRecordInfoPage(@RequestBody ReqBrowseRecordInfoFrontQuery recordInfoQuery, @RequestHeader("token") String token){
        recordInfoQuery.setToken(token);
        return Result.success(  browseRecordInfoService.findBrowseRecordInfoPage(recordInfoQuery));
    }

    @ApiOperation( "用户删除浏览记录" )
    @PostMapping("/batchDelete")
    public Result batchDeleteBrowseRecordInfo(@RequestParam(value = "ids",required = false) String ids, @RequestHeader("token") String token){
      return  browseRecordInfoService.batchDeleteBrowseRecordInfo(ids,token);
    }



}
