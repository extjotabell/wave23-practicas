package com.example.seguroAutos.dto;

import com.example.seguroAutos.model.Auto;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SiniestroDto implements Serializable {
    private Long id;
    private LocalDate fechaSiniestro;
    private double perdidaEconomica;
    private Auto auto;
}
