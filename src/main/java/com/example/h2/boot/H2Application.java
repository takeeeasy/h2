package com.example.h2.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.h2"})
@SpringBootApplication
public class H2Application {

  public static void main(String[] args) {
    SpringApplication.run(H2Application.class, args);
  }

}
