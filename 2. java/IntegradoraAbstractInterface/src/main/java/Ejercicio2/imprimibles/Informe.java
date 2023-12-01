package Ejercicio2.imprimibles;

import Ejercicio2.Imprimible;

public class Informe implements Imprimible {
    private String texto;
    private int cantPaginas;
    private String revisor;

    public Informe(String texto, int cantPaginas, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.revisor = revisor;
    }



    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
