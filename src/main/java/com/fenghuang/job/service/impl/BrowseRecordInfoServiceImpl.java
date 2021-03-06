package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.BrowseRecordInfoMapper;
import com.fenghuang.job.dao.master.ProjectInfoMapper;
import com.fenghuang.job.entity.BrowseRecordInfo;
import com.fenghuang.job.entity.ProjectInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.enums.ProjectLabelEnum;
import com.fenghuang.job.enums.SalaryUnitEnum;
import com.fenghuang.job.request.ReqBrowseRecordInfoFrontQuery;
import com.fenghuang.job.service.BrowseRecordInfoService;
import com.fenghuang.job.view.BrowseRecordInfoView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Autowired
    UserInfoByTokenSerivce userInfoByTokenSerivce;

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
        record.setProvinceTitle( projectInfoById.getProvinceTitle() );
        record.setCityId(projectInfoById.getCityId());
        record.setCityTitle( projectInfoById.getCityTitle() );
        record.setAreaId(projectInfoById.getAreaId());
        record.setAreaTitle( projectInfoById.getAreaTitle() );
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

        Integer userId;
        String  userName ;
        Result userInfoByToken = userInfoByTokenSerivce.getUserInfoByToken(recordInfoQuery.getToken());
        if (userInfoByToken.getCode() == 2001){
            return Result.error(BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        Map user = (Map) userInfoByToken.getData();
        userId = Integer.valueOf(user.get("userId").toString());
        userName = user.get("userName").toString();
        log.info("解析token获取的结果{},{}",userId,userName);

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
                    view.setSalaryUnitDesc( SalaryUnitEnum.fromValue(browseRecordInfo.getSalaryUnit()  ).getMsg() );

                    //标签转换：
                    List<String> projectLabels = Splitter.on(",").trimResults().splitToList(browseRecordInfo.getProjectLabel());
                    List<String> labels = new ArrayList<>();
                    if (CollectionUtils.isEmpty(projectLabels)){
                        view.setProjectLabelsDesc(labels);
                    }else{
                        projectLabels.stream().forEach(s -> {
                            if (s.equals( ProjectLabelEnum.LONG_WORKER.getCode().toString())){
                                labels.add(ProjectLabelEnum.LONG_WORKER.getMsg());
                            }
                            if (s.equals(ProjectLabelEnum.SHORT_WORKER.getCode().toString())){
                                labels.add(ProjectLabelEnum.SHORT_WORKER.getMsg());
                            }
                            if (s.equals(ProjectLabelEnum.WINTER_WORKER.getCode().toString())){
                                labels.add(ProjectLabelEnum.WINTER_WORKER.getMsg());
                            }
                            if (s.equals(ProjectLabelEnum.SUMMER_WORKER.getCode().toString())){
                                labels.add(ProjectLabelEnum.SUMMER_WORKER.getMsg());
                            }
                            if (s.equals(ProjectLabelEnum.HOURLY_WORKER.getCode().toString())){
                                labels.add(ProjectLabelEnum.HOURLY_WORKER.getMsg());
                            }
                        });
                        view.setProjectLabelsDesc(labels);
                    }
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

    /**
     * 删除浏览记录
     *
     * @param ids
     * @param token
     * @return
     */
    @Override
    public Result batchDeleteBrowseRecordInfo(String ids, String token) {
        log.info( "删除浏览记录请求参数：{}",ids );

        Integer userId;
        String  userName ;
        Result userInfoByToken = userInfoByTokenSerivce.getUserInfoByToken(token);
        if (userInfoByToken.getCode() == 2001){
            return Result.error(BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        Map user = (Map) userInfoByToken.getData();
        userId = Integer.valueOf(user.get("userId").toString());
        userName = user.get("userName").toString();
        log.info("解析token获取的结果{},{}",userId,userName);

        if (StringUtils.isEmpty( ids )){
            browseRecordInfoMapper.deleteByUserId(userId);
        }else{
            List<String> idList = Splitter.on(",").trimResults().splitToList(ids);
            browseRecordInfoMapper.deleteByUserIdAndIdList(userId,idList);
        }
        return Result.success();
    }
}
