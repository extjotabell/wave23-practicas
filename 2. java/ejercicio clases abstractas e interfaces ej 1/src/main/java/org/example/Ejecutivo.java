package org.example;

public class Ejecutivo extends Cliente{
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarRetiroEfectivo() {
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.noTransaccionOk();
    }
    @Override
    public void realizarConsultaSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.noTransaccionOk();
    }

    @Override
    public  void realizarPagoServicios(){
        PagoServicios pagoServicios = new PagoServicios();
        pagoServicios.noTransaccionOk();
    }


}
