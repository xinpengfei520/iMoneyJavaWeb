package com.xpf.imoney.serviceimpl;

import com.xpf.imoney.bean.User;
import com.xpf.imoney.mapper.UserMapper;
import com.xpf.imoney.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImpl implements UserService {

    /**
     * mybatis 的接口
     */
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String name) {
        return null;
    }
}
