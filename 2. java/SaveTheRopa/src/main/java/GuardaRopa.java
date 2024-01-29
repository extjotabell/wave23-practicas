import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaRopas;
    private static int count = 1;
    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        int indice = count++;
        guardaRopas.put(indice,listaDePrendas);
        return indice;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry:guardaRopas.entrySet()){
            System.out.println("ID = " + entry.getKey());
            System.out.println("Prendas = " + entry.getValue());
        }
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return guardaRopas.get(numero);
    }

    public GuardaRopa() {
        guardaRopas= new HashMap<>();
    }
}