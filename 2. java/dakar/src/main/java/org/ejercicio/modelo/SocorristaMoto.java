package org.ejercicio.modelo;

public class SocorristaMoto extends Vehiculo{

    public SocorristaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Moto moto){
        System.out.println("Socorriendo moto!!!!!" +  moto.getPatente());
    }
}
