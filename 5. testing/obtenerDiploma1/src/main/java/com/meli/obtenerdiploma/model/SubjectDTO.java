package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula")
    String name;

    @NotNull(message = "La nota de la materia no puede estar vacía.")
    @DecimalMin(value = "0.0", message = "La mínima nota es 0.0.")
    @DecimalMax(value = "10.0", message = "La máxima nota es 10.0.")
    Double score;
}
