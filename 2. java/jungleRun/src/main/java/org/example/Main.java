package org.example;

public class Main {
    public static void main(String[] args) {
        Career career = new Career();
        Integer idCategory = 1;
        // Validar los repetidos en el set como parametro el participante

        // Point A
        executePointA(career);

        // Point B and C
        System.out.println("----------------- POINT B AND C -----------------");
        executePointBC result = getExecutePointBAndC();
        career.registerParticipant(result.tomasv(), 1);
        career.registerParticipant(result.sofiv(), 2);
        career.registerParticipant(result.lautic(), 3);

        System.out.println("EMPIEZA EL TEST");
        System.out.println(career.getParticipants());
        System.out.println("TERMINA EL TEST");

        // Point D
        executePointD(career, idCategory);

        // Point E
        executePointE(career, result.tomasv());

        // Point F
        executePointF(career);

    }

    private static void executePointF(Career career) {
        System.out.println("----------------- POINT F -----------------");
        System.out.println(career.calculateTotalAmountPerCategory());
    }

    private static void executePointE(Career career, Participant participant) {
        System.out.println("----------------- POINT E -----------------");
        career.unsuscribeParticipant(participant);
        //System.out.println(career.getParticipants());
    }

    private static void executePointD(Career career, Integer idCategory) {
        System.out.println("----------------- POINT D -----------------");
        System.out.println(career.getParticipants(idCategory));
    }

    private static executePointBC getExecutePointBAndC() {
        Participant tomasv = new Participant(43735806, "Tomas", "Vazquez", 22, 1132495377, 1162555707, "A+");
        Participant sofiv = new Participant(45700800, "Sofia", "Vega", 19, 1132324545, 1162555707, "0+");
        Participant lautic = new Participant(43735888, "Lautaro", "Carpentieri", 21, 1167678989, 1162555707, "B+");
        executePointBC result = new executePointBC(tomasv, sofiv, lautic);
        return result;
    }

    private record executePointBC(Participant tomasv, Participant sofiv, Participant lautic) {
    }

    private static void executePointA(Career career) {
        System.out.println("----------------- POINT A -----------------");
        career.addCategory(1, new Category("Circuito chico", "2 km por selva y arroyo", 1300, 1500));
        career.addCategory(2, new Category("Circuito medio", "5 km por selva, arroyos y barro.", 2000, 2300));
        career.addCategory(3, new Category("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 0, 2800));
    }
}


