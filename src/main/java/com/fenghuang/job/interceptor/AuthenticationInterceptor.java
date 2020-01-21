package com.fenghuang.job.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fenghuang.job.config.CheckToken;
import com.fenghuang.job.config.LoginToken;
import com.fenghuang.job.exception.BusinessException;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.utils.JwtUtil;
import com.fenghuang.job.view.UserInfoView;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/13 16:59
 * @Email: 15290810931@163.com
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserInfoService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有LoginToken注释，有则跳过认证
        if (method.isAnnotationPresent(LoginToken.class)) {
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if (loginToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(CheckToken.class)) {
            CheckToken checkToken = method.getAnnotation(CheckToken.class);
            if (checkToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new BusinessException(400,"无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {

                   userId = JwtUtil.parseJWT( token ).get( "userId" ).toString();
                } catch (JWTDecodeException j) {
                    throw new BusinessException("访问异常！");
                }
                UserInfoView user = userService.findUserInfoById(Integer.parseInt(userId));
                if (user == null) {
                    throw new BusinessException("用户不存在，请重新登录");
                }
                Boolean verify = JwtUtil.isVerify(token, user);
                if (!verify) {
                    throw new BusinessException("非法访问！");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
