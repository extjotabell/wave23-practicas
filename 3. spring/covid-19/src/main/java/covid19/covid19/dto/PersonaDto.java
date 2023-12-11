package covid19.covid19.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaDto{
    private String nombre;
    private String apellido;

    public PersonaDto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
