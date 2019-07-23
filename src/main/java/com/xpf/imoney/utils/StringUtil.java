package com.xpf.imoney.utils;

/**
 * Created by Vance on 2019/07/23 :)
 * Function:字符串工具类
 */
public class StringUtil {

    /**
     * 给定字符串是否为空或空串
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return str != null && str.length() != 0;
    }

    /**
     * 给定字符串是否为空或空串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
