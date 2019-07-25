package com.xiaoze.course.annotation;

import java.lang.annotation.*;

/**
 * 自定义参数类型的注解
 *
 * @author : xiaoze
 * @date : 2019/7/25
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import({UserInfoConfiguration.class})
public @interface CurrentUser {
}
