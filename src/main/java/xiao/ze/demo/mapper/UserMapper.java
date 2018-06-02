package xiao.ze.demo.mapper;


import xiao.ze.demo.entity.User;

/**
 * Created by xiaozemaliya on 2017/1/31.
 */
public interface UserMapper {

    User get(String userNo);

    void addUser(User user);

}
