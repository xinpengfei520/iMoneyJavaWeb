package com.xpf.imoney.controller;

import com.xpf.imoney.bean.User;
import com.xpf.imoney.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:控制层
 */
@Api(value = "/user", description = "关于用户的一些操做。")
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/index")
    @ApiOperation(value = "通过 ID 查询 USER 信息", httpMethod = "GET", notes = "暂无")
    public User index(@RequestParam("id") int id) {
        return userService.getUserById(id);
    }
}
