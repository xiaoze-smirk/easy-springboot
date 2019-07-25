package com.xiaoze.course.config;

import com.xiaoze.course.annotation.CurrentUser;
import com.xiaoze.course.entity.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : xiaoze
 * @date : 2019/7/25
 */

public class UserArgumentResolver implements HandlerMethodArgumentResolver {


    /**
     * 过滤出符合条件的参数，这里指的是加了 CurrentUser 注解的参数
     *
     * @param parameter
     * @return boolean
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public UserInfo resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest
            webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        String authorization = null;
        if(servletRequest != null){
            authorization = servletRequest.getHeader("Authorization");
        }

        UserInfo userInfo;
        if (StringUtils.isNotBlank(authorization)) {
            String[] strArray = authorization.split(":");
            userInfo = new UserInfo(strArray[0], strArray[1]);
        }else {
            userInfo = new UserInfo();
        }

        return userInfo;
    }
}