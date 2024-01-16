package com.mercadolibre.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "venta", schema = "showroom_db", catalog = "")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer numero;
    private LocalDate fecha;
    private Double total;
    private String medio_pago;

    @ManyToMany
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "numero"),
            inverseJoinColumns = @JoinColumn(name = "codigo")
    )
    private List<Prenda> prendas;

}
