package org.example;

public interface Imprimible {
    void imprimir();

    static void imprimirDoc(Documento doc) {
        doc.imprimir();
    }
}
