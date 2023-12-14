package meli.bootcamp.spring.learning.ej11.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewLinkResponseDto {
  private int id;
  private String password;
}
