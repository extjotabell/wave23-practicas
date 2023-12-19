package meli.bootcamp.sprint1.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
  @JsonAlias("post_id")
  private int id;
  private static int nextId = 0;
  private Product product;
  private LocalDate date;
  private Category category;
  private double price;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private boolean has_promo;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private double discount;

  public Post(Product product, LocalDate date, Category category, double price, boolean hasPromo, double discount) {
    this.id = ++nextId;
    this.product = product;
    this.date = date;
    this.category = category;
    this.price = price;
    this.has_promo = hasPromo;
    this.discount = discount;
  }
}
