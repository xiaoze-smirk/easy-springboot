package com.xiaoze.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Course
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Data
@TableName("tbl_course")
public class Course implements Serializable{

    private static final long serialVersionUID = 5421990434228550815L;

    /**
     * 课程编号
     */
    @TableId(value = "course_no", type = IdType.UUID)
    private String courseNo;

    /**
     * 课程名称
     */
    @TableField("course_name")
    private String courseName;

    /**
     * 课程课时
     */
    private Integer courseHours;

    /**
     * 课程类型Id
     */
    private Integer typeId;

    /**
     * 课程状态：O开发公选  Z暂不开放  C停止授课
     */
    private String courseStatus;

    /**
     * 授课要求
     */
    @TableField("course_reqs")
    private String reqs;
    /**
     * 授课要求，多选
     */
    @TableField(exist = false)
    private String[] courseReqs;

    /**
     * 学分
     */
    private Double coursePoint;

    /**
     * 备注说明
     */
    private String courseMemo;

    /**
     * 教材封面
     */
    private byte[] courseTextbookPic;

    /**
     * 对一关系
     */
    @TableField(exist = false)
    private CourseType courseType;

    public void setCourseReqs(String[] courseReqs) {
        this.courseReqs = courseReqs;

        StringBuffer sb = new StringBuffer();
        for(String req:courseReqs){
            sb.append(req).append("|");
        }
        sb.deleteCharAt(sb.length()-1);

        this.reqs = sb.toString();
    }

    public void setReqs(String reqs) {
        this.reqs = reqs;
        this.courseReqs = this.reqs.split("\\|");
    }

}
