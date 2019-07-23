package com.xpf.imoney.serviceimpl;

import com.xpf.imoney.bean.User;
import com.xpf.imoney.mapper.CustomerMapper;
import com.xpf.imoney.service.CustomerService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Vance on 2019/7/23 :)
 * Function:
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Component("customerService")
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;

    public CustomerMapper getCustomerMapper() {
        return customerMapper;
    }

    /**
     * 默认按名称(customerMapper)注入，若名称匹配失败，则按照类型匹配
     */
    @Resource
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    /**
     * 登录逻辑的具体实现，对应事务包括用户的查询和日志的插入两部分
     *
     * @param name
     * @param password
     * @return 用户名、密码匹配成功，返回true；否则，返回false;
     */
    @Transactional(readOnly = false) // 必须设置为 false,因为此处切入了日志的保存逻辑
    @Override
    public boolean login(String name, String password) {
        User user = customerMapper.findUserByNameAndPassword(name, password);
        return user != null;
    }

    @Override
    public void addUser(User user) {
        customerMapper.saveUser(user);
    }

    /**
     * 用户获取逻辑的具体实现
     *
     * @param id
     * @return User
     */
    @Transactional(readOnly = false) // 必须设置为 false,因为此处切入了日志的保存逻辑
    @Override
    public User getUser(int id) {
        return customerMapper.findUserById(id);
    }
}
