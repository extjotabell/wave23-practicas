package meli.bootcamp.jpa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CompraKey implements Serializable{
  private Long clienteId;
  private LocalDateTime fecha;
}
