package com.example.h2.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

  private final JdbcTemplate jdbcTemplate;

  public BookService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<String> findBookTitle() {
    return jdbcTemplate.query("select * from Book", (rs, rowNum) -> rs.getString("title"));
  }

  public List<Book> findBook() {
    return jdbcTemplate.query("select * from Book", new RowMapper<Book>() {

      @Override
      public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPrice(Integer.parseInt(resultSet.getString("price")));
        return book;
      }
    });

  }

  @Transactional(propagation = Propagation.NESTED)
  public void registerBook() {
    jdbcTemplate.update("insert into Book(title, author, price) values ('커서 뭐하지', '유지석', '11000')");
  }
  @Transactional(propagation = Propagation.NESTED)
  public void registerBook2() {
    jdbcTemplate.update("insert into Book(title, author, price) values ('나는 가수였다', '임재봄', '13000')");
    throw new RuntimeException("exception throwing..");
  }

}
