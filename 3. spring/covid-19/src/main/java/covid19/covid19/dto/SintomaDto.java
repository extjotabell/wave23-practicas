package covid19.covid19.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SintomaDto {
    private String nombre;

    public SintomaDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
