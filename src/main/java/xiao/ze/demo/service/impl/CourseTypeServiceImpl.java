package xiao.ze.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xiao.ze.demo.entity.CourseType;
import xiao.ze.demo.mapper.CourseMapper;
import xiao.ze.demo.mapper.CourseTypeMapper;
import xiao.ze.demo.service.CourseTypeService;

import java.util.List;

/**
 * Created by xiaozemaliya on 2017/1/31.
 */
@Service
@Transactional
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourseType(CourseType courseType) {

        courseTypeMapper.addCourseType(courseType);

    }

    @Override
    public void removeCourseType(Integer typeId) {

        if(courseMapper.loadCourseByTypeId(typeId)!=null){
            courseMapper.removeCourseByTypeId(typeId);
        }

        courseTypeMapper.removeCourseType(typeId);

    }

    @Override
    public void updateCourseType(CourseType courseType) {

        courseTypeMapper.updateCourseType(courseType);

    }

    @Override
    public CourseType getCourseTypeById(Integer typeId) {

        return courseTypeMapper.getCourseTypeById(typeId);

    }

    @Override
    public List<CourseType> loadAll() {

        return courseTypeMapper.loadAll();

    }

}
