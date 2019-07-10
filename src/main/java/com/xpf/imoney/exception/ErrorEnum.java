package com.xpf.imoney.exception;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:错误枚举类
 */
public enum ErrorEnum {

    UNKNOWN_EXCEPTION(0),
    UN_AUTHORIZATION(10001, "un authorization"),
    PARAMS_ERROR(10002, "params valid %s"),
    INVALID_TOKEN(10003, "invalid token"),
    USERNAME_OR_PASSWORD_ERROR(10004, "username or password error"),
    PAGE_NOT_FOUND(10005, "page not found"),
    SINGLE_USER_ERROR(10006, "has user, can't add more"),
    USER_ACCESS_NOT_INIT(10007, "user access not init"),
    NO_ENABLE_EMAIL_CONFIG(10008, "no enable email-config"),
    SEND_EMAIL_FAILED(10009, "send email failed: %s"),
    USER_INIT_API_REFUSE(10010, "this api user init use only"),
    INVALID_EMAIL_CODE(10011, "invalid email code"),
    INVALID_PARAMS(10012, "invalid params: %s");

    private int code;
    private String msg;
    private static final String DEFAULT_EXCEPTION = "Unknown exception";

    ErrorEnum(int code) {
        this.code = code;
        this.msg = DEFAULT_EXCEPTION;
    }

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
