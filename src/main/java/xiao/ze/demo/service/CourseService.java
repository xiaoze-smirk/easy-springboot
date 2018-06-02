package xiao.ze.demo.service;

import xiao.ze.demo.entity.Course;
import xiao.ze.demo.utils.CourseQueryHelper;

import java.util.List;


/**
 * Created by xiaozemaliya on 2017/1/31.
 */
public interface CourseService {

    void addCourse(Course course);

    boolean removeCourseByNo(String courseNo);

    void updateCourse(Course course);

    Course loadCourseByNo(String courseNo);

    //获得某查询条件下的所有的记录集
    List<Course> loadScopedCourses(CourseQueryHelper helper);

    /**
     * 根据课程编号，获得教材封面图片
     * @param courseNo
     * @return
     */
    byte[] getTextbookPic(String courseNo);

}
