package com.fenghuang.job.controller;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqOrderInfo;
import com.fenghuang.job.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 21:19
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Api(value = "订单信息表相关接口",description = "订单信息表相关接口")
@RestController
public class OrderInfoController {

    @Autowired
    OrderInfoService orderInfoService;

    @ApiOperation( value = "生成订单且返回订单号")
    @PostMapping("/createOrder")
    public Result createOrder(ReqOrderInfo reqOrderInfo){
     return Result.success(orderInfoService.createOrder(reqOrderInfo));
    }

    @ApiOperation( value = "根据条件进行查询订单信息表且分页")
    @PostMapping("/findOrderInfoPage")
    public Result findOrderInfoPage(ReqOrderInfo reqOrderInfo){
        return Result.success( orderInfoService.findOrderInfoPage(reqOrderInfo) );
    }

    @ApiOperation( value = "根据订单id 获取订单详情")
    @GetMapping("/queryOrderDetailsById")
    public Result queryOrderDetailsById(@RequestParam("id") Integer id){
        return Result.success( orderInfoService.queryOrderDetailsById(id) );
    }

    @ApiOperation( value = "更新订单状态")
    @PostMapping("/modifyOrderStatus")
    public Result modifyOrderStatus(ReqOrderInfo reqOrderInfo){
        return Result.success( orderInfoService.modifyOrderStatus(reqOrderInfo) );
    }




}
