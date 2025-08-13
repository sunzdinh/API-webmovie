package com.project.webmovie.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(ApiException.class)
     ResponseEntity<Map<String, Object>> handlingApiException(ApiException exception){
         Map<String, Object> error = new HashMap<>();
         error.put("timestamp", LocalDateTime.now());
         error.put("status", exception.getStatusCode());
         error.put("message", exception.getMessage());
         return ResponseEntity.status(exception.getStatusCode()).body(error);
     }



    @ExceptionHandler(value=RuntimeException.class)
    ResponseEntity<String> handlingRuntimeException(RuntimeException exception){
        return ResponseEntity.badRequest().body(exception.getMessage()); //badRequest() là lỗi 400 từ ng dùng
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingValidation (MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(e.getFieldError().getDefaultMessage());
    }
}
