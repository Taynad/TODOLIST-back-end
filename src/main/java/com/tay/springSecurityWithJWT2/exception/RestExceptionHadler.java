package com.tay.springSecurityWithJWT2.exception;

import com.tay.springSecurityWithJWT2.dto.MesageError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHadler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<MesageError> BusinessExceptionHandler(BusinessException exception){
        MesageError mesageError = new MesageError(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mesageError);
    }

    @ExceptionHandler(TaskIsNullException.class)
    public ResponseEntity<MesageError> TaskIsNullExceptionHandler (TaskIsNullException exception){
        MesageError mesageError = new MesageError(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mesageError);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<MesageError> TaskNotFoundExceptionHandler (TaskNotFoundException exception){
        MesageError mesageError = new MesageError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mesageError);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MesageError> UserNotFoundExceptionHandler(UserNotFoundException exception){
        MesageError mesageError = new MesageError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mesageError);
    }
}
