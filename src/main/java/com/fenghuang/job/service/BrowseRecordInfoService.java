package com.fenghuang.job.service;

import com.fenghuang.job.entity.BrowseRecordInfo;
import com.fenghuang.job.request.ReqBrowseRecordInfoQuery;
import com.fenghuang.job.view.BrowseRecordInfoView;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/10 18:48
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface BrowseRecordInfoService {

    /**
     * 添加用户浏览记录信息
     * @param userId
     * @param projectId
     */
    void insertBrowseRecordInfo( Integer userId,String userName,Integer projectId);

    /**
     *根据条件查询浏览记录相关信息且分页
     * @param recordInfoQuery
     * @return
     */
    PageInfo<BrowseRecordInfoView> findBrowseRecordInfoPage(ReqBrowseRecordInfoQuery recordInfoQuery);

    /**
     * 根据用户id 查询浏览记录
     * @param userId
     * @return
     */
    List<BrowseRecordInfo> findByUserId(Integer userId);
}
