package com.tay.springSecurityWithJWT2.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException (String mesage){
        super(mesage);
    }
}
