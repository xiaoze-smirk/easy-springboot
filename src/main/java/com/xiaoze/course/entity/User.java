package com.xiaoze.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * User
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Data
@TableName("tbl_users")
public class User implements Serializable{

    private static final long serialVersionUID = -8064251796984414018L;

    @TableId(type = IdType.AUTO)
    private String userNo;

    private String userName;

    private String userPwd;

}
