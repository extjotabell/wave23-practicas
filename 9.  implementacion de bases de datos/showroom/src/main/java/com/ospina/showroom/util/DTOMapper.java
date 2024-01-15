package com.ospina.showroom.util;

import com.ospina.showroom.modelo.dto.response.PrendaResponseDto;
import com.ospina.showroom.modelo.dto.response.VentaResponseDto;
import com.ospina.showroom.modelo.entidad.Prenda;
import com.ospina.showroom.modelo.entidad.Venta;

import java.util.List;

public class DTOMapper {

    public static VentaResponseDto toVentaResponseDto(Venta venta) {
        return new VentaResponseDto(
                venta.getNumero(),
                venta.getFecha(),
                venta.getTotal(),
                venta.getMedioPago(),
                venta.getPrendas().stream().map(Prenda::getCodigo).toList()
        );
    }

    public static List<VentaResponseDto> toVentaResponseDtoList(List<Venta> ventas) {
        return ventas.stream()
                .map(DTOMapper::toVentaResponseDto)
                .toList();
    }

    public static PrendaResponseDto toPrendaResponseDto(Prenda prenda) {
        return new PrendaResponseDto(
                prenda.getCodigo(),
                prenda.getNombre(),
                prenda.getTipo(),
                prenda.getMarca(),
                prenda.getColor(),
                prenda.getTalle(),
                prenda.getCantidad(),
                prenda.getPrecioVenta()
        );
    }

    public static List<PrendaResponseDto> toPrendaResponseDtoList(List<Prenda> prendas) {
        return prendas.stream()
                .map(DTOMapper::toPrendaResponseDto)
                .toList();
    }
}
