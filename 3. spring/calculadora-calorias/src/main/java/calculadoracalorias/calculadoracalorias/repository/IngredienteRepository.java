package calculadoracalorias.calculadoracalorias.repository;

import calculadoracalorias.calculadoracalorias.Exception.ArchivoNoEncontradoException;
import calculadoracalorias.calculadoracalorias.Exception.EntradaSalidaException;
import calculadoracalorias.calculadoracalorias.Exception.IngredienteNoEncontradoException;
import calculadoracalorias.calculadoracalorias.enity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredienteRepository {

    private List<Ingrediente> ingredientes = new ArrayList<>();

    public IngredienteRepository() throws ArchivoNoEncontradoException, EntradaSalidaException {
        this.cargarIngredientes();
    }



    private void cargarIngredientes() throws ArchivoNoEncontradoException, EntradaSalidaException {
        try {
            File file = ResourceUtils.getFile("src/main/resources/food.json");
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
            this.ingredientes = objectMapper.readValue(file, typeRef);
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoException("Archivo 'food.json' no encontrado");
        } catch (IOException e){
            throw new EntradaSalidaException("Error al cargar los datos del archivo 'food.json'. " + e.getMessage());
        }
    }

    public Ingrediente obtenerIngredientePorNombre(String nombre) throws IngredienteNoEncontradoException {

        for(Ingrediente ingrediente: ingredientes) {
            if(ingrediente.getName().equals(nombre)){
                return ingrediente;
            }
        }

        throw new IngredienteNoEncontradoException("Ingrediente " + nombre + " no encnontrado");
    }
}
