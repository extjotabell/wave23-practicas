package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
    Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos");
    Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro");
    Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

    Participante participante1 = new Participante(1, "Pepe", "Lopez", 40300200, "H+", 21, Integer.toString(1190909076), "11808080" );
    Participante participante2 = new Participante(2, "Maria", "Lopez", 40200200, "H+", 18, Integer.toString(1190909076), "11808080" );
    Participante participante3 = new Participante(3, "Pedro", "Lopez", 40400200, "H+", 35, Integer.toString(1190909076), "11808080" );

    HashMap<Participante, Inscripcion> mapaInscripcion = new HashMap<>();
    mapaInscripcion.put(participante1, new Inscripcion(1, circuitoChico, participante1));
    mapaInscripcion.put(participante2, new Inscripcion(2, circuitoMedio, participante2));
    mapaInscripcion.put(participante3, new Inscripcion(3, circuitoAvanzado, participante3));

    mostrarParticipantesPorCategoria(mapaInscripcion, 1);
    mostrarParticipantesPorCategoria(mapaInscripcion, 2);
    mostrarParticipantesPorCategoria(mapaInscripcion, 3);

    desinscribirParticipante(mapaInscripcion, participante1);
    mostrarParticipantesPorCategoria(mapaInscripcion, 1);

    double montoCategoria1 = calcularMontoPorCategoria(mapaInscripcion, 1);
    double montoCategoria2 = calcularMontoPorCategoria(mapaInscripcion, 2);
    double montoCategoria3 = calcularMontoPorCategoria(mapaInscripcion, 3);

    System.out.println("Categoria Circuito Chico Monto="+montoCategoria1);
    System.out.println("Categoria Circuito Medio Monto="+montoCategoria2);
    System.out.println("Categoria Circuito Avanzado Monto="+montoCategoria3);

    double montoTotal = montoCategoria1 +montoCategoria2+montoCategoria3;
    System.out.println("Monto Final = "+montoTotal);
    }

    private static double calcularMontoPorCategoria(HashMap<Participante, Inscripcion> mapa, int numeroCategoria) {
        double montoFinal = 0;

        for(Map.Entry<Participante, Inscripcion> entry: mapa.entrySet()){
            if(entry.getValue().getCategoria().getId() == numeroCategoria){
                montoFinal += entry.getValue().getMontoInscripcion();
            }
        }
        return montoFinal;
    }

    private static void desinscribirParticipante(HashMap<Participante, Inscripcion> mapa, Participante participante) {
        mapa.remove(participante);
    }

    private static void mostrarParticipantesPorCategoria(HashMap<Participante, Inscripcion> mapa, int numeroCategoria) {
        System.out.println("Participantes en categoria"+ numeroCategoria);
        for(Map.Entry<Participante, Inscripcion> entry: mapa.entrySet()){
            if(entry.getValue().getCategoria().getId() == numeroCategoria){
                Participante participante = entry.getValue().getParticipante();
                System.out.println("Nro Inscripcion: "+ entry.getValue().getNumeroInscripcion()+" Participante: "+ participante.getNombre() + " " + participante.getApellido());
            }
        }
    }


}