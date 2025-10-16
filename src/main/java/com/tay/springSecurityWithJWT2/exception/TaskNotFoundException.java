package com.tay.springSecurityWithJWT2.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException (String mesage){
        super(mesage);
    }
}
