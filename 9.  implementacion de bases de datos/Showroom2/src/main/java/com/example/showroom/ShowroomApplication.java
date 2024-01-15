package com.example.showroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ShowroomApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShowroomApplication.class, args);
  }

}
