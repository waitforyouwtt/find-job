package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqEvaluateInfo;
import com.fenghuang.job.request.ReqEvaluateInfoQuery;
import com.fenghuang.job.service.EvaluateInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 11:15
 * @Email: 15290810931@163.com
 */
@RestController
@Api(value = "评价信息表相关接口",description = "评价信息表相关接口")
public class EvaluateInfoController {

    @Autowired
    EvaluateInfoService evaluateInfoService;

    @ApiOperation(value = "新增评价记录")
    @PostMapping("/insertEvaluateInfo")
    public Result insertEvaluateInfo(@RequestBody ReqEvaluateInfo reqEvaluateInfo,@RequestHeader("token") String token){
        reqEvaluateInfo.setToken(token);
        return evaluateInfoService.insertEvaluateInfo(reqEvaluateInfo);
    }

    @ApiOperation("根据id查看评价详情")
    @PostMapping("/findEvaluateInfoById")
    public Result findEvaluateInfoById(@RequestParam("id") Integer id){
        return Result.success(evaluateInfoService.findEvaluateInfoById(id));
    }

    @ApiOperation("根据条件查看评价且分页")
    @PostMapping("/findEvaluateInfoPage")
    public Result findEvaluateInfoPage(@RequestBody ReqEvaluateInfoQuery reqEvaluateInfoQuery){
       return Result.success(evaluateInfoService.findEvaluateInfoPage(reqEvaluateInfoQuery));
    }

}
