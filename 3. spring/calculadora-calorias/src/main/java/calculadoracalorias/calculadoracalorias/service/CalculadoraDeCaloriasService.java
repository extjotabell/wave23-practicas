package calculadoracalorias.calculadoracalorias.service;

import calculadoracalorias.calculadoracalorias.dto.InformeCaloricoDTO;
import calculadoracalorias.calculadoracalorias.dto.InformeCaloricoListaDTO;
import calculadoracalorias.calculadoracalorias.enity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraDeCaloriasService {
    @Autowired MenuService menuService;

    public InformeCaloricoDTO obtenerInformacionCalorica(String nombre, Integer peso){
        Plato platillo = menuService.obtenerPlatilloPorNombre(nombre);
        return new InformeCaloricoDTO(
                platillo.getIngredientes(),
                platillo.ingredienteConMasCalorias(),
                platillo.getCaloriasTotales()
        );
    }

    public InformeCaloricoListaDTO obtenerInformacionCalorica(String[] platillos){
        InformeCaloricoListaDTO listado = new InformeCaloricoListaDTO();

        for(String nombrePlatillo : platillos) {
            Plato platillo = menuService.obtenerPlatilloPorNombre(nombrePlatillo);
            if(platillo != null){
                InformeCaloricoDTO informe = new InformeCaloricoDTO(
                        platillo.getIngredientes(),
                        platillo.ingredienteConMasCalorias(),
                        platillo.getCaloriasTotales()
                );
                listado.agregar(platillo.getNombre(),informe);
            }
        }

        return listado;
    }
}
