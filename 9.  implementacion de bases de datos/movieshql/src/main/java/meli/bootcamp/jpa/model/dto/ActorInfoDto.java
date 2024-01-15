package meli.bootcamp.jpa.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ActorInfoDto {
  private String firstName;
  private String lastName;
  private BigDecimal rating;
}
