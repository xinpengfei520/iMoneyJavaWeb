package com.xpf.imoney.authorization;

import com.xpf.imoney.utils.CodecUtil;
import com.xpf.imoney.utils.StringUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Vance on 2019/07/23 :)
 * Function:TokenManager 的默认实现
 */
public class DefaultTokenManager implements TokenManager {

    /**
     * 将 token 存储到 JVM 内存(ConcurrentHashMap)中
     */
    private static Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();

    /**
     * 利用 UUID 创建 Token(用户登录时，创建 Token)
     *
     * @param username
     * @return
     */
    public String createToken(String username) {
        String token = CodecUtil.createUUID();
        tokenMap.put(token, username);
        return token;
    }

    /**
     * Token 验证(用户登录验证)
     *
     * @param token
     * @return
     */
    public boolean checkToken(String token) {
        return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
    }


    /**
     * Token 删除(用户登出时 ， 删除Token)
     *
     * @param token
     */
    @Override
    public void deleteToken(String token) {
        tokenMap.remove(token);
    }
}
