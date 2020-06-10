package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqBrowseRecordInfoQuery;
import com.fenghuang.job.service.BrowseRecordInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
    public Result findBrowseRecordInfoPage(ReqBrowseRecordInfoQuery recordInfoQuery,@RequestHeader("token") String token){
        recordInfoQuery.setToken(token);
        return Result.success(  browseRecordInfoService.findBrowseRecordInfoPage(recordInfoQuery));
    }
}
