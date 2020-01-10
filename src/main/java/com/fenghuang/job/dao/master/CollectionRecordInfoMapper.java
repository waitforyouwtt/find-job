package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.CollectionRecordInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqCollectionRecordInfoQuery;
import com.fenghuang.job.request.ReqCollectionRecordInfoState;

import java.util.List;

public interface CollectionRecordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectionRecordInfo record);

    int insertSelective(CollectionRecordInfo record);

    CollectionRecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectionRecordInfo record);

    int updateByPrimaryKey(CollectionRecordInfo record);

    //根据项目id,用户id修改状态
    int updateCollectionRecordInfoState(ReqCollectionRecordInfoState recordInfoState);

    List<CollectionRecordInfo> findCollectionRecordInfo(ReqCollectionRecordInfoQuery recordInfoQuery);
}