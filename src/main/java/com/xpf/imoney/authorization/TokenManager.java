package com.xpf.imoney.authorization;

/**
 * Created by Vance on 2019/07/23 :)
 * Function:REST 鉴权，登录用户的身份鉴权
 */
public interface TokenManager {

    String createToken(String username);

    boolean checkToken(String token);

    void deleteToken(String token);
}
