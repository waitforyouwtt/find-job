package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.MessageRecord;
import com.fenghuang.job.request.ReqMessageRecordQuery;
import com.fenghuang.job.request.ReqMessageRecordQuery2;

import java.util.List;

public interface MessageRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageRecord record);

    int insertSelective(MessageRecord record);

    MessageRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageRecord record);

    int updateByPrimaryKey(MessageRecord record);

    //根据条件进行查询短信统计且分页
    List<MessageRecord> findMessageRecordPage(ReqMessageRecordQuery messageRecordQuery);

    //根据条件统计一个人30分钟之内发送短信的条数
    List<MessageRecord> findMessageRecordSize(ReqMessageRecordQuery2 reqMessageRecordQuery2);

}