package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqCollectionRecordInfo;
import com.fenghuang.job.request.ReqCollectionRecordInfoQuery;
import com.fenghuang.job.request.ReqCollectionRecordInfoState;
import com.fenghuang.job.view.CollectionRecordInfoView;
import com.fenghuang.job.view.ProjectInfoView;
import com.github.pagehelper.PageInfo;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 15:58
 * @Email: 15290810931@163.com
 */
public interface CollectionRecordInfoService {

    /**
     * 用户新增收藏记录
     * @param recordInfo
     * @return
     */
    Result insertCollectionRecordInfo(ReqCollectionRecordInfo recordInfo);

    /**
     * 用户变更收藏记录状态
     * @param recordInfoState
     * @return
     */
    Result updateCollectionRecordInfoState(ReqCollectionRecordInfoState recordInfoState);

    /**
     *根据条件查询收藏记录且分页
     * @param recordInfoQuery
     * @return
     */
    PageInfo<CollectionRecordInfoView> findCollectionRecordInfoPage(ReqCollectionRecordInfoQuery recordInfoQuery);

    /**
     *根据项目id查询收藏记录详情
     * @param projectId
     * @return
     */
    ProjectInfoView findCollectionRecordInfoDetails(Integer projectId);
}
