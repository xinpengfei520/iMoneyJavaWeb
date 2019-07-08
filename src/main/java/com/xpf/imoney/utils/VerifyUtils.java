package com.xpf.imoney.utils;

import com.xpf.imoney.constants.AccessToken;

/**
 * @author Vancy
 * Function:verify utils.
 * @date 2019-06-07
 */
public class VerifyUtils {

    public static String getPathByToken(String token, String path) {
        if (AccessToken.API_WEATHER_TOKEN.equals(token)) {
            return path;
        } else {
            return "json/error.json";
        }
    }
}
