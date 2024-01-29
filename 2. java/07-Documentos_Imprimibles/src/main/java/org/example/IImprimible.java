package org.example;
public interface IImprimible {
    static void imprimirDocumento(Documento documento){
        documento.imprimir();
    }
    void imprimirContenido();
}
