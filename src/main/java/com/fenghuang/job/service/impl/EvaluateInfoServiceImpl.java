package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.EvaluateInfoMapper;
import com.fenghuang.job.entity.EvaluateInfo;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.enums.BusinessEnum;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.enums.EvaluateSourceEnum;
import com.fenghuang.job.request.ReqEvaluateInfo;
import com.fenghuang.job.request.ReqEvaluateInfoQuery;
import com.fenghuang.job.service.EvaluateInfoService;
import com.fenghuang.job.view.EvaluateInfoView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/9 11:24
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class EvaluateInfoServiceImpl implements EvaluateInfoService {


    @Resource
    EvaluateInfoMapper evaluateInfoMapper;

    @Autowired
    UserInfoByTokenSerivce userInfoByTokenSerivce;

    /**
     * 新增评价记录
     *
     * @param reqEvaluateInfo
     * @return
     */
    @Override
    public Result insertEvaluateInfo(ReqEvaluateInfo reqEvaluateInfo) {
        log.info("新增评价记录 请求参数：{}", JSON.toJSONString(reqEvaluateInfo));

        Integer userId;
        String  userName ;
        Result userInfoByToken = userInfoByTokenSerivce.getUserInfoByToken(reqEvaluateInfo.getToken());
        if (userInfoByToken.getCode() == 2001){
            return Result.error(BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getCode(),BusinessEnum.TOKEN_TIMEOUT_EXPRESS.getMsg(),null);
        }
        Map user = (Map) userInfoByToken.getData();
        userId = Integer.valueOf(user.get("userId").toString());
        userName = user.get("userName").toString();
        log.info("解析token获取的结果{},{}",userId,userName);

        EvaluateInfo evaluateInfo = new EvaluateInfo();
        BeanCopier beanCopier = BeanCopier.create(ReqEvaluateInfo.class,EvaluateInfo.class,false);
        beanCopier.copy(reqEvaluateInfo,evaluateInfo,null);
        evaluateInfo.setIsDelete(DeleteEnum.NO.getCode());
        evaluateInfo.setCreateDate(new Date());
        evaluateInfo.setUpdateDate(new Date());
        evaluateInfo.setUserId(userId);
        evaluateInfo.setFounder(userName);
        evaluateInfo.setModifier(userName);
        return Result.success(evaluateInfoMapper.insertSelective(evaluateInfo));
    }

    /**
     * 根据id查看评价详情
     *
     * @param id
     * @return
     */
    @Override
    public EvaluateInfoView findEvaluateInfoById(Integer id) {
        ReqEvaluateInfoQuery query = new ReqEvaluateInfoQuery();
        query.setId(id);
        List<EvaluateInfo> queryEvaluateInfo = evaluateInfoMapper.findEvaluateInfo(query);
        List<EvaluateInfoView> views = new ArrayList<>();
        if (CollectionUtils.isEmpty(queryEvaluateInfo)){
            return null;
        }else{
            convertView(queryEvaluateInfo, views);
        }
        return views.get(0);
    }

    private void convertView(List<EvaluateInfo> queryEvaluateInfo, List<EvaluateInfoView> views) {
        queryEvaluateInfo.stream().forEach(evaluateInfo -> {
            EvaluateInfoView view = new EvaluateInfoView();
            BeanCopier beanCopier = BeanCopier.create(EvaluateInfo.class,EvaluateInfoView.class,false);
            beanCopier.copy(evaluateInfo,view,null);
            view.setEvaluateSourceDesc(EvaluateSourceEnum.fromValue(evaluateInfo.getEvaluateSource()).getMsg());
            view.setIsDeleteDesc(DeleteEnum.fromValue(evaluateInfo.getIsDelete()).getMsg());
            views.add(view);
        });
    }

    /**
     * 根据条件查看评价且分页
     *
     * @param reqEvaluateInfoQuery
     * @return
     */
    @Override
    public PageInfo<EvaluateInfoView> findEvaluateInfoPage(ReqEvaluateInfoQuery reqEvaluateInfoQuery) {
        log.info("根据条件查看评价且分页 请求参数：{}",JSON.toJSONString(reqEvaluateInfoQuery));
        PageInfo<EvaluateInfoView> pageInfo = null;
        try{
            Page<?> page = PageHelper.startPage(reqEvaluateInfoQuery.getPageNum(),reqEvaluateInfoQuery.getPageSize());
            List<EvaluateInfo> queryEvaluateInfo = evaluateInfoMapper.findEvaluateInfo(reqEvaluateInfoQuery);
            if (CollectionUtils.isEmpty(queryEvaluateInfo)){
                pageInfo = new PageInfo<>(new ArrayList<>());
            }else{
                List<EvaluateInfoView> views = new ArrayList<>();
                convertView(queryEvaluateInfo, views);
                views.sort(Comparator.comparing(EvaluateInfoView::getCreateDate).reversed());
                pageInfo = new PageInfo<>(views);
            }
            log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        }catch (Exception e){
            log.info("根据条件查看评价且分页 查询异常：{}",e.getMessage());
        }
        return pageInfo;
    }
}
