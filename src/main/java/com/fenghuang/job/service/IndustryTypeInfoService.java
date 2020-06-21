package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/21 21:20
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface IndustryTypeInfoService {

    /**
     *根据父级id查询行业名称
     * @param pid
     * @return
     */
    Result findIndustryTypeInfoByPid(Integer pid);
}
