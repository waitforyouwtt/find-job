package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.FeedbackInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedbackInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(FeedbackInfo record);

    int insertSelective(FeedbackInfo record);

    FeedbackInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FeedbackInfo record);

    int updateByPrimaryKey(FeedbackInfo record);
}