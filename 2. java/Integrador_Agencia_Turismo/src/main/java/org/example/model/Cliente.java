package org.example.model;

public class Cliente implements Model {
    private String id;
    private String nombre;
    private ReservasRepository reservas;

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        reservas = new ReservasRepository();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ReservasRepository getReservas() {
        return reservas;
    }

    public void setReservas(ReservasRepository reservas) {
        this.reservas = reservas;
    }

    public Decorator agregarReserva(Reserva reserva){
        DescuentoReserva descuento = new DescuentoReserva(reserva, 0);
        if(getReservas().cantidadReservas()>=2){
            descuento = new DescuentoReserva(descuento,0.05);
        }
        if(reserva.getTipoReserva().equals(TipoReserva.PAQUETE_COMPLETO)){
            descuento = new DescuentoReserva(descuento, 0.1);
        }
        if(reserva instanceof Paquete){
            long cantidadHoteles = ((Paquete) reserva).getReservas().stream().filter(reserva1 -> reserva1.getTipoReserva().equals(TipoReserva.HOTEL)).count();
            long cantidadBoletos= ((Paquete) reserva).getReservas().stream().filter(reserva1 -> reserva1.getTipoReserva().equals(TipoReserva.BOLETO)).count();
            if(cantidadBoletos>1 || cantidadHoteles>1){
                descuento= new DescuentoReserva(descuento, 0.05);
            }
        }
        reservas.add(reserva);
        System.out.println("Total: " + reserva.getTotal());
        System.out.println("Aplicados los descuentos: " + descuento.getTotal());
        return descuento;
    }

    @Override
    public String toString() {
        return "Cliente" + '\n' +
                "Id: " + id + '\n' +
                "Nombre: " + nombre + '\n';
    }
}
