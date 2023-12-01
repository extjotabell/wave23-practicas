package org.ejercicio.ejerciciodos.modelo.interfaces;

import org.ejercicio.ejerciciodos.modelo.impl.Documento;

public interface IImprimirContenido {

    static void imprimirContenido(Documento documento){
        documento.imprimir();
        System.out.println();
    }
}
