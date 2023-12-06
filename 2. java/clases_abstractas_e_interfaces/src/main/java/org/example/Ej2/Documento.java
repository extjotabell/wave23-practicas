package org.example.Ej2;

public abstract class Documento implements IImprimible {


    public abstract void imprimir();

    @Override
    public void imprimirTipoDoc() {
        System.out.println(getClass().getSimpleName() + " : ");
    }
}
