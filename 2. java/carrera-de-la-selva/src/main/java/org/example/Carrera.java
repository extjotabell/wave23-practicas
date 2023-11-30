package org.example;

import java.util.ArrayList;

public class Carrera {
    private int totalCircuitoChico = 0;
    private int totalCircuitoMedio = 0;
    private int totalCircuitoAvanzado = 0;

    private ArrayList<Inscripcion> inscripciones = new ArrayList<>();


    public void inscribirParticipante(Participante participante,Circuito circuito){
        Inscripcion inscripcion = new Inscripcion(participante.getId(),participante,circuito);
        inscripciones.add(inscripcion);
        System.out.printf("Participante ID %d Inscripto correctamente\n",participante.getId());
    }

    public void eliminarInscripcionPorParticipante(Participante participante){
        Inscripcion inscripcion = this.buscarInscripcionPorParticipante(participante);

        if(inscripcion != null){
            inscripciones.remove(inscripcion);
            System.out.printf("Participante ID %d eliminado correctamente\n",participante.getId());
        } else {
            System.out.printf("Participante ID %d no inscripto.\n",participante.getId());
        }
    }

    private Inscripcion buscarInscripcionPorParticipante(Participante participante){
        for(Inscripcion ins: inscripciones){
            if(ins.getParticipante().getId() == participante.getId()){
                return ins;
            }
        }
        return null;
    }


    public void imprimirInscriptosPorCategoria(Circuito circuito){
        System.out.println("-----------------------");

        System.out.println("Inscripciones para la categoría " + circuito.getTipo().toUpperCase());

        for(Inscripcion ins: inscripciones){
            if(ins.getTipoCircuito().equals(circuito.getTipo())){
                ins.mostrarDatos();
            }
        }

        System.out.println("--------------------------------");
    }

    public void informarTotalesRecaudados(){

        float totalCircuitoChico = 0;
        float totalCircuitoMedio = 0;
        float totalCircuitoAvanzado = 0;
        float total;

        for(Inscripcion ins: inscripciones){
            if(ins.getTipoCircuito().equals(Circuito.CIRCUITO_CHICO)){
                totalCircuitoChico += ins.getValor();
            }
            if(ins.getTipoCircuito().equals(Circuito.CIRCUITO_MEDIO)){
                totalCircuitoMedio += ins.getValor();
            }
            if(ins.getTipoCircuito().equals(Circuito.CIRCUITO_AVANZADO)){
                totalCircuitoAvanzado += ins.getValor();
            }
        }

        total = totalCircuitoChico + totalCircuitoMedio + totalCircuitoAvanzado;

        System.out.printf("Total recaudado en %s -> %.2f\n",Circuito.CIRCUITO_CHICO.toUpperCase(),totalCircuitoChico);
        System.out.printf("Total recaudado en %s -> %.2f\n",Circuito.CIRCUITO_MEDIO.toUpperCase(),totalCircuitoMedio);
        System.out.printf("Total recaudado en %s -> %.2f\n",Circuito.CIRCUITO_AVANZADO.toUpperCase(), totalCircuitoAvanzado);
        System.out.println("Total ------------- " + total);
    }
}
