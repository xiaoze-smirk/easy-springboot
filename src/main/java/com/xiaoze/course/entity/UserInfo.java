package com.xiaoze.course.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : xiaoze
 * @date : 2019/7/25
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 6172465382210937945L;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public UserInfo() {
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
