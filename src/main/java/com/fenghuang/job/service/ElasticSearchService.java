package com.fenghuang.job.service;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.view.ProjectESByParamsView;

import java.text.ParseException;

/**
 * @Author: luoxian
 * @Date: 2020/6/16 17:10
 * @Email: 15290810931@163.com
 */
public interface ElasticSearchService {

    /**
     * 创建商品es索引库
     * @return
     */
    Result createIndex();

    /**
     * 通过es 自动生成的Id查询projectInfoES索引库
     * @param id
     * @return
     */
    Result queryProjectESByAutoId(String id) throws ParseException;

    /**
     * 通过database Id查询projectInfoES索引库
     * @param id
     * @return
     */
    Result queryProjectESById(String id);

    /**
     * 通过条件查询projectInfoES索引库
     * @param view
     * @return
     */
    Result queryProjectESByParams(ProjectESByParamsView view);
}
