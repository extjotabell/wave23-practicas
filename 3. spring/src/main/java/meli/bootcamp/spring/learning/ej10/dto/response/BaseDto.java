package meli.bootcamp.spring.learning.ej10.dto.response;

import lombok.Getter;

@Getter
public class BaseDto {
  private String mensaje;
  private Boolean estado;

  public BaseDto(String mensaje, Boolean estado) {
    this.mensaje = mensaje;
    this.estado = estado;
  }

}
