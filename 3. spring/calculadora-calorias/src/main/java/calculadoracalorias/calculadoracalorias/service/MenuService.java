package calculadoracalorias.calculadoracalorias.service;

import calculadoracalorias.calculadoracalorias.Exception.ArchivoNoEncontradoException;
import calculadoracalorias.calculadoracalorias.Exception.EntradaSalidaException;
import calculadoracalorias.calculadoracalorias.enity.Plato;
import calculadoracalorias.calculadoracalorias.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

     @Autowired private MenuRepository menuRepo;

    public Plato obtenerPlatilloPorNombre(String nombrePlatillo){
        return this.menuRepo.obtenerPlatilloPorNombre(nombrePlatillo);
    }

}
