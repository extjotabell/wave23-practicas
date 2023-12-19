package meli.bootcamp.sprint1.dto.request;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class NewPromoPostDto extends NewPostDto {
  public NewPromoPostDto(int user_id, LocalDate date, NewProductDto product, int category, double price,
      boolean has_promo, double discount) {
    super(user_id, date, product, category, price);
    this.has_promo = has_promo;
    this.discount = discount;
  }

  private boolean has_promo;
  private double discount;
}
