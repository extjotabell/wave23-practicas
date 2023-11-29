import java.util.ArrayList;
import java.util.List;

public class Categoria {
    int id;
    String nombre;
    String descripcion;
    double costoMenores;
    double costoMayores;
    List<Inscripcion> inscripciones;

    public Categoria(int id, String nombre, String descripcion,
                     double costoMenores, double costoMayores) {
        inscripciones=new ArrayList<>();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMayores=costoMayores;
        this.costoMenores=costoMenores;
    }

    public void inscribirParticipante(Participante participante){
        if(participante.inscripcion!=null){
            return;
        }
        Inscripcion inscripcion = new Inscripcion(this, participante);
        inscripciones.add(inscripcion);
        participante.inscripcion=inscripcion;
    }

    public double calcularCosto(){
        double costo = 0;
        for(Inscripcion inscripcion:inscripciones){
            costo+=inscripcion.monto;
        }
        return costo;
    }

    public void imprimirParticipantes(){
        System.out.println("Los participantes de la categoria " + nombre+ " son: ");
        for (Inscripcion inscripcion:inscripciones){
            System.out.println(inscripcion.participante);
        }
        System.out.println();
    }
}
