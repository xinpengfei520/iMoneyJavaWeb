package com.xpf.imoney.exception;

/**
 * Created by Vance on 2019/07/23 :)
 * Function:Token 过期时抛出
 */
public class TokenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    public TokenException(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
