public class Main{
    public static void main(String[] args) {

        Carrera carrera = new Carrera();
        carrera.agregarCategoria(new Categoria(1,
                "Circuito chico", "2 km por selva y arroyos",
                1300,1500));
        carrera.agregarCategoria(new Categoria(2,
                "Circuito medio", "5 km por selva, arroyos y barro",
                2000,2300));
        carrera.agregarCategoria(new Categoria(3,
                "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra",
                0,2800));

        Participante p1 = new Participante("44967716", "Felipe", "Costa", 20,"1167081366", "42381293", "A+");
        Participante p2 = new Participante("44967212", "Marcos", "Gutierrez", 17,"1167081321", "42381291", "A+");
        Participante p3 = new Participante("44967212", "Juan", "Gonzales", 27,"1167324321", "42381291", "A+");
        Participante p4 = new Participante("23967252", "Lucas", "Perez", 31,"1167324321", "42381291", "A+");

        carrera.inscribirParticipante(1,p1);
        carrera.inscribirParticipante(3,p2);
        carrera.inscribirParticipante(2,p2);
        carrera.inscribirParticipante(3,p3);
        carrera.inscribirParticipante(3,p3);
        carrera.inscribirParticipante(3,p4);

        carrera.participantesCategoria(3);

        carrera.desinscribirParticipante(p4);

        carrera.participantesCategoria(3);

        System.out.println("Monto total recaudado por cada categoria:");
        System.out.println("Categoria 1: " + carrera.calcularCostoCategoria(1) );
        System.out.println("Categoria 2: " + carrera.calcularCostoCategoria(2) );
        System.out.println("Categoria 3: " + carrera.calcularCostoCategoria(3) );

        System.out.println();
        System.out.println("Monto total recaudado: " + carrera.calcularTotal());
    }
}
