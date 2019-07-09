package com.xpf.imoney.controller;

import com.xpf.imoney.bean.User;
import com.xpf.imoney.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:控制层
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/index")
    @ResponseBody
    public User index(@RequestParam("name") String name) {
        return userService.getUser(name);
    }
}
