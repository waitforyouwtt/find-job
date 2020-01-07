package com.fenghuang.job.service;

import com.fenghuang.job.request.ReqProjectWorkDateInfo;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/7 10:47
 * @Email: 15290810931@163.com
 */
public interface ProjectWorkDateInfoService {

    /**
     * 新增上班日期
     */
    int insertProjectWorkDateInfo(ReqProjectWorkDateInfo reqProjectWorkDateInfo);
}
