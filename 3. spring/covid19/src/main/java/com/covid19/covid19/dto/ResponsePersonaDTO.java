package com.covid19.covid19.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePersonaDTO {
    private List<PersonaDTO> personas;
}
