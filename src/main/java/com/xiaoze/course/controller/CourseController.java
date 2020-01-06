package com.xiaoze.course.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoze.course.entity.Course;
import com.xiaoze.course.service.CourseService;
import com.xiaoze.course.vo.CourseQueryHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.xiaoze.course.service.CourseTypeService;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Map;

/**
 * CourseController
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Slf4j
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseTypeService courseTypeService ;

    @GetMapping("/toInput")
    public String toInput(Map<String, Object> map,Course course) {


        map.put("courseTypeList", courseTypeService.list());

        course.setCourseStatus("O");
        course.setCourseReqs(new String[]{"a","b"});

        map.put("course", course);

        return "course/input_course";
    }

    @PostMapping(value="/create")
    public String create(@RequestParam("coursetextbookpic") MultipartFile file, Course course, Map<String, Object> map) throws Exception{

        //读取文件数据，转成字节数组

        if(file!=null){
            course.setCourseTextbookPic(file.getBytes());
        }

        try{
            courseService.save(course);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            map.put("courseTypeList", courseTypeService.list());

            return "course/input_course";
        }

        return "redirect:/course/list";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value="pageNo", required=false, defaultValue="1") String pageNoStr,
                       Map<String, Object> map, CourseQueryHelper helper) {

        int pageNo = 1;

        //对 pageNo 的校验
        pageNo = Integer.parseInt(pageNoStr);
        if(pageNo < 1){
            pageNo = 1;
        }

        Page<Course> page = courseService.getCoursePage(helper, pageNo, 3);

        map.put("courseTypeList", courseTypeService.list());
        map.put("page", page);
        map.put("helper", helper);

        return "course/list_course";

    }


    @DeleteMapping(value="/remove/{courseNo}")
    public String remove(@PathVariable("courseNo") String courseNo) {

        courseService.removeById(courseNo);

        return "redirect:/course/list";

    }

    @GetMapping(value="/preUpdate/{courseNo}")
    public String preUpdate(@PathVariable("courseNo") String courseNo, Map<String, Object> map) {

        Course course = courseService.getById(courseNo);
        course.setCourseType(courseTypeService.getById(course.getTypeId()));
        map.put("course" , course);

        map.put("courseTypeList", courseTypeService.list());

        return "course/update_course";

    }

    @PostMapping(value="/update")
    public String update(@RequestParam("coursetextbookpic") MultipartFile file, Course course, Map<String, Object> map) throws Exception{

        //读取多段提交的文件数据，转成字节数组
        if(file.getBytes().length > 0){
            course.setCourseTextbookPic(file.getBytes());
        }

        try{
            courseService.updateById(course);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            map.put("courseTypeList", courseTypeService.list());

            return "/course/update_course";
        }

        return "redirect:/course/list";

    }

    @GetMapping("/getPic/{courseNo}")
    public String getPic(@PathVariable("courseNo") String courseNo, HttpServletRequest request, HttpServletResponse response) throws Exception{

        byte[] textBookPic = courseService.getTextbookPic(courseNo);

        if((textBookPic == null) || (textBookPic.length == 0)){
            ClassPathResource classPathResource = new ClassPathResource("static/pics/default.jpg");
            InputStream inputStream =classPathResource.getInputStream();

            textBookPic = new byte[inputStream.available()];
            int i = inputStream.read(textBookPic);
            while(i != -1){
                i = inputStream.read(textBookPic);
            }
        }

        //向浏览器发通知，我要发送是图片
        response.setContentType("image/jpeg");
        ServletOutputStream sos=response.getOutputStream();
        sos.write(textBookPic);
        sos.flush();
        sos.close();

        return null;

    }


}
