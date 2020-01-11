package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.BrowseRecordInfo;
import com.fenghuang.job.request.ReqBrowseRecordInfoQuery;

import java.util.List;

public interface BrowseRecordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrowseRecordInfo record);

    int insertSelective(BrowseRecordInfo record);

    BrowseRecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrowseRecordInfo record);

    int updateByPrimaryKey(BrowseRecordInfo record);

    List<BrowseRecordInfo> findBrowseRecordInfo(ReqBrowseRecordInfoQuery recordInfoQuery);
}