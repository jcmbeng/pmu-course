package com.ethicmedia.orderservice.exceptions;

import lombok.Getter;

import java.util.List;

public class ServiceUnavaibaleException extends RuntimeException
{
    @Getter
    private List<String> errors;

    @Getter
    private ErrorCodes errorCode;

    public ServiceUnavaibaleException(String message) {
        super(message);
    }

    public ServiceUnavaibaleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUnavaibaleException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServiceUnavaibaleException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public  ServiceUnavaibaleException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
