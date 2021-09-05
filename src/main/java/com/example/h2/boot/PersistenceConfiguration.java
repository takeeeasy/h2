package com.example.h2.boot;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PersistenceConfiguration {

  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String username;
  @Value("${spring.datasource.password}")
  private String password;
  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Primary
  @Bean(name = "dataSource")
  public DataSource primaryDatasource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(url);
    config.setUsername(username);
    config.setPassword(password);
    config.setDriverClassName(driverClassName);

    return new HikariDataSource(config);
  }

  @Primary
  @Bean(name = "transactionManager")
  public PlatformTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}
