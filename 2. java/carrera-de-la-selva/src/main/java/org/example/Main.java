package org.example;

public class Main {
    public static void main(String[] args) {

        Circuito circuitoChico = new Circuito(1,Circuito.CIRCUITO_CHICO,"2 km por selva y arroyos.");
        Circuito circuitoMedio = new Circuito(2,Circuito.CIRCUITO_MEDIO,"5 km por selva, arroyos y barro.");
        Circuito circuitoAvanzado = new Circuito(3,Circuito.CIRCUITO_AVANZADO,"10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(1,17,"Juan","Pérez","12345678");
        Participante participante4 = new Participante(4,26,"Candela","Martínez","97391645");
        Participante participante2 = new Participante(2,20,"Lucas","Fernández","87654321");
        Participante participante3 = new Participante(3,32,"Juana","López","18492745");

        Carrera carrera = new Carrera();
        //C. Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
        carrera.inscribirParticipante(participante1,circuitoChico);
        carrera.inscribirParticipante(participante2,circuitoChico);
        carrera.inscribirParticipante(participante3,circuitoMedio);
        carrera.inscribirParticipante(participante4,circuitoAvanzado);

        //D. Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        carrera.imprimirInscriptosPorCategoria(circuitoChico);

        //E. Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        carrera.eliminarInscripcionPorParticipante(participante2);

        carrera.imprimirInscriptosPorCategoria(circuitoChico);

        //F. Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        carrera.informarTotalesRecaudados();
    }
}