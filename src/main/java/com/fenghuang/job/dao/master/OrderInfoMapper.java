package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.OrderInfo;
import com.fenghuang.job.request.ReqOrderInfo;

import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> findOrderInfoPage(ReqOrderInfo reqOrderInfo);
}