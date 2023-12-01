package org.ejercicio_2;

public class Informe implements  Imprimible {
    //    Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
    private String texto;
    private int cantidad_de_paginas;
    Autor autor;
    Revisor revisor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidad_de_paginas() {
        return cantidad_de_paginas;
    }

    public void setCantidad_de_paginas(int cantidad_de_paginas) {
        this.cantidad_de_paginas = cantidad_de_paginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public Informe(String texto, int cantidad_de_paginas, Autor autor, Revisor revisor) {
        this.texto = texto;
        this.cantidad_de_paginas = cantidad_de_paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantidad_de_paginas=" + cantidad_de_paginas +
                ", autor=" + autor +
                ", revisor=" + revisor +
                '}';
    }

    @Override
    public String imprimir(){
        return "Informe: " + this.toString();
    }
}
