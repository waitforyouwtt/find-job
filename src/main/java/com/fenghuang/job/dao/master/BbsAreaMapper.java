package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.BbsArea;
import com.fenghuang.job.request.ReqBbsArea;
import com.fenghuang.job.view.BbsAreaView;
import com.fenghuang.job.view.BbsAreaView3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BbsAreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(BbsArea record);

    int insertSelective(BbsArea record);

    BbsArea selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(BbsArea record);

    int updateByPrimaryKey(BbsArea record);

    List<BbsArea> findBbsArea(ReqBbsArea reqBbsArea);

    BbsAreaView3 findBbsAreaByParams(@Param( "provinceId" )Integer provinceId,
                                     @Param( "cityId" )Integer cityId,@Param( "areaId" )Integer areaId);

    //根据父级节点查询子节点相关信息:只查询省级直辖市参数传：0
    List<BbsAreaView> findBbsAreaByUPid(@Param("pid") Integer pid);

    //根据父级节点查询子节点相关信息:只查询省级直辖市参数传：0
    List<BbsAreaView> findBbsAreaByUPid2();
}