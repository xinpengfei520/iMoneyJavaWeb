package com.xpf.imoney.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vance on 2019/07/13 :)
 * Function:拦截器就是拦截某些请求的，同时会附加一些处理
 */
public class LoginInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 在业务处理器处理请求之前被调用，如果 preHandle 返回 false，则请求不再往下处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle():" + request.getRequestURL().toString() + "," + request.getRequestURI());
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle():" + request.getRequestURL().toString() + "," + request.getRequestURI());
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等 。afterCompletion()执行完成后开始渲染页面
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion():" + request.getRequestURL().toString() + "," + request.getRequestURI());
    }
}
