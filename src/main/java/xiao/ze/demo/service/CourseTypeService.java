package xiao.ze.demo.service;

import xiao.ze.demo.entity.CourseType;

import java.util.List;

/**
 * Created by xiaozemaliya on 2017/1/31.
 */
public interface CourseTypeService {

    void addCourseType(CourseType courseType);

    void removeCourseType(Integer typeId);

    void updateCourseType(CourseType courseType);

    CourseType getCourseTypeById(Integer typeId);

    List<CourseType> loadAll();

}
