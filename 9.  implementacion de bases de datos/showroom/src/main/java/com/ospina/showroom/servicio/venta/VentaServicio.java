package com.ospina.showroom.servicio.venta;

import com.ospina.showroom.modelo.dto.request.VentaRequestDto;
import com.ospina.showroom.modelo.dto.response.PrendaResponseDto;
import com.ospina.showroom.modelo.dto.response.VentaResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface VentaServicio {

    Long guardarVenta(VentaRequestDto ventaRequestDto);

    List<VentaResponseDto> obtenerVentas(LocalDate fecha);

    VentaResponseDto obtenerVentaDtoPorNumero(Long numero);

    VentaResponseDto actualizarVenta(Long number, VentaRequestDto ventaRequestDto);

    void eliminarVenta(Long number);

    List<PrendaResponseDto> obtenerPrendasDeUnaVenta(Long number);

}
