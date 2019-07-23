package com.xpf.imoney.annotation;

import java.lang.annotation.*;

/**
 * Created by Vance on 2019/07/23 :)
 * Function:自定义注解，标识是否忽略 REST 安全性检查
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSecurity {

}
