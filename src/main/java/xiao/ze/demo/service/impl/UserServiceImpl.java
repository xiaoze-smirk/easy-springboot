package xiao.ze.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xiao.ze.demo.entity.User;
import xiao.ze.demo.mapper.UserMapper;
import xiao.ze.demo.service.UserService;

/**
 * UserServiceImpl
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper ;

    @Override
    public User get(String userNo) {

        User user = null;
        user=userMapper.selectByPrimaryKey(userNo);
        return user;

    }

    @Override
    public void addUser(User user) {

        userMapper.insert(user);

    }

}