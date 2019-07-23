package com.xpf.imoney.utils;

import java.util.UUID;


/**
 * Created by Vance on 2019/07/23 :)
 * Function:生成 UUID
 */
public class CodecUtil {

    public static String createUUID() {
        return UUID.randomUUID().toString();
    }
}
