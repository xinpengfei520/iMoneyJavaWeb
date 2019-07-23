package com.xpf.imoney.aspect;

import com.xpf.imoney.exception.TokenException;
import com.xpf.imoney.response.Response;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Vance on 2019/7/23 :)
 * Function:全局异常处理切面 Description: 利用 @ControllerAdvice + @ExceptionHandler
 * 组合处理 Controller 层 RuntimeException 异常
 */
@ControllerAdvice // 控制器增强
@ResponseBody
public class ExceptionAspect {

    /**
     * Log4j 日志处理
     */
    private static final Logger log = Logger.getLogger(ExceptionAspect.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        log.error("could_not_read_json...", e);
        return new Response().failure("could_not_read_json");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Response handleValidationException(MethodArgumentNotValidException e) {
        log.error("parameter_validation_exception...", e);
        return new Response().failure("parameter_validation_exception");
    }

    /**
     * 405 - Method Not Allowed。HttpRequestMethodNotSupportedException
     * 是 ServletException 的子类,需要 Servlet API 支持
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        log.error("request_method_not_supported...", e);
        return new Response().failure("request_method_not_supported");
    }

    /**
     * 415 - Unsupported Media Type。HttpMediaTypeNotSupportedException
     * 是 ServletException 的子类,需要 Servlet API 支持
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Response handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("content_type_not_supported...", e);
        return new Response().failure("content_type_not_supported");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TokenException.class)
    public Response handleTokenException(Exception e) {
        log.error("Token is invalid...", e);
        return new Response().failure("Token is invalid");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.error("Internal Server Error...", e);
        return new Response().failure("Internal Server Error");
    }
}
