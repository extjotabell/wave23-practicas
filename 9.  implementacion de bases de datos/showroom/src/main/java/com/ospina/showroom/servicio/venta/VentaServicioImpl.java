package com.ospina.showroom.servicio.venta;

import com.ospina.showroom.excepcion.NotFoundException;
import com.ospina.showroom.modelo.dto.request.VentaRequestDto;
import com.ospina.showroom.modelo.dto.response.PrendaResponseDto;
import com.ospina.showroom.modelo.dto.response.VentaResponseDto;
import com.ospina.showroom.modelo.entidad.Venta;
import com.ospina.showroom.repositorio.VentaRepositorio;
import com.ospina.showroom.servicio.prenda.PrendaServicio;
import com.ospina.showroom.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaServicioImpl implements VentaServicio {

    private final VentaRepositorio ventaRepositorio;
    private final PrendaServicio prendaServicio;

    public VentaServicioImpl(VentaRepositorio ventaRepositorio, PrendaServicio prendaServicio) {
        this.ventaRepositorio = ventaRepositorio;
        this.prendaServicio = prendaServicio;
    }

    @Override
    public Long guardarVenta(VentaRequestDto ventaRequestDto) {
        Venta venta = ventaRepositorio.save(convertirVentaRequestDtoAVenta(ventaRequestDto));
        return venta.getNumero();
    }

    @Override
    public List<VentaResponseDto> obtenerVentas(LocalDate fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaString = fecha != null ? fecha.format(formatter) : null;
        List<Venta> ventas = fechaString != null ? ventaRepositorio.findByFecha(fechaString) : (List<Venta>) ventaRepositorio.findAll();
        if (ventas.isEmpty()) {
            throw new NotFoundException("No se encontraron ventas");
        } else {
            return DTOMapper.toVentaResponseDtoList(ventas);
        }
    }

    @Override
    public VentaResponseDto obtenerVentaDtoPorNumero(Long numero) {
        Venta venta = obtenerVentaPorNumero(numero);
        return venta.getPrendas().isEmpty() ? null : DTOMapper.toVentaResponseDto(venta);
    }

    @Override
    public VentaResponseDto actualizarVenta(Long number, VentaRequestDto ventaRequestDto) {
        return DTOMapper.toVentaResponseDto(ventaRepositorio.save(convertirVentaRequestDtoAVenta(ventaRequestDto, obtenerVentaPorNumero(number))));
    }

    @Override
    public void eliminarVenta(Long number) {
        ventaRepositorio.delete(obtenerVentaPorNumero(number));
    }

    @Override
    public List<PrendaResponseDto> obtenerPrendasDeUnaVenta(Long number) {
        return DTOMapper.toPrendaResponseDtoList(ventaRepositorio.findPrendasByNumero(number));
    }

    private Venta obtenerVentaPorNumero(Long numero) {
        return Optional.ofNullable(ventaRepositorio.findByNumero(numero))
                .orElseThrow(() -> new NotFoundException("No se encontró la venta con el número: " + numero));
    }

    private Venta convertirVentaRequestDtoAVenta(VentaRequestDto ventaRequestDto, Venta venta) {
        venta.setFecha(ventaRequestDto.getFecha());
        venta.setTotal(ventaRequestDto.getTotal());
        venta.setMedioPago(ventaRequestDto.getMedioPago());
        venta.setPrendas(ventaRequestDto.getPrendas().stream()
                .map(prendaReferenciaDto -> prendaServicio.obtenerPrendaPorCodigo(prendaReferenciaDto.getCodigo()))
                .collect(Collectors.toList()));
        return venta;
    }

    private Venta convertirVentaRequestDtoAVenta(VentaRequestDto ventaRequestDto) {
        return convertirVentaRequestDtoAVenta(ventaRequestDto, new Venta());
    }
}