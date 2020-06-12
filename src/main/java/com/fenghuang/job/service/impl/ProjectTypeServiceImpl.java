package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.ProjectTypeMapper;
import com.fenghuang.job.entity.ProjectType;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.enums.ProjectTypeStatusEnum;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.request.ReqProjectType;
import com.fenghuang.job.service.ProjectTypeService;
import com.fenghuang.job.view.ProjectTypeSearchView;
import com.fenghuang.job.view.ProjectTypeView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
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
import java.util.stream.Collectors;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 10:48
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class ProjectTypeServiceImpl implements ProjectTypeService {

    @Resource
    private ProjectTypeMapper projectTypeMapper;

    @Autowired
    UserInfoByTokenSerivce userInfoByTokenSerivce;

    /**
     * 新增项目类型
     *
     * @param reqProjectType
     * @return
     */
    @Override
    public Result insertProjectType(ReqProjectType reqProjectType) {
        log.info( "新增项目类型 请求参数：{}", JSON.toJSONString( reqProjectType ) );

        Integer userId;
        String  userName ;
        Result userInfoByToken = userInfoByTokenSerivce.getUserInfoByToken(reqProjectType.getToken());
        if (userInfoByToken.getCode() == 2001){
            return Result.error(BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        Map user = (Map) userInfoByToken.getData();
        userId = Integer.valueOf(user.get("userId").toString());
        userName = user.get("userName").toString();
        log.info("解析token获取的结果{},{}",userId,userName);

        reqProjectType.setProjectTypeStatus( ProjectTypeStatusEnum.NORMAL.getCode() );
        //若存在相同名字的项目类型且为正常的状态则不允许创建
        List<ProjectType> queryProjectTypes = projectTypeMapper.findProjectType(reqProjectType);
        if (!CollectionUtils.isEmpty( queryProjectTypes )){
            throw new BusinessException( BusinessEnum.RECORD_ALREADY_EXISTS.getCode(),BusinessEnum.RECORD_ALREADY_EXISTS.getMsg() );
        }
        ProjectType projectType = new ProjectType();
        BeanCopier beanCopier = BeanCopier.create( ReqProjectType.class,ProjectType.class,false );
        beanCopier.copy( reqProjectType,projectType,null );
        projectType.setFounder(userName);
        projectType.setModifier(userName);
        projectType.setCreateDate(new Date());
        projectType.setUpdateDate(new Date());
        return Result.success(projectTypeMapper.insertSelective( projectType ));
    }

    /**
     * 更新项目类型字段
     *
     * @param reqProjectType
     * @return
     */
    @Override
    public Result modifyProjectType(ReqProjectType reqProjectType) {
        log.info( "更新项目类型字段 请求参数：{}",JSON.toJSONString( reqProjectType ) );
        if(StringUtils.isEmpty(reqProjectType.getId())){
            throw new BusinessException(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg());
        }

        Integer userId;
        String  userName ;
        Result userInfoByToken = userInfoByTokenSerivce.getUserInfoByToken(reqProjectType.getToken());
        if (userInfoByToken.getCode() == 2001){
            return Result.error(BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        Map user = (Map) userInfoByToken.getData();
        userId = Integer.valueOf(user.get("userId").toString());
        userName = user.get("userName").toString();
        log.info("解析token获取的结果{},{}",userId,userName);

        ProjectType projectType = new ProjectType();
        BeanCopier beanCopier = BeanCopier.create( ReqProjectType.class,ProjectType.class,false );
        beanCopier.copy( reqProjectType,projectType,null );
        projectType.setModifier(userName);
        projectType.setUpdateDate(new Date());
        return Result.success(projectTypeMapper.updateByPrimaryKeySelective( projectType ));
    }

    /**
     * 根据id 查询项目类型相关信息
     *
     * @param id
     * @return
     */
    @Override
    public ProjectTypeView findProjectTypeById(Integer id) {
        log.info( "根据id 查询项目类型相关信息 请求参数：{}",id );
        ProjectType projectType = projectTypeMapper.selectByPrimaryKey( id );
        if (projectType == null){
            return null;
        }
        ProjectTypeView view = new ProjectTypeView();
        BeanCopier beanCopier = BeanCopier.create( ProjectType.class,ProjectTypeView.class,false );
        beanCopier.copy( projectType,view,null );
        log.info( "根据id 查询项目类型相关信息 返回结果：{}",JSON.toJSONString( view ) );
        return view;
    }

    /**
     * 根据条件查询项目类型 且分页
     *
     * @param reqProjectType
     * @return
     */
    @Override
    public PageInfo<ProjectTypeView> findProjectTypePage(ReqProjectType reqProjectType) {
        log.info( "根据条件查询项目类型 且分页 请求参数：{}",JSON.toJSONString(reqProjectType  ) );
        PageInfo <ProjectTypeView> pageInfo = null;
        try {
            Page<?> page = PageHelper.startPage(reqProjectType.getPageNum(),reqProjectType.getPageSize());
            List<ProjectType> queryProjectType = projectTypeMapper.findProjectTypePage(reqProjectType );
            if (CollectionUtils.isEmpty( queryProjectType )){
                pageInfo = new PageInfo<>(new ArrayList<>());
            }else{
                List<ProjectTypeView> views = new ArrayList<>(  );
                queryProjectType.stream().forEach( projectType -> {
                    ProjectTypeView view = new ProjectTypeView();
                    BeanCopier beanCopier = BeanCopier.create( ProjectType.class, ProjectTypeView.class, false );
                    beanCopier.copy( projectType,view,null );
                    views.add( view );
                } );
                pageInfo = new PageInfo<>(views);
            }
            log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        }catch (Exception e){
            log.info("根据条件查询项目类型且分页 查询异常：{}",e);
        }
        return pageInfo;
    }

    @Override
    public List<ProjectTypeSearchView> findProjectTypes() {

        ReqProjectType reqProjectType = new ReqProjectType();
        reqProjectType.setParentId(0);
        reqProjectType.setIsDelete( DeleteEnum.NO.getCode() );
        reqProjectType.setProjectTypeStatus( ProjectTypeStatusEnum.NORMAL.getCode() );
        List<ProjectType> queryProjectType = projectTypeMapper.findProjectType( reqProjectType );
        List<ProjectTypeSearchView> result = Lists.newArrayList();
        queryProjectType.stream().forEach( type ->{
            ProjectTypeSearchView projectTypeSearchView = new ProjectTypeSearchView();
            projectTypeSearchView.setText( type.getCategoryName() );
            projectTypeSearchView.setId( type.getId() );
            reqProjectType.setParentId( type.getId() );
            List<ProjectType> list = projectTypeMapper.findProjectType( reqProjectType );
            List<ProjectTypeSearchView> collect = list.stream().map( item -> {
                ProjectTypeSearchView projectTypeSearchView1 = new ProjectTypeSearchView();
                projectTypeSearchView1.setText( item.getCategoryName() );
                projectTypeSearchView1.setId( item.getId() );
                return projectTypeSearchView1;
            } ).collect( Collectors.toList() );
            projectTypeSearchView.setChildren( collect );
            result.add( projectTypeSearchView );
        } );
        return result;
    }
}
