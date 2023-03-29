package com.softarex.domas.virtual_classroom.exception.handler;

import com.softarex.domas.virtual_classroom.exception.StudentExistException;
import com.softarex.domas.virtual_classroom.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StudentRestControllerExceptionHandler {

    @ExceptionHandler(value = {StudentExistException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, String> handleStudentExistException(final StudentExistException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("internalServerError", ex.getMessage());
        return map;
    }

    @ExceptionHandler(value = {StudentNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, String> handleStudentNotFoundException(final StudentNotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("internalServerError", ex.getMessage());
        return map;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> map = new HashMap<>();
        methodArgumentNotValidException
                .getFieldErrors()
                .forEach(fieldError -> map.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String, String> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        Map<String, String> map = new HashMap<>();
        constraintViolationException
                .getConstraintViolations()
                .forEach(violation -> map.put(violation.getPropertyPath().toString(), violation.getMessage()));
        return map;
    }

}
