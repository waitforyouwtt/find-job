package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.ProjectInfoMapper;
import com.fenghuang.job.dao.master.ProjectWorkDateInfoMapper;
import com.fenghuang.job.dao.master.ProjectWorkTimeInfoMapper;
import com.fenghuang.job.entity.*;
import com.fenghuang.job.enums.*;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.request.*;
import com.fenghuang.job.service.ProjectInfoService;
import com.fenghuang.job.view.ProjectView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 12:27
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Autowired
    ProjectInfoMapper projectMapper;

    @Autowired
    ProjectWorkDateInfoMapper projectWorkDateInfoMapper;

    @Autowired
    ProjectWorkTimeInfoMapper projectWorkTimeInfoMapper;
    /**
     * 创建项目
     *
     * @param reqProject
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insertProject(ReqProjectInfo reqProject) {
        log.info( "创建项目 请求参数：{}", JSON.toJSONString(reqProject) );
        ReqProjectInfoQuery query = new ReqProjectInfoQuery();
        query.setUserId(reqProject.getUserId());
        query.setProjectTypeId(reqProject.getProjectTypeId());
        query.setProjectTitle(reqProject.getProjectTitle());
        query.setIsDelete(DeleteEnum.NO.getCode());
        //同一用户 & 同一类型 & 相同标题 状态为未删除的项目不允许重复
        ProjectInfo projects = projectMapper.findProjectParams(query);
        if (projects != null){
            return Result.error(BusinessEnum.RECORD_ALREADY_EXISTS.getCode(),BusinessEnum.RECORD_ALREADY_EXISTS.getMsg(),null);
        }
        ProjectInfo project = new ProjectInfo();

        //当标签不为空时处理成int 存到数据库
        if (!CollectionUtils.isEmpty(reqProject.getProjectLabels())){
          String labels = StringUtils.strip(Joiner.on(",").join(reqProject.getProjectLabels()),"[]");
            project.setProjectLabel(Integer.parseInt(StringUtils.strip(labels,"")));
        }
        project.setProjectState(ProjectStatusEnum.PUBLISH.getCode());
        project.setExamineStatus(ExamineStatusEnum.PASSED.getCode());
        project.setCreateDate(new Date());
        project.setUpdateDate(new Date());
        project.setFounder(reqProject.getUserId().toString());
        project.setModifier(reqProject.getUserId().toString());
        int projectResult = projectMapper.insertSelective(project);
        Integer projectId = project.getId();
        log.info( "生成订单返回的订单号为：{}",projectId );

        ProjectWorkDateInfo projectWorkDateInfo = new ProjectWorkDateInfo();
        projectWorkDateInfo.setProjectId(projectId);
        projectWorkDateInfo.setWorkDateBegin(reqProject.getWorkDateBegin());
        projectWorkDateInfo.setWorkDateEnd(reqProject.getWorkDateEnd());
        projectWorkDateInfo.setIsDelete(DeleteEnum.NO.getCode());
        projectWorkDateInfo.setFounder(reqProject.getUserId().toString());
        projectWorkDateInfo.setModifier(reqProject.getUserId().toString());
        projectWorkDateInfo.setCreateDate(new Date());
        projectWorkDateInfo.setUpdateDate(new Date());
        projectWorkDateInfoMapper.insertSelective(projectWorkDateInfo);

        ProjectWorkTimeInfo projectWorkTimeInfo = new ProjectWorkTimeInfo();
        projectWorkTimeInfo.setProjectId(projectId);
        projectWorkTimeInfo.setWorkTimeBegin(reqProject.getWorkTimeBegin());
        projectWorkTimeInfo.setWorkTimeEnd(reqProject.getWorkTimeEnd());
        projectWorkTimeInfo.setIsDelete(DeleteEnum.NO.getCode());
        projectWorkTimeInfo.setFounder(reqProject.getUserId().toString());
        projectWorkTimeInfo.setModifier(reqProject.getUserId().toString());
        projectWorkTimeInfo.setCreateDate(new Date());
        projectWorkTimeInfo.setUpdateDate(new Date());
        projectWorkTimeInfoMapper.insertSelective(projectWorkTimeInfo);

        return Result.success("创建项目成功");
    }

    /**
     * 根据id更新项目相关字段
     *
     * @param reqProject
     * @return
     */
    @Override
    public int modifyProject(ReqProjectInfo reqProject) {
        log.info( "根据id更新项目相关字段 请求参数：{}",JSON.toJSONString( reqProject ) );
        if (StringUtils.isBlank(reqProject.getId().toString())){
            throw new BusinessException(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg());
        }
        Project project = new Project();
        BeanCopier beanCopier = BeanCopier.create( ReqProjectInfo.class,Project.class,false );
        beanCopier.copy( reqProject,project,null );
        if (!CollectionUtils.isEmpty(reqProject.getProjectLabels())){
            String labels = StringUtils.strip(Joiner.on(",").join(reqProject.getProjectLabels()),"[]");
            project.setProjectLabels(StringUtils.strip(labels,""));
        }
        return 0;//projectMapper.updateByPrimaryKeySelective( project );
    }

    /**
     * 根据id更新项目状态
     *
     * @param reqProjectStatus
     * @return
     */
    @Override
    public int modifyProjectStatus(ReqProjectStatus reqProjectStatus) {
        log.info( "根据id更新项目状态 请求参数：{}",JSON.toJSONString( reqProjectStatus ) );
        if (StringUtils.isEmpty(reqProjectStatus.getId().toString())){
            throw new BusinessException(BusinessEnum.MISSING_PARAMETERS.getCode(),BusinessEnum.MISSING_PARAMETERS.getMsg());
        }
        ProjectInfo project = projectMapper.selectByPrimaryKey(reqProjectStatus.getId());
        if (project == null){
            throw new BusinessException(BusinessEnum.RECORD_NOT_EXIST.getCode(),BusinessEnum.RECORD_NOT_EXIST.getMsg());
        }
        Project projectParam = new Project();
        //如果审核状态没有则只修改项目状态 ; 否则就是管理员在审核，审核应该修改相应的项目状态
        projectParam.setId(reqProjectStatus.getId());
        if (StringUtils.isEmpty(reqProjectStatus.getExamineStatus().toString())){
            projectParam.setProjectStatus(reqProjectStatus.getProjectStatus());
        }else{
            if (reqProjectStatus.getExamineStatus().equals(ExamineStatusEnum.PASSED.getCode())){
                //projectParam.setProjectStatus(ProjectStatusEnum.CONDUCTING.getCode());
                projectParam.setExamineStatus(ExamineStatusEnum.PASSED.getCode());
            }else{
                projectParam.setExamineStatus(ExamineStatusEnum.REJECTED.getCode());
            }
        }
        return 0;// projectMapper.updateByPrimaryKeySelective(projectParam);
    }

    /**
     * 根据条件查询项目信息
     *
     * @param reqProject
     * @return
     */
    @Override
    public List<ProjectView> findProject(ReqProjectInfo reqProject) {
        log.info( "根据条件查询项目信息 请求参数：{}",JSON.toJSONString( reqProject ) );
        //convertSort(reqProject);
        List<ProjectInfo> queryProject  =  projectMapper.findProject(reqProject);
        if (CollectionUtils.isEmpty( queryProject )){
            return new ArrayList<>(  );
        }
        List<ProjectView>  views = new ArrayList<>(  );
        //convertView( queryProject, views );
        log.info( "根据条件查询项目信息 返回结果：{}",JSON.toJSONString( views ) );
        return views;
    }

    /**
     * 根据条件进行查询项目相关信息且分页
     *
     * @param reqProject
     * @return
     */
    @Override
    public PageInfo<ProjectView> findProjectPage(ReqProjectInfo reqProject) {
        log.info( "根据条件进行查询项目相关信息且分页 请求参数：{}",JSON.toJSONString( reqProject ) );
        PageInfo<ProjectView> pageInfo = null;
        try {
           /* Page<?> page = PageHelper.startPage(reqProject.getPageNum(),reqProject.getPageSize());
            List<ProjectInfo> queryProject  =  projectMapper.findProjectPage(reqProject);
            if (CollectionUtils.isEmpty( queryProject )){
                pageInfo = new PageInfo<>(new ArrayList<>());
            }else{
                List<ProjectView>  views = new ArrayList<>(  );
               // convertView( queryProject, views );
                pageInfo = new PageInfo<>(views);
            }*/
           //log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        }catch (Exception e){
            log.info( "根据条件进行查询项目相关信息且分页 查询异常：{}",e.getMessage() );
        }
        return pageInfo;
    }

