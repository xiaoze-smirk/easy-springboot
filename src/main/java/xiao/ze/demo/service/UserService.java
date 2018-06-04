package xiao.ze.demo.service;

import xiao.ze.demo.entity.User;

/**
 * UserService
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
public interface UserService {

    /**
     * 获取一条用户数据
     *
     * @param  userNo
     * @return User
     *
     */
    User get(String userNo);


    /**
     * 新增一条用户数据
     *
     * @param  user
     * @return User
     *
     */
    void addUser(User user);

}

