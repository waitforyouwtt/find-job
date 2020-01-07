package com.fenghuang.job.service;

import com.fenghuang.job.request.ReqProjectWorkTimeInfo;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/7 11:09
 * @Email: 15290810931@163.com
 */
public interface ProjectWorkTimeInfoService {

    /**
     * 添加上班时段
     */
    int insertProjectWorkTimeInfo(ReqProjectWorkTimeInfo reqProjectWorkTimeInfo);
}
