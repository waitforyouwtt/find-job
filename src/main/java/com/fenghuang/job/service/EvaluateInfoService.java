package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqEvaluateInfo;
import com.fenghuang.job.request.ReqEvaluateInfoQuery;
import com.fenghuang.job.view.EvaluateInfoView;
import com.github.pagehelper.PageInfo;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 11:23
 * @Email: 15290810931@163.com
 */
public interface EvaluateInfoService {
    
    /**
     * 新增评价记录
     * @param reqEvaluateInfo
     * @return
     */
    Result insertEvaluateInfo(ReqEvaluateInfo reqEvaluateInfo);

    /**
     * 根据id查看评价详情
     * @param id
     * @return
     */
    EvaluateInfoView findEvaluateInfoById(Integer id);

    /**
     * 根据条件查看评价且分页
     * @param reqEvaluateInfoQuery
     * @return
     */
    PageInfo<EvaluateInfoView> findEvaluateInfoPage(ReqEvaluateInfoQuery reqEvaluateInfoQuery);
}
