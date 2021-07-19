package com.itheima.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Classname HandlerControllerException
 * @Date 2021/7/16 14:59
 * @Created by GAEA
 */
@ControllerAdvice
public class HandlerControllerException {

    @ExceptionHandler(RuntimeException.class)
    public String handException(RuntimeException e) {
        if (e instanceof AccessDeniedException) {
            return "redirect:/403.jsp";
        }
        return "redirect:/500.jsp";
    }
}
