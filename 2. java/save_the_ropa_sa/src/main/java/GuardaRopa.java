import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    static Integer idCounter = 0;
    static Map<Integer, List<Prenda>> prendas = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(++idCounter, listaDePrenda);
        return idCounter;
    }

    public void mostrarPrendas(){
        prendas.forEach((k, v) -> System.out.println("- " + k + ": " + v));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.remove(numero);
    }
}
