package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.Activity;
import com.fenghuang.job.request.ReqActivity;
import com.fenghuang.job.request.ReqActivityQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    Activity queryActivity(ReqActivityQuery reqActivityQuery);

    Activity queryActivityByTitle(@Param("title") String title);

    List<Activity> findActivityPage(ReqActivityQuery reqActivityQuery);
}