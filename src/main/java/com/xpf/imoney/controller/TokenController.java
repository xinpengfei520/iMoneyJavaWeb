package com.xpf.imoney.controller;

import com.xpf.imoney.annotation.IgnoreSecurity;
import com.xpf.imoney.aspect.SecurityAspect;
import com.xpf.imoney.authorization.TokenManager;
import com.xpf.imoney.response.Response;
import com.xpf.imoney.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vance on 2019/7/23 :)
 * Function:Token的管理，处理用户的登录、登出操作
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    private CustomerService customerService;
    private TokenManager tokenManager;
    private static final Logger log = Logger.getLogger(TokenController.class);

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Resource(name = "customerService")
    public void setUserService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public TokenManager getTokenManager() {
        return tokenManager;
    }

    @Resource(name = "tokenManager")
    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    /**
     * 登录处理
     */
    @RequestMapping(method = RequestMethod.POST)
    @IgnoreSecurity
    public Response login(@RequestParam("name") String name, @RequestParam("password") String password,
                          HttpServletResponse response) {
        boolean flag = customerService.login(name, password);
        if (flag) {
            String token = tokenManager.createToken(name);
            log.debug("**** Generate Token **** : " + token);
            Cookie cookie = new Cookie(SecurityAspect.DEFAULT_TOKEN_NAME, token);
            log.debug("Write Token to Cookie and return to the Client : " + cookie.toString());
            response.addCookie(cookie);
            return new Response().success("Login Success...");
        }
        return new Response().failure("Login Failure...");
    }

    /**
     * 退出登录
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response logout(HttpServletRequest request) {
        String token = request.getHeader(SecurityAspect.DEFAULT_TOKEN_NAME);
        tokenManager.deleteToken(token);
        log.debug("Logout Success...");
        return new Response().success("Logout Success...");
    }
}
