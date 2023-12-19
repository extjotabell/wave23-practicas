package meli.bootcamp.sprint1.entity;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Post {
  @JsonAlias("post_id")
  private int id;
  private static int nextId = 0;
  private Product product;
  private LocalDate date;
  private Category category;
  private double price;
  private Boolean has_promo;
  private Double discount;

  public Post(Product product, LocalDate date, Category category, double price) {
    this.id = ++nextId;
    this.product = product;
    this.date = date;
    this.category = category;
    this.price = price;
  }

  public Post(Product product, LocalDate date, Category category, double price, Boolean has_promo, Double discount) {
    this.id = ++nextId;
    this.product = product;
    this.date = date;
    this.category = category;
    this.price = price;
    this.has_promo = has_promo;
    this.discount = discount;
  }

}
