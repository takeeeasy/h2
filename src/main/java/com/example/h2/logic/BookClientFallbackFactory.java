package com.example.h2.logic;

import feign.FeignException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;

public class BookClientFallbackFactory implements FallbackFactory<BookClient> {

  @Override
  public BookClient create(Throwable cause) {
    String status = cause instanceof FeignException ? Integer.toString(((FeignException) cause).status()) : "";
    String error = "cause  FeignException";
    return new BookClient() {
      @Override
      public List<String> registerBooks() {
        LoggerFactory.getLogger("feignFallbackFactory..: " + this.getClass()).error(status);
        return Arrays.asList(error, status);
      }
    };
  }
}
