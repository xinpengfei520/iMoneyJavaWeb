package com.xpf.imoney.exception;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:MapperException
 */
public class MapperException extends RuntimeException {

    private static final long serialVersionUID = -7254247085051846435L;
    private int code;
    private String msg;

    /**
     * Constructor
     */
    public MapperException(String message) {
        super(message);
    }

    public MapperException(Throwable cause) {
        super(cause);
    }

    public MapperException(String message, Throwable cause) {
        super(message);
    }

    public MapperException() {
        this(ErrorEnum.UNKNOWN_EXCEPTION);
    }

    public MapperException(ErrorEnum code) {
        code = (code == null) ? ErrorEnum.UNKNOWN_EXCEPTION : code;
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public MapperException(ErrorEnum code, String exMsg) {
        this(code);
        this.msg = String.format(code.getMsg(), exMsg);
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public int getCode() {
        return code;
    }

}
