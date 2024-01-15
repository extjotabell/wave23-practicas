package com.ospina.showroom.controlador;

import com.ospina.showroom.modelo.dto.request.VentaRequestDto;
import com.ospina.showroom.modelo.dto.response.PrendaResponseDto;
import com.ospina.showroom.modelo.dto.response.VentaResponseDto;
import com.ospina.showroom.servicio.venta.VentaServicio;
import com.ospina.showroom.util.FechaUtilidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/sale")
public class VentaControlador {

    private final VentaServicio ventaServicio;

    public VentaControlador(VentaServicio ventaServicio) {
        this.ventaServicio = ventaServicio;
    }

    @PostMapping
    public ResponseEntity<String> guardarVenta(@RequestBody VentaRequestDto ventaRequestDto) {
        Long id = ventaServicio.guardarVenta(ventaRequestDto);
        return ResponseEntity.ok("Venta creada exitosamente con el ID: " + id);
    }

    @GetMapping
    public ResponseEntity<List<VentaResponseDto>> obtenerVentas(@RequestParam(value = "date", required = false) String fecha) {
        LocalDate localDateFecha = null;
        if (fecha != null) {
            localDateFecha = FechaUtilidad.convertirFecha(fecha);
        }
        return ResponseEntity.ok(ventaServicio.obtenerVentas(localDateFecha));
    }

    @GetMapping("/{number}")
    public ResponseEntity<VentaResponseDto> obtenerVentaPorNumero(@PathVariable Long number) {
        return ResponseEntity.ok(ventaServicio.obtenerVentaDtoPorNumero(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<VentaResponseDto> actualizarVenta(@PathVariable Long number, @RequestBody VentaRequestDto ventaRequestDto) {
        return ResponseEntity.ok(ventaServicio.actualizarVenta(number, ventaRequestDto));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> eliminarVenta(@PathVariable Long number) {
        ventaServicio.eliminarVenta(number);
        return ResponseEntity.ok("Venta eliminada exitosamente");
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<PrendaResponseDto>> obtenerPrendasDeUnaVenta(@PathVariable Long number) {
        return ResponseEntity.ok(ventaServicio.obtenerPrendasDeUnaVenta(number));
    }

}
