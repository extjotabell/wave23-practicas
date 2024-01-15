package com.meli.elasticsearchempleados.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeesDTO {
    private List<EmployeeDTO> employees;
}
