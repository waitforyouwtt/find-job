package com.fenghuang.job.service;

import com.fenghuang.job.entity.CollectionRecordInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqCollectionRecordInfo;
import com.fenghuang.job.request.ReqCollectionRecordInfoQuery;
import com.fenghuang.job.request.ReqCollectionRecordInfoState;

import java.util.List;

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
    Result findCollectionRecordInfoPage(ReqCollectionRecordInfoQuery recordInfoQuery);

    /**
     *根据项目id查询收藏记录详情
     * @param projectId
     * @return
     */
    Result findCollectionRecordInfoDetails(Integer projectId);

    /**
     * 根据用户id 查询收藏记录
     * @param userId
     * @return
     */
    List<CollectionRecordInfo> findByUserId(Integer userId);

    /**
     * 用户取消收藏
     * @param recordInfoState
     * @return
     */
    Result cancelCollectionRecordInfo(ReqCollectionRecordInfoState recordInfoState);
}
