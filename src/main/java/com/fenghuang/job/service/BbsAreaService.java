package com.fenghuang.job.service;

import com.fenghuang.job.entity.BbsArea;
import com.fenghuang.job.request.ReqBbsArea;
import com.fenghuang.job.view.BbsAreaView;
import com.fenghuang.job.view.BbsAreaView2;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/30 14:46
 * @Email: 15290810931@163.com
 */
public interface BbsAreaService {
    /**
     * 根据条件查询地址相关信息
     * @param reqBbsArea
     * @return
     */
    List<BbsAreaView> findBbsArea(ReqBbsArea reqBbsArea);

    /**
     * 根据父级节点查询子节点相关信息:只查询省级直辖市参数传：0
     * @param pid
     * @return
     */
    List<BbsAreaView2> findBbsAreaByPid(Integer pid);
}
