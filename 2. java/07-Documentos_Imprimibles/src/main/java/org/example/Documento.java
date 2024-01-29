package org.example;

public abstract class Documento implements IImprimible{
    public abstract void imprimir();

    @Override
    public void imprimirContenido() {
        System.out.println("-----" + getClass().getSimpleName().toUpperCase() + "-----");
    }

    public abstract void imprimirTipoDocumento();
}
