package xiao.ze.demo.utils;

/**
 * CourseQueryHelper
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
public class CourseQueryHelper {

    private String qryCourseName;

    /**
     * 查询学分的开始范围
     */
    private Double qryStartPoint;

    /**
     * 查询学分的结束范围
     */
    private Double qryEndPoint;

    private String qryCourseType;

    public String getQryCourseName() {
        return qryCourseName;
    }

    public void setQryCourseName(String qryCourseName) {
        this.qryCourseName = qryCourseName;
    }

    public Double getQryStartPoint() {
        return qryStartPoint;
    }

    public void setQryStartPoint(Double qryStartPoint) {
        this.qryStartPoint = qryStartPoint;
    }

    public Double getQryEndPoint() {
        return qryEndPoint;
    }

    public void setQryEndPoint(Double qryEndPoint) {
        this.qryEndPoint = qryEndPoint;
    }

    public String getQryCourseType() {
        return qryCourseType;
    }

    public void setQryCourseType(String qryCourseType) {
        this.qryCourseType = qryCourseType;
    }

}
