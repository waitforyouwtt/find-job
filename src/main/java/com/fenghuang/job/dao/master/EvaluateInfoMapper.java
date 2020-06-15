package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.EvaluateInfo;
import com.fenghuang.job.request.ReqEvaluateInfoQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EvaluateInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EvaluateInfo record);

    int insertSelective(EvaluateInfo record);

    EvaluateInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EvaluateInfo record);

    int updateByPrimaryKey(EvaluateInfo record);

    //评价分页查询
    List<EvaluateInfo> findEvaluateInfo(ReqEvaluateInfoQuery reqEvaluateInfoQuery);
}