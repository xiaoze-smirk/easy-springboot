package com.xiaoze.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * CourseType
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Data
@TableName("tbl_course_type")
public class CourseType implements Serializable{

    private static final long serialVersionUID = 585761698369667604L;

    @TableId(type = IdType.AUTO)
    private Integer typeId;

    private String  typeName;

}
