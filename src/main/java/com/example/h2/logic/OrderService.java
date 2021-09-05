package com.example.h2.logic;

import com.google.gson.Gson;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableFeignClients
@Transactional(propagation = Propagation.REQUIRED)
public class OrderService {

  private final BookClient bookClient;
  private final JdbcTemplate jdbcTemplate;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public OrderService(BookClient bookClient, JdbcTemplate jdbcTemplate) {
    this.bookClient = bookClient;
    this.jdbcTemplate = jdbcTemplate;
  }

  public void registerBookOrder() {
    this.jdbcTemplate.update("insert into orders(book_title, author, price) values ('기차 타고 부산에서 런던까지', '정은주', 12150)");

    Object response =  this.bookClient.registerBooks();
    logger.info("response..|" + new Gson().toJson(response));
  }
}
