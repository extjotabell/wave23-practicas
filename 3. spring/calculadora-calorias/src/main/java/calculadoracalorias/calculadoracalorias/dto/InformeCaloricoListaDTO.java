package calculadoracalorias.calculadoracalorias.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class InformeCaloricoListaDTO {
    private HashMap<String,InformeCaloricoDTO> listado = new HashMap<>();

    public void agregar(String nombrePlatillo, InformeCaloricoDTO informe){
        this.listado.put(nombrePlatillo,informe);
    }
}
