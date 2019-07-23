package com.xpf.imoney.service;

import com.xpf.imoney.bean.User;

/**
 * Created by Vance on 2019/7/23 :)
 * Function:对用户相关的业务逻辑的抽象(面向接口编程)
 */
public interface CustomerService {


    /**
     * 用户登录逻辑
     *
     * @param name
     * @param password
     * @return
     */
    boolean login(String name, String password);

    /**
     * 用户注册逻辑
     *
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 用户获取逻辑
     *
     * @param id
     */
    User getUser(int id);
}

