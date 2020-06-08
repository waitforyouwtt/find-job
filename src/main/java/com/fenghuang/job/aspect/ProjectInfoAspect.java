package com.fenghuang.job.aspect;

import com.fenghuang.job.request.ReqProjectInfoQuery;
import com.fenghuang.job.service.BrowseRecordInfoService;
import com.fenghuang.job.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: luoxian
 * @Date: 2020/6/8 15:11
 * @Email: 15290810931@163.com
 */
@Component
@Aspect
@Order(2)
@Slf4j
public class ProjectInfoAspect {

    private final static String FIND_PROJECT_DETAILS_BYID_METHOD = "findProjectDetailsById";

    @Autowired
    BrowseRecordInfoService browseRecordInfoService;


    @Around(value = "@annotation(ProjectInfoAnnotation)")
    public Object interceptUpdatePrice(ProceedingJoinPoint pjp) {
        Object result = new Object();
        Method targetMethod = ((MethodSignature) (pjp.getSignature())).getMethod();
        String methodName = targetMethod.getName();
        Object[] args = pjp.getArgs();

        try{
            result = pjp.proceed(args);
            actionMthod(methodName, args, result);
        }catch (Throwable throwable){
            throwable.getMessage();
        }
        return result;
    }

    private void actionMthod(String methodName, Object[] args, Object ret) {
        switch(methodName){
            case FIND_PROJECT_DETAILS_BYID_METHOD:
                ReqProjectInfoQuery queryParams = (ReqProjectInfoQuery) args[0];
                Claims claims = JwtUtil.parseJWT(queryParams.getToken());
                Integer userId = Integer.valueOf(claims.get("userId").toString());
                Integer projectId = queryParams.getId();
                String userName =  claims.get("userName").toString();
                savebrowseRecordInfo(userId,userName,projectId);
                break;

            default:
                break;
        }
    }

    /**
     * 通过aop 切面保存用户浏览记录
     * @param userId
     * @param projectId
     */
    private void savebrowseRecordInfo(Integer userId,String userName,Integer projectId){
        browseRecordInfoService.insertBrowseRecordInfo(userId,userName,projectId);
    }
}
