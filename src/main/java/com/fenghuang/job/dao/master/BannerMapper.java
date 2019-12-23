package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.Banner;
import com.fenghuang.job.request.ReqBanner;

import java.util.List;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> findBanner(ReqBanner reqBanner);
}