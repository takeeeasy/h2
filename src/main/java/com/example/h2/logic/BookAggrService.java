package com.example.h2.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.NESTED)
public class BookAggrService {

  private final BookService bookService;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public BookAggrService(BookService bookService) {
    this.bookService = bookService;
  }

  public void registerBook() {
    this.bookService.registerBook();

    this.bookService.registerBook2();
  }
}
