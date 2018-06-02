package xiao.ze.demo.mapper;

import xiao.ze.demo.entity.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaozemaliya on 2017/1/31.
 */
public interface CourseMapper {

    void addCourse(Course course);

    boolean removeCourseByNo(String courseNo);

    boolean removeCourseByTypeId(Integer typeId);

    void updateCourse(Course course);

    Course loadCourseByNo(String courseNo);

    //根据type_id查找记录
    List<String> loadCourseByTypeId(Integer typeId);

    //获得某查询条件下的所有的记录集
    List<Course> loadScopedCourses(Map map);

}
