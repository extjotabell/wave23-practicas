package calculadoracalorias.calculadoracalorias.repository;

import calculadoracalorias.calculadoracalorias.Exception.ArchivoNoEncontradoException;
import calculadoracalorias.calculadoracalorias.Exception.EntradaSalidaException;
import calculadoracalorias.calculadoracalorias.Exception.IngredienteNoEncontradoException;
import calculadoracalorias.calculadoracalorias.enity.Ingrediente;
import calculadoracalorias.calculadoracalorias.enity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuRepository {
    private ArrayList<Plato> platillos = new ArrayList<>();

    IngredienteRepository ingredienteRepository = new IngredienteRepository();

    public MenuRepository() throws ArchivoNoEncontradoException, EntradaSalidaException {
        try {
            Ingrediente harina = ingredienteRepository.obtenerIngredientePorNombre("Harina de trigo refinada");
            Ingrediente salsa = ingredienteRepository.obtenerIngredientePorNombre("Salsa de tomate en conserva");
            Ingrediente queso = ingredienteRepository.obtenerIngredientePorNombre("Queso mozzarella");
            Ingrediente aceituna = ingredienteRepository.obtenerIngredientePorNombre("Aceitunas verdes");
            Plato pizza = new Plato("Pizza",List.of(harina,salsa,queso,aceituna));
            this.platillos.add(pizza);
        } catch (IngredienteNoEncontradoException e) {
            System.out.println(e.getMessage() + " Para crear el plato PIZZA");
        }

        try{
            Ingrediente pollo = ingredienteRepository.obtenerIngredientePorNombre("Pollo");
            Ingrediente lechuga = ingredienteRepository.obtenerIngredientePorNombre("Lechuga");
            Ingrediente tomate = ingredienteRepository.obtenerIngredientePorNombre("Tomates");
            Ingrediente aceite = ingredienteRepository.obtenerIngredientePorNombre("Aceite de oliva");
            Plato polloConEnsalada = new Plato("Pollo con ensalada", List.of(pollo, lechuga, tomate, aceite));
            this.platillos.add(polloConEnsalada);
        } catch (IngredienteNoEncontradoException e) {
            System.out.println(e.getMessage() + " Para crear el plato POLLO CON ENSALADA");
        }

        try {
            Ingrediente merluza = ingredienteRepository.obtenerIngredientePorNombre("Merluza");
            Ingrediente papas = ingredienteRepository.obtenerIngredientePorNombre("Papas cocidas");
            Plato merluzaConPure = new Plato("Merluza con puré", List.of(merluza, papas));
            this.platillos.add(merluzaConPure);
        } catch (IngredienteNoEncontradoException e) {
            System.out.println(e.getMessage() + " Para crear el plato MERLUZA CON PURE");
        }
    }

    public Plato obtenerPlatilloPorNombre(String nombre) {

        for (Plato platillo : platillos){
            if(platillo.getNombre().equals(nombre)){
                return platillo;
            }
        }

        return null;
    }
}
