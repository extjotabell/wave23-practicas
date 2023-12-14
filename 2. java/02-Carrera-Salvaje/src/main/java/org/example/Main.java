package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria(1, "Circuito chico","chico" );
        Categoria categoria2 = new Categoria(2, "Circuito medio","medio" );
        Categoria categoria3 = new Categoria(3, "Circuito avanzadp","avanzado" );

        Participante participante1 = new Participante(1, "Rodrigo", 18);
        Participante participante2 = new Participante(2, "Josue", 20);
        Participante participante3 = new Participante(3, "Tania", 12);
        Participante participante4 = new Participante(4, "Rodrigo", 40);

        Inscripcion carrera1 = new Inscripcion(1,categoria1,participante1);
        Inscripcion carrera2 = new Inscripcion(2,categoria2,participante2);
        Inscripcion carrera3 = new Inscripcion(3,categoria3,participante4);
        Inscripcion carrera4 = new Inscripcion(4,categoria3,participante3);



    }
}