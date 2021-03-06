package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.SignUpInfo;
import com.fenghuang.job.request.ReqSignUpInfoByUserQuery;
import com.fenghuang.job.request.ReqSignUpInfoQuery;
import com.fenghuang.job.view.SignUpInfoUserIdView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    //根据id 查询兼职项目详情
    SignUpInfo findSignUpInfoById(@Param("id") Integer id);

    //根据项目id查询项目已申请人数
    Integer findhadApplyNum(@Param( "projectId" ) Integer projectId);

    List<SignUpInfoUserIdView> findUserInfoSignUpInfoPage(ReqSignUpInfoByUserQuery reqSignUpInfoQuery);

    //前端用户取消申请
    int cancelSignUpInfo(SignUpInfo signUpInfo);
}