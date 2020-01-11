package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqBrowseRecordInfoQuery;
import com.fenghuang.job.view.BrowseRecordInfoView;
import com.github.pagehelper.PageInfo;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/10 18:48
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface BrowseRecordInfoService {

    /**
     *根据条件查询浏览记录相关信息且分页
     * @param recordInfoQuery
     * @return
     */
    PageInfo<BrowseRecordInfoView> findBrowseRecordInfoPage(ReqBrowseRecordInfoQuery recordInfoQuery);
}
