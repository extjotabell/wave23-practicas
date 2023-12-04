package org.ejercicio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private List<Localizador> localizadorList;
    public Agencia() {
        this.localizadorList = new ArrayList<>();
    }
    public void crearReserva(List<IServicio> iServicioList, Cliente cliente, Double obtenerCosto) {

        double costoTotal = validarDescuentoSobreTotal(iServicioList, cliente, obtenerCosto);
        Localizador localizador = new Localizador(iServicioList,cliente,costoTotal);
        localizadorList.add(localizador);
    }

    private double validarDescuentoSobreTotal(List<IServicio> iServicioList, Cliente cliente, Double obtenerCosto) {
        double validacionDcto = validarDobleBoletoDobleHotel(iServicioList,obtenerCosto);
        validacionDcto = validarDosLocalizadores(cliente,validacionDcto);
        validacionDcto = validarPaqueteCompleto(iServicioList,validacionDcto);

        return validacionDcto;
    }

    private double validarDobleBoletoDobleHotel(List<IServicio> iServicioList, Double obtenerCosto) {
        int contadorBoleto=0, contadorHotel=0;
        double descuentoBoleto = 0, descuentoHotel=0;

        IServicio aux = iServicioList.get(iServicioList.size()-1);
        String[] s = aux.servicios().split(" ");

        for (String index: s) {
            if(index.contains("Hotel")){
                contadorHotel++;
            } else if(index.contains("Boleto")){
                contadorBoleto++;
            }
        }

        if(contadorHotel >= 2){
            descuentoHotel = iServicioList.stream()
                    .filter(element -> element.getClass().getSimpleName().equals("Hotel"))
                    .mapToDouble(IServicio::obtenerCosto)
                    .sum();
            obtenerCosto -= descuentoHotel * 0.05;
        }
        if(contadorBoleto >= 2){
            descuentoBoleto = iServicioList.stream()
                    .filter(element -> element.getClass().getSimpleName().equals("Boleto"))
                    .mapToDouble(IServicio::obtenerCosto)
                    .sum();
            obtenerCosto -= descuentoBoleto * 0.05;
        }

        return obtenerCosto;
    }

    private double validarPaqueteCompleto(List<IServicio> iServicioList, double validacionDcto) {
        IServicio aux = iServicioList.get(iServicioList.size()-1);
        String s = aux.servicios();

        if(s.contains("Transporte") && s.contains("Hotel") && s.contains("Boleto") && s.contains("Comida")){
            return validacionDcto -= validacionDcto * 0.1;
        }
        return validacionDcto;
    }

    private double validarDosLocalizadores(Cliente cliente, Double obtenerCosto) {
        long count = localizadorList.stream()
                .filter(element -> element.getCliente().getId().equals(cliente.getId()))
                .count();

        if(count >= 2){
            return obtenerCosto-=obtenerCosto * 0.05;
        }
        return obtenerCosto;
    }
    public Double obtenerCostoTotal(Long id) {
        return this.localizadorList.stream()
                .filter(element -> element.getCliente().getId().equals(id))
                .mapToDouble(Localizador::getTotalLocalizador)
                .sum();
    }
}