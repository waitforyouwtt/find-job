package com.fenghuang.job.controller.business;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.service.IndustryTypeInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/21 21:17
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class IndustryTypeInfoController {

    @Autowired
    IndustryTypeInfoService industryTypeInfoService;

    @PostMapping("/findIndustryTypeInfoByPid")
    @ApiOperation(value = "根据父级id查询行业名称")
    public Result findIndustryTypeInfoByPid(@RequestParam(value = "pid",required = false) Integer pid){
       return industryTypeInfoService.findIndustryTypeInfoByPid(pid);
    }
}
