package cn.service;

import cn.entity.User;
import cn.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public User getUser(String username) {
        return userMapper.findByUsername(username);
    }
}
