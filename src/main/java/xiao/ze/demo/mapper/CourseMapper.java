package xiao.ze.demo.mapper;

import xiao.ze.demo.entity.Course;

import java.util.List;
import java.util.Map;

/**
 * CourseMapper
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
public interface CourseMapper {

    /**
     * 新增课程记录
     *
     * @param course
     *
     */
    void addCourse(Course course);

    /**
     * 删除一条课程记录
     *
     * @param courseNo
     * @return boolean
     *
     */
    boolean removeCourseByNo(String courseNo);

    /**
     * 根据外键删除一条课程记录
     *
     * @param typeId
     * typeId是外键
     *
     * @return boolean
     *
     *
     */
    boolean removeCourseByTypeId(Integer typeId);

    /**
     * 更新一条课程记录
     *
     * @param course
     *
     */
    void updateCourse(Course course);

    /**
     * 获取一条课程记录
     *
     * @param courseNo
     * @return Course
     *
     */
    Course loadCourseByNo(String courseNo);

    /**
     * 根据外键获取课程记录
     *
     * @param typeId
     * @return List
     *
     */
    List<String> loadCourseByTypeId(Integer typeId);


    /**
     * 获得某查询条件下的所有的记录集
     *
     * @param map
     * @return List
     *
     */
    List<Course> loadScopedCourses(Map map);

}
