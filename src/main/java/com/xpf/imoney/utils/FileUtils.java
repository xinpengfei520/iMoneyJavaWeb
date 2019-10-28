package com.xpf.imoney.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by Vance on 2019/9/29 :)
 * Function:
 */
public class FileUtils {

    public static ByteArrayInputStream parse(ByteArrayOutputStream out) {
        return new ByteArrayInputStream(out.toByteArray());
    }
}
