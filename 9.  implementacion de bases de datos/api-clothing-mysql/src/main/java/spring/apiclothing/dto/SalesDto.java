package spring.apiclothing.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SalesDto {
    private LocalDate fecha;
    private String medioDePago;
    private List<Long> listaDePrendas;
}
