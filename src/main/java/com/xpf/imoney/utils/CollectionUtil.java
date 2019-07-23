package com.xpf.imoney.utils;

import java.util.Collection;

/**
 * Created by Vance on 2019/7/23 :)
 * Function:Collection 工具类
 */
public class CollectionUtil {

    public static boolean isNotEmpty(Collection<?> c) {
        return c != null && c.size() != 0;
    }
}
