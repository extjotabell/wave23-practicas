package com.pereiravilches.Concesionaria.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data @AllArgsConstructor @NoArgsConstructor
public class ServiceDTO {
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
