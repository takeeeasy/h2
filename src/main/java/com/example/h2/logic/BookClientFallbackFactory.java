package com.example.h2.logic;

import feign.FeignException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class BookClientFallbackFactory implements FallbackFactory<BookClient> {

  private final BookClientFallBack bookClientFallBack;

  public BookClientFallbackFactory() {
    this.bookClientFallBack = new BookClientFallBack();
  }

  @Override
  public BookClient create(Throwable cause) {
    LoggerFactory.getLogger(this.getClass()).error("[BookClientFallbackFactory call..: " + cause.getMessage());
    return bookClientFallBack;
  }

  public class BookClientFallBack implements BookClient {

    @Override
    public List<String> registerBooks() {
      LoggerFactory.getLogger(this.getClass()).error("[BookClientFallback call..: ");
      return null;
    }
  }

}
