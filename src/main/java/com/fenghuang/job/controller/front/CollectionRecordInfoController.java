package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqCollectionRecordInfo;
import com.fenghuang.job.request.ReqCollectionRecordInfoQuery;
import com.fenghuang.job.request.ReqCollectionRecordInfoState;
import com.fenghuang.job.service.CollectionRecordInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 15:57
 * @Email: 15290810931@163.com
 */
@RestController
@Api(value = "收藏记录信息表相关接口",description = "收藏记录信息表相关接口")
public class CollectionRecordInfoController {

    @Autowired
    CollectionRecordInfoService collectionRecordInfoService;

    @ApiOperation(value = "用户新增收藏记录")
    @PostMapping("/insertCollectionRecordInfo")
    public Result insertCollectionRecordInfo(@RequestBody ReqCollectionRecordInfo recordInfo,@RequestHeader("token") String token){
        recordInfo.setToken(token);
       return collectionRecordInfoService.insertCollectionRecordInfo(recordInfo);
    }

    @ApiOperation(value = "用户变更收藏记录状态")
    @PostMapping("/updateCollectionRecordInfoState")
    public Result updateCollectionRecordInfoState(@RequestBody ReqCollectionRecordInfoState recordInfoState){
        return collectionRecordInfoService.updateCollectionRecordInfoState(recordInfoState);
    }

    @ApiOperation(value = "用户取消收藏")
    @PostMapping("/cancelCollectionRecordInfo")
    public Result cancelCollectionRecordInfo(@RequestBody ReqCollectionRecordInfoState recordInfoState,@RequestHeader("token") String token){
        recordInfoState.setToken(token);
        return collectionRecordInfoService.cancelCollectionRecordInfo(recordInfoState);
    }

    @ApiOperation(value = "根据条件查询收藏记录且分页")
    @PostMapping("/findCollectionRecordInfoPage")
    public Result findCollectionRecordInfoPage(@RequestBody ReqCollectionRecordInfoQuery recordInfoQuery,@RequestHeader("token") String token){
        recordInfoQuery.setToken( token );
        return Result.success(collectionRecordInfoService.findCollectionRecordInfoPage(recordInfoQuery));
    }

    @ApiOperation(value = "根据项目id查询收藏记录详情")
    @GetMapping("/findCollectionRecordInfoDetails")
    public Result findCollectionRecordInfoDetails(@RequestParam("projectId") Integer projectId){
        return Result.success(collectionRecordInfoService.findCollectionRecordInfoDetails(projectId));
    }


}
