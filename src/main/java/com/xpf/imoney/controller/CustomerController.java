package com.xpf.imoney.controller;

import com.xpf.imoney.bean.User;
import com.xpf.imoney.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Vance on 2019/7/23 :)
 * Function:
 */
@RestController
@RequestMapping("/users")
public class CustomerController {

    private CustomerService customerService;
    private static final Logger log = Logger.getLogger(CustomerController.class);

    public CustomerService getCustomerService() {
        return customerService;
    }

    @Resource(name = "customerService")
    public void setUserService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 获取指定 Id 的用户
     *
     * @param id
     * @return User
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUser(@PathVariable("id") int id) {
        User user = customerService.getUser(id);
        log.debug("查询用户 :" + user);
        return user;
    }

    /**
     * 添加指定 Id 的用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json",
            consumes = "application/json")
    public User addUser(@RequestBody @Valid User user) {
        customerService.addUser(user);
        log.debug("添加用户 :" + user);
        return user;
    }
}
