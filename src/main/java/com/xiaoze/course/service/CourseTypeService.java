package com.xiaoze.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoze.course.entity.CourseType;

/**
 * CourseTypeService
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
public interface CourseTypeService extends IService<CourseType> {

    /**
     * 根据课程类型删除对应的课程
     * @param typeId
     */
    void deleteCourseType(Integer typeId);

}
