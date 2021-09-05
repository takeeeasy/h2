package com.example.h2.logic;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class Resource {

  private final BookService bookService;
  private final OrderService orderService;
  private final BookAggrService bookAggrService;

  public Resource(BookService bookService, OrderService orderService, BookAggrService bookAggrService) {
    this.bookService = bookService;
    this.orderService = orderService;
    this.bookAggrService = bookAggrService;
  }

  @GetMapping(path = "/book/list")
  public List<Book> findBooks() {
    return this.bookService.findBook();
  }

  @GetMapping(path = "/book/title")
  public List<String> findBookTitle() {
    return this.bookService.findBookTitle();
  }

  @PutMapping(path = "/book")
  public void registerBooks() {
    this.bookAggrService.registerBook();
  }

  @PutMapping(path = "/order")
  public void registerOrder() {
    this.orderService.registerBookOrder();
  }

}
