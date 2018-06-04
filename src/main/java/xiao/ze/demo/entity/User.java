package xiao.ze.demo.entity;


import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Component
@Table(name="tbl_users")
public class User implements Serializable{

    @Id
    @Column(name="user_no")
    private String userNo;

    @Column(name="user_name")
    private String userName;

    private String userPwd;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

}
