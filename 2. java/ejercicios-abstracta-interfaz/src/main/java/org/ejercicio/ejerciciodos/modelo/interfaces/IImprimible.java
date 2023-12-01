package org.ejercicio.ejerciciodos.modelo.interfaces;

import org.ejercicio.ejerciciodos.modelo.impl.Documento;

public interface IImprimible {
    void imprimir();
    static void imprimirContenido(Documento documento){

    }
}
