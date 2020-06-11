package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.BrowseRecordInfo;
import com.fenghuang.job.request.ReqBrowseRecordInfoFrontQuery;
import com.fenghuang.job.request.ReqBrowseRecordInfoQuery;
import com.fenghuang.job.view.BrowseRecordInfoView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrowseRecordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrowseRecordInfo record);

    int insertSelective(BrowseRecordInfo record);

    BrowseRecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrowseRecordInfo record);

    int updateByPrimaryKey(BrowseRecordInfo record);

    List<BrowseRecordInfo> findBrowseRecordInfo(ReqBrowseRecordInfoFrontQuery recordInfoQuery);

    List <BrowseRecordInfo> findByUserId(@Param("userId") Integer userId);

    BrowseRecordInfo findBrowseRecordInfoByUserIdAndProjectId(@Param("userId") Integer userId,@Param("projectId") Integer projectId);
}