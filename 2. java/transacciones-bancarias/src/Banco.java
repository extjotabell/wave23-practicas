package org.example;

public class Banco {
    public static void main(String[] args) {
        ITransaccionable t1 = new DepositoImpl();
        ITransaccionable t2 = new TransferenciaImpl();
        ITransaccionable t3 = new RetiroDeEfectivoImpl();
        ITransaccionable t4 = new ConsultaDeSaldoImpl();
        ITransaccionable t5 = new PagoDeServiciosImpl();

        System.out.println("Cliente Basic:");
        Cliente basic = new Basic();
        basic.realizarTransaccion(t1);
        basic.realizarTransaccion(t2);
        System.out.println();

        System.out.println("Cliente Ejecutivo:");
        Cliente ejecutivo = new Ejecutivo();
        ejecutivo.realizarTransaccion(t4);
        ejecutivo.realizarTransaccion(t3);
        System.out.println();

        System.out.println("Cliente Cobrador");
        Cliente cobrador = new Cobrador();
        cobrador.realizarTransaccion(t4);
        cobrador.realizarTransaccion(t5);
        System.out.println();
    }
}