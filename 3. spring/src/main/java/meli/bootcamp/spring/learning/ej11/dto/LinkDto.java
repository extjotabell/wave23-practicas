package meli.bootcamp.spring.learning.ej11.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinkDto {
  private String id;
  private String url;
  private String password;
}
