package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.SignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoQuery;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SignUpInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SignUpInfo record);

    int insertSelective(SignUpInfo record);

    SignUpInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SignUpInfo record);

    int updateByPrimaryKey(SignUpInfo record);

    //同一兼职项目不可以再次报名
    List<SignUpInfo> findSignUpInfo(ReqSignUpInfoQuery reqSignUpInfoQuery);
}