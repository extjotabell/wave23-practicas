package org.example.Ej2;

public interface IImprimible {
    static void imprimir(Documento documento) {
        documento.imprimir();
    };
    void imprimirTipoDoc();
}
