package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.validation.Valid;
import javax.validation.constraints.*;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max = 50, message = "El nombre no puede ser más grande de 50 caracteres")
    @NotBlank(message = "No puede ser vacío el nombre del estudiante")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "El alumno debe estar inscrito en al menos una materia")
    List<@Valid SubjectDTO> subjects;
}
