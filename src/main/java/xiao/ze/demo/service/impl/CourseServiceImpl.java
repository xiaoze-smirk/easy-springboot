package xiao.ze.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xiao.ze.demo.entity.Course;
import xiao.ze.demo.mapper.CourseMapper;
import xiao.ze.demo.service.CourseService;
import xiao.ze.demo.utils.CourseQueryHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaozemaliya on 2017/1/31.
 */
@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {

        courseMapper.addCourse(course);

    }

    @Override
    public boolean removeCourseByNo(String courseNo) {

        courseMapper.removeCourseByNo(courseNo) ;
        return true;

    }

    @Override
    public void updateCourse(Course course) {

        String[] courseReq = course.getCourseReqs();
        if (courseReq != null && courseReq.length > 0) {

            courseMapper.updateCourse(course); // 操作

        } else {
            course.setReqs("");
            courseMapper.updateCourse(course); // 操作
        }

    }

    @Override
    public Course loadCourseByNo(String courseNo) {

        Course course=new Course();
        course=null;
        if(courseNo!=null) {
            course = courseMapper.loadCourseByNo(courseNo);
        }
        return course;

    }

    @Override
    public List<Course> loadScopedCourses(CourseQueryHelper helper) {

        Map<String,Object> map = new HashMap<String,Object>();
        map=getQueryHelper(helper);

        List<Course> list = courseMapper.loadScopedCourses(map);

        return list;

    }

    @Override
    public byte[] getTextbookPic(String courseNo) {

        byte[] textBookPic = null;

        Course course = courseMapper.loadCourseByNo(courseNo); // 操作

        textBookPic = course.getCourseTextbookPic();

        return textBookPic;

    }

    private Map<String,Object> getQueryHelper(CourseQueryHelper helper) {

        Map<String,Object> map = new HashMap<String,Object>();		//参数

        if(helper.getQryCourseName()!=null){
            map.put("qryCourseName", helper.getQryCourseName());
        }

        if(helper.getQryEndPoint()!=null){
            map.put("qryEndPoint", helper.getQryEndPoint());
        }

        if(helper.getQryStartPoint()!=null){
            map.put("qryStartPoint", helper.getQryStartPoint());
        }

        if(helper.getQryCourseType()!=null&&helper.getQryCourseType()!=""){
            map.put("typeId", Integer.parseInt(helper.getQryCourseType()));
        }

        return map;
    }

}
