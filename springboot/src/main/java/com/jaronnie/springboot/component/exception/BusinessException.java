package com.jaronnie.springboot.component.exception;

public class BusinessException extends BaseException {
    private static final long serialVersionUID = 78377774639246342L;

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }

    public BusinessException(int code, String message) {
        super(code, message);
    }
}
