package com.example.h2.logic;

import feign.FeignException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FeignExceptionHandler {

  @ExceptionHandler(FeignException.class)
  public String handleFeignException(FeignException e, HttpServletResponse response) {
    response.setStatus(e.status());
    return "\"cause......reason....\"";
  }
}
