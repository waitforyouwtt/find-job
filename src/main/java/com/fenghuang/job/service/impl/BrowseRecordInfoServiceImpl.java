package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.BrowseRecordInfoMapper;
import com.fenghuang.job.dao.master.ProjectInfoMapper;
import com.fenghuang.job.entity.BrowseRecordInfo;
import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.request.ReqBrowseRecordInfoFrontQuery;
import com.fenghuang.job.request.ReqBrowseRecordInfoQuery;
import com.fenghuang.job.service.BrowseRecordInfoService;
import com.fenghuang.job.utils.JwtUtil;
import com.fenghuang.job.view.BrowseRecordInfoView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/10 18:54
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class BrowseRecordInfoServiceImpl implements BrowseRecordInfoService {

    @Resource
    BrowseRecordInfoMapper browseRecordInfoMapper;

    @Resource
    ProjectInfoMapper projectInfoMapper;

    /**
     * 添加用户浏览记录信息
     * @param userId
     * @param projectId
     */
    @Override
    public void insertBrowseRecordInfo(Integer userId,String userName,Integer projectId) {
        log.info("添加用户浏览记录信息请求参数：{},{}",userId,projectId);
        BrowseRecordInfo queryBrowseRecordInfo = browseRecordInfoMapper.findBrowseRecordInfoByUserIdAndProjectId(userId, projectId);
        if (queryBrowseRecordInfo != null){
            return;
        }
        ProjectInfo projectInfoById = projectInfoMapper.findProjectInfoById(projectId);
        if (projectInfoById == null){
            return;
        }
        BrowseRecordInfo record = new BrowseRecordInfo();
        record.setUserId(userId);
        record.setCompanyId(projectInfoById.getUserId());
        record.setCompanyName(projectInfoById.getProjectAscriptionCompany());
        record.setProjectId(projectId);
        record.setProjectTitle(projectInfoById.getProjectTitle());
        record.setSalary(projectInfoById.getSalary());
        record.setSalaryUnit(projectInfoById.getSalaryUnit());
        record.setProjectLabel(projectInfoById.getProjectLabel());
        record.setProvinceId(projectInfoById.getProvinceId());
        record.setCityId(projectInfoById.getCityId());
        record.setAreaId(projectInfoById.getAreaId());
        record.setWorkAddress(projectInfoById.getWorkAddress());
        record.setIsDelete(DeleteEnum.NO.getCode());
        record.setFounder(userName);
        record.setModifier(userName);
        record.setCreateDate(new Date());
        record.setUpdateDate(new Date());
        browseRecordInfoMapper.insert(record);
    }

    /**
     * 根据条件查询浏览记录相关信息且分页
     *
     * @param recordInfoQuery
     * @return
     */
    @Override
    public Result findBrowseRecordInfoPage(ReqBrowseRecordInfoFrontQuery recordInfoQuery) {
        log.info( "根据条件查询浏览记录相关信息且分页 请求参数：{}", JSON.toJSONString( recordInfoQuery ) );

        Integer userId = 0;
        String  userName;
        try{
            Claims claims = JwtUtil.parseJWT(recordInfoQuery.getToken());
            userId = Integer.parseInt(claims.get("userId").toString()) ;
            userName = claims.get("userName").toString();
            log.info("通过token 解析的用户id：{},用户名：{}",userId,userName);
        }catch (Exception e){
            return Result.error(BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }

        PageInfo<BrowseRecordInfoView> pageInfo = null;
        try{
            Page<?> page = PageHelper.startPage(recordInfoQuery.getPageNum(),recordInfoQuery.getPageSize());
            recordInfoQuery.setUserId(userId);
            List<BrowseRecordInfo> queryBrowseRecordInfo = browseRecordInfoMapper.findBrowseRecordInfo(recordInfoQuery);
            if (CollectionUtils.isEmpty( queryBrowseRecordInfo )){
                pageInfo = new PageInfo<>(new ArrayList<>(16));
            }else{
                List<BrowseRecordInfoView> views = new ArrayList<>(  16);
                queryBrowseRecordInfo.stream().forEach( browseRecordInfo -> {
                    BrowseRecordInfoView view = new BrowseRecordInfoView();
                    BeanCopier beanCopier = BeanCopier.create( BrowseRecordInfo.class,BrowseRecordInfoView.class,false );
                    beanCopier.copy( browseRecordInfo,view,null );
                    views.add( view );
                } );
                pageInfo = new PageInfo<>(views);
            }
            log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        }catch (Exception e){
            log.info( "根据条件查询浏览记录相关信息且分页 查询异常：{}",e.getMessage() );
        }
        return Result.success(pageInfo);
    }

    /**
     * 根据用户id 查询收藏记录
     * @param userId
     * @return
     */
    @Override
    public List<BrowseRecordInfo> findByUserId(Integer userId) {
        log.info("根据用户id 查询收藏记录 请求参数：{}",userId);
        return browseRecordInfoMapper.findByUserId(userId);
    }
}
