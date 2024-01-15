package com.ospina.seguros.controlador;

import com.ospina.seguros.modelo.dto.VehiculoResponseMatriculaMarcaModeloDto;
import com.ospina.seguros.modelo.dto.VehiculoResponsePatenteMarcaDto;
import com.ospina.seguros.modelo.dto.VehiculoResponsePerdidaTotalDto;
import com.ospina.seguros.servicio.VehiculoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/vehiculo")
public class VehiculoControlador {

    private final VehiculoServicio vehiculoServicio;


    public VehiculoControlador(VehiculoServicio vehiculoServicio) {
        this.vehiculoServicio = vehiculoServicio;
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> obtenerPatentes() {
        return ResponseEntity.ok(vehiculoServicio.listarPatentes());
    }

    @GetMapping("/patentes-marcas")
    public ResponseEntity<List<VehiculoResponsePatenteMarcaDto>> obtenerPatentesMarcasPorAnioFabricacion(@RequestParam("anio_fabricacion") Integer anioFabricacion) {
        return ResponseEntity.ok(vehiculoServicio.listarPatentesYMarcasPorAnioDeFabricacion(anioFabricacion));
    }

    @GetMapping("/patentes-cuatro-ruedas-anio-actual")
    public ResponseEntity<List<String>> obtenerPatentesCuatroRuedasAnioActual() {
        return ResponseEntity.ok(vehiculoServicio.listarPatentesVehiculosConMasDeCuatroRuedasFabricadosEsteAnio());
    }

    @GetMapping("/matricula-marca-modelo-perdida-mayor-10000")
    public ResponseEntity<List<VehiculoResponseMatriculaMarcaModeloDto>> obtenerMatriculaMarcaModeloPerdidaMayor10000() {
        return ResponseEntity.ok(vehiculoServicio.listarMatriculaMarcaModeloPorPerdidaMayor10000());
    }

    @GetMapping("/matricula-marca-modelo-total-perdida")
    public ResponseEntity<List<VehiculoResponsePerdidaTotalDto>> obtenerMatriculaMarcaModeloTotalPerdida() {
        return ResponseEntity.ok(vehiculoServicio.listarVehiculosPorMatriculaMarcaModeloYTotalPerdida());
    }
}
