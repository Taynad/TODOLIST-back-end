package com.tay.springSecurityWithJWT2.exception;

public class BusinessException extends RuntimeException{
    public BusinessException (String mesage){
        super(mesage);
    }
}
