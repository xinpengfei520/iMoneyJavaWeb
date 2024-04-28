package com.xpf.imoney.serviceimpl;

import com.xpf.imoney.bean.User;
import com.xpf.imoney.mapper.UserMapper;
import com.xpf.imoney.service.UserService;
import com.xpf.imoney.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(int id) {
        SqlSession session = SqlSessionUtils.getSqlSession();
        if (session == null) {
            return null;
        }
        User user = session.getMapper(UserMapper.class).findUserById(id);
        session.close();
        return user;
    }
}
