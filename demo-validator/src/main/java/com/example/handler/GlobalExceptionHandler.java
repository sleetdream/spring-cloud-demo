package com.example.handler;

import com.example.consts.ResultConsts;
import com.example.exception.DefaultException;
import com.example.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object ExceptionHandler(Exception ex){
        return ResultUtils.getResult(ResultConsts.SYSERR);
    }

    @ResponseBody
    @ExceptionHandler(value = DefaultException.class)
    public Object ExceptionHandler(DefaultException ex){
        return ResultUtils.getResult(ex.getCode(),ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public Object validationExceptionHandler(ValidationException ex){
        ConstraintViolationException ex1 = (ConstraintViolationException) ex;
        Set<ConstraintViolation<?>> violations = ex1.getConstraintViolations();
        String errorInfo = "";
        for(ConstraintViolation<?> item : violations){
            errorInfo = errorInfo + " " + item.getMessage();
        }
        return ResultUtils.getResult(ResultConsts.ILLGAL_PARAM.getCode(), ResultConsts.ILLGAL_PARAM.getMsg() + errorInfo);
    }
} 