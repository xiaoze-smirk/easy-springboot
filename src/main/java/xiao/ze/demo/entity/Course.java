package xiao.ze.demo.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Course
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Component
public class Course implements Serializable{

    private String courseNo;

    private String courseName;

    private Integer courseHours;

    /**
     * 单选互斥
     */
    private String courseStatus;

    private Double coursePoint;

    /**
     * 多选
     */
    private String[] courseReqs;

    private String reqs;

    private String courseMemo;

    /**
     * 教材封面
     */
    private byte[] courseTextbookPic;

    /**
     * 对一关系
     */
    private CourseType courseType;

    public String getCourseNo() {
        return courseNo;
    }
    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Integer getCourseHours() {
        return courseHours;
    }
    public void setCourseHours(Integer courseHours) {
        this.courseHours = courseHours;
    }

    public String[] getCourseReqs() {
        return courseReqs;
    }
    public void setCourseReqs(String[] courseReqs) {
        this.courseReqs = courseReqs;

        StringBuffer sb = new StringBuffer();
        for(String req:courseReqs){
            sb.append(req).append("|");
        }
        sb.deleteCharAt(sb.length()-1);

        this.reqs = sb.toString();
    }

    public CourseType getCourseType() {
        return courseType;
    }
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
    public String getCourseStatus() {
        return courseStatus;
    }
    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }
    public Double getCoursePoint() {
        return coursePoint;
    }
    public void setCoursePoint(Double coursePoint) {
        this.coursePoint = coursePoint;
    }

    public String getCourseMemo() {
        return courseMemo;
    }
    public void setCourseMemo(String courseMemo) {
        this.courseMemo = courseMemo;
    }

    public byte[] getCourseTextbookPic() {
        return courseTextbookPic;
    }
    public void setCourseTextbookPic(byte[] courseTextbookPic) {
        this.courseTextbookPic = courseTextbookPic;
    }
    public String getReqs() {
        return reqs;
    }
    public void setReqs(String reqs) {
        this.reqs = reqs;
        this.courseReqs = this.reqs.split("\\|");
    }

}
