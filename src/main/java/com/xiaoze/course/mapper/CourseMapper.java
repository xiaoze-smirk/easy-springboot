package com.xiaoze.course.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoze.course.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CourseMapper
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 获取Course分页数据
     * @param coursePage
     * @param wrapper
     * @return List<Course>
     */
    List<Course> getCourseList(Page<Course> coursePage, @Param("ew") Wrapper<Course> wrapper);

}