/*    private void convertSort(ReqProjectInfo reqProject) {
        if (StringUtils.isEmpty( reqProject.getSortField() )){
            reqProject.setSortField( "project_create_date" );
            reqProject.setSort( SortEnum.DESC.getMsg() );
        }else {
            if (StringUtils.isEmpty( reqProject.getSort() )){
                reqProject.setSort( SortEnum.DESC.getMsg() );
            }else{
                if (reqProject.getSort() .equals(  SortEnum.ASC.getCode().toString()) ){
                    reqProject.setSort( SortEnum.ASC.getMsg() );
                }else if (reqProject.getSort().equals( SortEnum.DESC.getCode().toString())){
                    reqProject.setSort( SortEnum.DESC.getMsg() );
                }
            }
        }
    }*/

    private void convertView(List<Project> queryProject, List<ProjectView> views) {
        queryProject.stream().forEach( project -> {
            ProjectView view = new ProjectView();
            BeanCopier beanCopier = BeanCopier.create( Project.class, ProjectView.class, false );
            beanCopier.copy( project, view, null );
            view.setProjectStatusDesc(ProjectStatusEnum.fromValue(project.getProjectStatus()).getMsg());
            view.setExamineStatusDesc(ExamineStatusEnum.fromValue(project.getExamineStatus()).getMsg());
            view.setProjectLabels(Splitter.on(",").trimResults().splitToList(project.getProjectLabels()));
            views.add( view );
        } );
    }
}
