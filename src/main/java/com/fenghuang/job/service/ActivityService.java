package com.fenghuang.job.service;

import com.fenghuang.job.request.ReqActivity;
import com.fenghuang.job.request.ReqActivityUpdate;
import com.fenghuang.job.view.ActivityView;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 14:16
 * @Email: 15290810931@163.com
 */
public interface ActivityService {
    /**
     * 新增活动
     * @param reqActivity
     * @return
     */
    int insertActivity(ReqActivity reqActivity);

    /**
     * 根据ID修改活动相关信息
     * @param reqActivityUpdate
     * @return
     */
    int modifyActivity(ReqActivityUpdate reqActivityUpdate);

    /**
     * 根据id 查询活动详情
     * @param id
     * @return
     */
    ActivityView findActivityById(Integer id);
}
