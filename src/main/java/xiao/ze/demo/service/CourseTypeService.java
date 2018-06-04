package xiao.ze.demo.service;

import xiao.ze.demo.entity.CourseType;

import java.util.List;

/**
 * CourseTypeService
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
public interface CourseTypeService {

    /**
     * 新增一条课程类型记录
     *
     * @param courseType
     *
     */
    void addCourseType(CourseType courseType);

    /**
     * 删除一条课程类型记录
     *
     * @param typeId
     *
     */
    void removeCourseType(Integer typeId);

    /**
     * 更新一条课程类型记录
     *
     * @param courseType
     *
     */
    void updateCourseType(CourseType courseType);

    /**
     * 获取一条课程类型记录
     *
     * @param typeId
     * @return CourseType
     *
     */
    CourseType getCourseTypeById(Integer typeId);

    /**
     *  获取所有课程类型记录
     *
     * @return List
     *
     */
    List<CourseType> loadAll();

}
