package com.fenghuang.job.service;

import com.fenghuang.job.request.ReqMessageRecordQuery;
import com.fenghuang.job.request.ReqMessageRecordQuery2;
import com.fenghuang.job.view.MessageRecordView;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 17:49
 * @Email: 15290810931@163.com
 */
public interface MessageRecordService {

    /**
     * 插入短信统计表
     * @param ip
     * @param mobile
     * @param messageType
     */
    void insertMessageRecordByType(String ip, String mobile, Integer messageType);

    /**
     * 根据条件进行查询短信统计且分页
     * @param messageRecordQuery
     * @return
     */
    PageInfo<MessageRecordView> findMessageRecordPage(ReqMessageRecordQuery messageRecordQuery);
    /**
     * 根据条件统计一个人30分钟发送短信的条数
     */
    List<MessageRecordView> countMessageRecordSize(ReqMessageRecordQuery2 reqMessageRecordQuery2);
}
