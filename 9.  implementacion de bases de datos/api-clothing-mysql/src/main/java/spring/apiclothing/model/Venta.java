package spring.apiclothing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private LocalDate fecha;
    private Double total;
    @Column(name = "medio_de_pago")
    private String medioDePago;
    @ManyToMany
    @JoinTable(
            name = "venta_prendas",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id")
    )
    @Column(name = "lista_de_prendas")
    private List<Prenda> listaDePrendas = new ArrayList<>();

    public void addPrenda(Prenda prenda){
        listaDePrendas.add(prenda);
    };

    public Double calcularTotal(){
        return listaDePrendas.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Prenda::getPrecio_venta)
                .sum();
    }
}
