package com.tay.springSecurityWithJWT2.exception;

public class TaskIsNullException extends RuntimeException{
    public TaskIsNullException (String mesage){
        super(mesage);
    }
}
