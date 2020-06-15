package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqBbsArea;
import com.fenghuang.job.view.BbsAreaSearchView;
import com.fenghuang.job.view.BbsAreaView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/30 14:46
 * @Email: 15290810931@163.com
 */
@Mapper
public interface BbsAreaService {
    /**
     * 根据area_id or title or pid 查询地址相关信息
     * @param reqBbsArea
     * @return
     */
    List<BbsAreaView> findBbsArea(ReqBbsArea reqBbsArea);

    /**
     * 初始化地理位置信息：递归方法
     * @return
     */
    List<BbsAreaSearchView> findBbsAreaList();

    /**
     * 由于数据太多：采用这个
     * @param upid
     * @return
     */
    Result findBbsAreaByUPid(Integer upid);
}
