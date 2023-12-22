package com.demospring.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlumnoDTO {

    @Size(min = 7, max = 8, message = "El DNI no puede tener menos de 7 caracteres ni mas de 8")
    @Pattern(regexp = "[0-9]*$", message= "El DNI solo puede tener caracateres numericos")
    private String dni;

    @Size(min = 3, max = 100, message = "El nombre no puede tener menos de 3 caracteres ni mas de 100")
    private String name;

    @PastOrPresent(message = "La fecha de nacimiento no puede ser mayor a la fecha de hoy")
    private LocalDate birthDate;

    @PositiveOrZero(message = "La edad no puede ser un numero negativo")
    @Max(value = 120, message = "La edad no puede ser mayor a 120")
    private Integer age;

    @NotEmpty(message = "La lista de materias no puede estar vacia")
    private List<@Valid MateriaDTO> materiasList;
}
