package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.request.ReqProjectInfoQuery;
import com.fenghuang.job.request.ReqProjectInfoQuery2;
import com.fenghuang.job.request.ReqProjectInfoQuery3;
import com.fenghuang.job.request.ReqProjectInfoQuery4;
import com.fenghuang.job.view.PartTimeJobListView;
import com.fenghuang.job.view.ProjectInfoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ProjectInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInfo record);

    int insertSelective(ProjectInfo record);

    ProjectInfo selectByPrimaryKey(Integer id);

    List<ProjectInfo> findAll();

    int updateByPrimaryKeySelective(ProjectInfo record);

    int updateByPrimaryKey(ProjectInfo record);

    //同一用户 & 同一类型 & 相同标题 状态为未删除的项目不允许重复
    ProjectInfo findProjectParams(ReqProjectInfoQuery reqProjectInfoQuery);

    //根据条件查询项目信息
    List<ProjectInfoView> findProject(ReqProjectInfoQuery reqProjectInfoQuery);

    //根据条件查询项目limit 20条
    List<ProjectInfoView> findProjectByParams(ReqProjectInfoQuery3 reqProjectInfoQuery);

    //根据条件查询项目信息带分页
    List<ProjectInfoView> findProjectPage(ReqProjectInfoQuery2 reqProjectInfoQuery2);

    //根据id查询项目信息
    ProjectInfo findProjectInfoById(@Param("id") Integer id);

    //商家进入后台，查看待录用|已录用|已结算|已评价|已取消 兼职列表
    List<PartTimeJobListView> partTimeJobList(ReqProjectInfoQuery4 reqProjectInfoQuery);
}