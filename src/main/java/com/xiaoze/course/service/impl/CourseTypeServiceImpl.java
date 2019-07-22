package com.xiaoze.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoze.course.entity.Course;
import com.xiaoze.course.entity.CourseType;
import com.xiaoze.course.mapper.CourseMapper;
import com.xiaoze.course.mapper.CourseTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiaoze.course.service.CourseTypeService;

import java.util.List;

/**
 * CourseTypeServiceImpl
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements CourseTypeService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public void deleteCourseType(Integer typeId) {

        courseMapper.delete(
                new LambdaQueryWrapper<Course>()
                        .eq(Course::getTypeId, typeId)
        );
        baseMapper.deleteById(typeId);

    }
}
