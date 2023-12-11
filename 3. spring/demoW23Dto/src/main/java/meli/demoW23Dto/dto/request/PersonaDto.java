package meli.demoW23Dto.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonaDto {
    private String nombre;
    private String apellido;
    private int edad;
}
