package meli.demoW23Dto.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonaDto {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;


}
