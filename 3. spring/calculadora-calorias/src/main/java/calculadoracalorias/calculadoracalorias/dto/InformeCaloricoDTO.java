package calculadoracalorias.calculadoracalorias.dto;

import calculadoracalorias.calculadoracalorias.enity.Ingrediente;
import lombok.Data;

import java.util.List;

@Data
public class InformeCaloricoDTO {
    private int caloriasTotales;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteConMasCalorias;

    public InformeCaloricoDTO(List<Ingrediente> ingredientes, Ingrediente ingredienteConMasCalorias, int caloriasTotales) {
        this.ingredientes = ingredientes;
        this.ingredienteConMasCalorias = ingredienteConMasCalorias;
        this.caloriasTotales = caloriasTotales;
    }
}
