package xiao.ze.demo.service;


import xiao.ze.demo.entity.User;

/**
 * Created by xiaozemaliya on 2017/1/31.
 */
public interface UserService {

    User get(String userNo);

    void addUser(User user);

}

