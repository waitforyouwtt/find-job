package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.BrowseRecordInfo;

public interface BrowseRecordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrowseRecordInfo record);

    int insertSelective(BrowseRecordInfo record);

    BrowseRecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrowseRecordInfo record);

    int updateByPrimaryKey(BrowseRecordInfo record);
}