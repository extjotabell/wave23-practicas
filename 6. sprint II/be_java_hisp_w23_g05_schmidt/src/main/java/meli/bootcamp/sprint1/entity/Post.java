package meli.bootcamp.sprint1.entity;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonAlias;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Post {
  @JsonAlias("post_id")
  private int id;
  private static int nextId = 0;
  private Product product;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate date;
  private Category category;
  private double price;

  public Post(Product product, LocalDate date, Category category, double price) {
    this.id = ++nextId;
    this.product = product;
    this.date = date;
    this.category = category;
    this.price = price;
  }
}