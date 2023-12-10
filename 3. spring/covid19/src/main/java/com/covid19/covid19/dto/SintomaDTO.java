package com.covid19.covid19.dto;
import com.covid19.covid19.entify.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public final class SintomaDTO {
    private String nombre;
    private String nivelGravedad;
}
