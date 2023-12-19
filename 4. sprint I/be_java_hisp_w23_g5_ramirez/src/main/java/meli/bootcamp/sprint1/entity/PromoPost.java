package meli.bootcamp.sprint1.entity;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class PromoPost extends Post{
  private double discount;

  public PromoPost(Product product, LocalDate date, Category category, double price, double discount) {
    super(product, date, category, price);
    this.discount = discount;
  }
}
