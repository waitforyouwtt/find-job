package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.Banner;
import com.fenghuang.job.request.ReqBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> findBanner(ReqBanner reqBanner);

    //添加活动前查询是否存在相同活动的轮播图
    Banner findBannerByActivityId(@Param("activityId") Integer activityId);
}