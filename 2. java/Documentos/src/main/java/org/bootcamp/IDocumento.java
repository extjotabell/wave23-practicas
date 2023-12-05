package org.bootcamp;

public interface IDocumento {

    static String imprime(IDocumento documento){
        return documento.toString();
    }

}
