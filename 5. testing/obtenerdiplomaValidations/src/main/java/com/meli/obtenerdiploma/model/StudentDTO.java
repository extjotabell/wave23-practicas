package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

// @Valid Activa la validación total del elemento, es decir, validará en cascada todos los atributos del objeto señalado
//la anotación @valid también está en el controller, antes de @requestParam
@Getter @Setter @Valid
public class StudentDTO {
    @NotEmpty(message = "El nombre del estudiante no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con una mayúscula")
    @Size(max = 50, message = "La longitud del nombre no debe superar los 50 caracteres")
    String studentName;
    String message;
    double averageScore;
    @NotEmpty(message = "La lista no puede ser vacía")
    List<@Valid SubjectDTO> subjects;
}