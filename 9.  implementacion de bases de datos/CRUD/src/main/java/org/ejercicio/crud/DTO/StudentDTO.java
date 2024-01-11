package org.ejercicio.crud.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    private Long id;
    private String dni;
    private String name;
    private String lastname;

    public StudentDTO(String dni, String name, String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
    }
}
