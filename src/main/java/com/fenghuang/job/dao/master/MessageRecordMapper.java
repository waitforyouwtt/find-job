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

    List<MessageRecord> findMessageCountPage(ReqMessageRecordQuery messageCountQuery);

    List<MessageRecord> findMessageCount(ReqMessageRecordQuery2 reqMessageCountQuery2);

}