package org.example;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Ejecutivo("Maria");
        Cliente cliente2 = new Basic("Juan");

        cliente1.realizarDeposito(); // Puede realizar la operacion
        cliente1.realizarConsultaSaldo(); // Devuelve correctamente la excepcion

        cliente2.realizarRetiroEfectivo(); // Puede realizar la operacion
        cliente2.realizarDeposito();// Devuelve correctamente la excepcion
    }
}