package com.dayi.demo.common.exception;

/**
 * 系统异常
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-18
 */
public class SystemException extends Exception {

    private String message;

    public SystemException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
