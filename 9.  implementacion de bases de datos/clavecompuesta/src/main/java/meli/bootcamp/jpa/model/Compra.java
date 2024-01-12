package meli.bootcamp.jpa.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(value = CompraKey.class)
public class Compra {
  @Id
  private Long clienteId;

  @Id
  private LocalDateTime fecha;

  @Column
  private Double precio;
}
