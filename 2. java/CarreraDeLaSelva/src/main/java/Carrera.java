import java.util.HashMap;
import java.util.Map;

public class Carrera {
    Map<Integer, Categoria> categorias = new HashMap<>();

    public void agregarCategoria(Categoria categoria){
        categorias.put(categoria.id, categoria);
    }

    public double calcularTotal(){
        double total = 0;
        for(Map.Entry<Integer, Categoria> entry:categorias.entrySet()){
            total += entry.getValue().calcularCosto();
        }
        return total;
    }

    public double calcularCostoCategoria(int id){
        return categorias.get(id).calcularCosto();
    }

    public void inscribirParticipante(int idCategoria, Participante participante){
        Categoria categoria = categorias.get(idCategoria);
        if(categoria.nombre.equals("Circuito avanzado") && participante.edad <18){
            System.out.println("No se permite la inscripcion de menores en circuito avanzado\n");
            return;
        }
        if(participante.inscripcion!=null){
            System.out.println("El participante ya se encuentra inscrito en el " + categoria.nombre+"\n");
            return;
        }
        categoria.inscribirParticipante(participante);
        System.out.println("Se ha inscripto al participante en el "+categoria.nombre+"\n");
    }

    public void desinscribirParticipante(Participante participante){
        participante.inscripcion.categoria.inscripciones.remove(participante.inscripcion);
        participante.inscripcion=null;
        System.out.println("Se ha retirado el participante de la carrera\n");
    }

    public void participantesCategoria(int id){
        categorias.get(id).imprimirParticipantes();;
    }
}
