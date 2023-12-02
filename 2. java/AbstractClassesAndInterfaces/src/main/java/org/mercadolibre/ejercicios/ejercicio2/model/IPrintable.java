package org.mercadolibre.ejercicios.ejercicio2.model;

public interface IPrintable {
    void print();

    static void printContent(Document document){
        document.print();
    }

}
