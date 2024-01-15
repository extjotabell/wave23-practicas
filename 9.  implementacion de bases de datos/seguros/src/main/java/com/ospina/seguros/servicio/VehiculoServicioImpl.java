package com.ospina.seguros.servicio;

import com.ospina.seguros.modelo.dto.VehiculoResponseMatriculaMarcaModeloDto;
import com.ospina.seguros.modelo.dto.VehiculoResponsePatenteMarcaDto;
import com.ospina.seguros.modelo.dto.VehiculoResponsePerdidaTotalDto;
import com.ospina.seguros.repositorio.VehiculoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServicioImpl implements VehiculoServicio {

    private final VehiculoRepositorio vehiculoRepositorio;

    public VehiculoServicioImpl(VehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
    }


    @Override
    @Transactional
    public List<String> listarPatentes() {
        return vehiculoRepositorio.findPatentes();
    }

    @Override
    @Transactional
    public List<VehiculoResponsePatenteMarcaDto> listarPatentesYMarcasPorAnioDeFabricacion(Integer anioFabricacion) {
        return vehiculoRepositorio.findByAnioFabricacion(anioFabricacion);
    }

    @Override
    @Transactional
    public List<String> listarPatentesVehiculosConMasDeCuatroRuedasFabricadosEsteAnio() {
        return vehiculoRepositorio.findPatentesVehiculosConMasDeCuatroRuedasFabricadosEsteAnio();
    }

    @Override
    @Transactional
    public List<VehiculoResponseMatriculaMarcaModeloDto> listarMatriculaMarcaModeloPorPerdidaMayor10000() {
        return vehiculoRepositorio.findVehiculosConSiniestrosMayorA10000();
    }

    @Override
    @Transactional
    public List<VehiculoResponsePerdidaTotalDto> listarVehiculosPorMatriculaMarcaModeloYTotalPerdida() {
        return vehiculoRepositorio.findVehiculosConSiniestrosMayorA10000YPerdidaTotal();
    }
}
