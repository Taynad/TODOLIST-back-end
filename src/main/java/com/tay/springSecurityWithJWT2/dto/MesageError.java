package com.tay.springSecurityWithJWT2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class MesageError {
    private HttpStatus status;
    private String mesage;
}
