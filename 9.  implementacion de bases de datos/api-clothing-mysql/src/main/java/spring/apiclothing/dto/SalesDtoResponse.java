package spring.apiclothing.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SalesDtoResponse {
    private Long numero;
    private LocalDate fecha;
    private String medioDePago;
    private Double total;
    private List<ClothingDto> listaDePrendas;
}
