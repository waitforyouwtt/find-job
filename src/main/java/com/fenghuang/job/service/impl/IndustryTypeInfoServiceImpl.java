package com.fenghuang.job.service.impl;

import com.fenghuang.job.dao.master.IndustryTypeInfoMapper;
import com.fenghuang.job.entity.IndustryTypeInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.service.IndustryTypeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/21 21:21
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class IndustryTypeInfoServiceImpl implements IndustryTypeInfoService {

    @Resource
    IndustryTypeInfoMapper industryTypeInfoMapper;
    /**
     * 根据父级id查询行业名称
     *
     * @param pid
     * @return
     */
    @Override
    public Result findIndustryTypeInfoByPid(Integer pid) {
        List<IndustryTypeInfo> industryTypeInfos = null;
        if(StringUtils.isEmpty( pid )){
            industryTypeInfos = industryTypeInfoMapper.findIndustryTypeInfoByPid( 0 );
        }else{
            industryTypeInfos = industryTypeInfoMapper.findIndustryTypeInfoByPid( pid );
        }
        return Result.success(industryTypeInfos);
    }
}
