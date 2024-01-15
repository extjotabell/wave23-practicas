package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    @Column(name = "sale_total")
    private Double saleTotal;
    @Column(name = "payment_method")
    private String paymentMethod;
    @ManyToMany
    @JoinTable(
            name = "sale_clothe",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "clothe_id")
    )
    private List<Clothe> clothes;

    public Sale(LocalDate date, Double saleTotal, String paymentMethod, List<Clothe> clothes) {
        this.date = date;
        this.saleTotal = saleTotal;
        this.paymentMethod = paymentMethod;
        this.clothes = clothes;
    }
}
