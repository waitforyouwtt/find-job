package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.BrowseRecordInfo;
import com.fenghuang.job.request.ReqBrowseRecordInfoFrontQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
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

    int deleteByUserId(@Param("userId") Integer userId);

    int deleteByUserIdAndIdList(@Param("userId") Integer userId,@Param("ids") List<String> ids);
}