package com.xpf.imoney.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vance on 2019/07/23 :)
 * Function:Web 上下文工具类
 */
public class WebContextUtil {

    /**
     * 获取 HTTP 请求
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
