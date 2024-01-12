package spring.relacionesjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;

}
