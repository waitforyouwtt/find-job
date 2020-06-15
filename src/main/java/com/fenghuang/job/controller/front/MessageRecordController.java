package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqMessageRecordQuery;
import com.fenghuang.job.request.ReqMessageRecordQuery2;
import com.fenghuang.job.service.MessageRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 17:49
 * @Email: 15290810931@163.com
 */
@Api(value = "短信发送记录统计相关接口",description = "短信发送记录统计相关接口")
@RestController
public class MessageRecordController {

    @Autowired
    MessageRecordService messageRecordService;

    @ApiOperation(value = "根据条件进行查询短信统计且分页")
    @PostMapping("/findMessageCountPage")
    public Result findMessageCountPage(@RequestBody ReqMessageRecordQuery messageCountQuery){
        return Result.success(messageRecordService.findMessageCountPage(messageCountQuery));
    }

    @ApiOperation(value = "根据条件统计一个人一小时发送短信的条数")
    @PostMapping("/findMessageCount")
    public Result findMessageCount (@RequestBody ReqMessageRecordQuery2 messageCountQuery2){
        return Result.success(messageRecordService.findMessageRecordSize(messageCountQuery2));
    }

}
