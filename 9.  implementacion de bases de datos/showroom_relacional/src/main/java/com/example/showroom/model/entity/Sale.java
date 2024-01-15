package com.example.showroom.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer number;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private double total;
    private String paidMethod;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "sales_cloth",
            joinColumns = @JoinColumn(name = "sales_id"),
            inverseJoinColumns = @JoinColumn(name = "cloth_id")
    )
    private List<Cloth> cloths;
}
