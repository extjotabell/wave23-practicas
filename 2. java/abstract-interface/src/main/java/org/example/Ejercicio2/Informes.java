package org.example.Ejercicio2;

public class Informes {
    String texto;
    int paginas;
    String autor;
    String revisor;

    @Override
    public String toString() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
