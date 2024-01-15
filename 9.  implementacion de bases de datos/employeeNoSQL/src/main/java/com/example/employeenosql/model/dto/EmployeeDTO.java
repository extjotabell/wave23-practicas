package com.example.employeenosql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private String nameEmployee;
    private String lastNameEmployee;
    private String ageEmployee;
    private String cityEmployee;
    private String provinceEmployee;
}
