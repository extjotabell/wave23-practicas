package practica.Banco;

public class Banco {
    public static void main(String[] args) {
        ITransaccionable t1 = new Deposito();
        ITransaccionable t2 = new Transferencia();
        ITransaccionable t3 = new RetiroDinero();
        ITransaccionable t4 = new ConsultaSaldo();
        ITransaccionable t5 = new PagoServicios();

        System.out.println("Cliente Basic:");
        Cliente basic = new Basic();
        basic.realizarOperacion(t1);
        basic.realizarOperacion(t2);
        System.out.println();

        System.out.println("Cliente Ejecutivo:");
        Cliente ejecutivo = new Ejecutivo();
        ejecutivo.realizarOperacion(t4);
        ejecutivo.realizarOperacion(t3);
        System.out.println();

        System.out.println("Cliente Cobrador");
        Cliente cobrador = new Cobrador();
        cobrador.realizarOperacion(t4);
        cobrador.realizarOperacion(t5);
        System.out.println();
    }
}
