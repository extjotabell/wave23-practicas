package com.ospina.showroom.servicio.prenda;

import com.ospina.showroom.modelo.dto.request.PrendaRequestDto;
import com.ospina.showroom.modelo.entidad.Prenda;
import com.ospina.showroom.repositorio.PrendaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServicioImpl implements PrendaServicio {

    private final PrendaRepositorio prendaRepositorio;

    public PrendaServicioImpl(PrendaRepositorio prendaRepositorio) {
        this.prendaRepositorio = prendaRepositorio;
    }

    @Override
    public Long guardarPrenda(PrendaRequestDto prendaRequestDto) {
        return prendaRepositorio.save(convertirDtoAPrenda(prendaRequestDto)).getCodigo();
    }

    @Override
    public List<Prenda> obtenerPrendas(String nombre) {
        return nombre != null ? prendaRepositorio.findByNombre(nombre) : (List<Prenda>) prendaRepositorio.findAll();
    }

    @Override
    public Prenda obtenerPrendaPorCodigo(Long code) {
        return prendaRepositorio.findByCodigo(code);
    }

    @Override
    public Prenda actualizarPrenda(Long code, PrendaRequestDto prendaRequestDto) {
        Prenda prenda = obtenerPrendaPorCodigo(code);
        return prendaRepositorio.save(convertirDtoAPrenda(prendaRequestDto, prenda));
    }

    @Override
    public void eliminarPrenda(Long code) {
        prendaRepositorio.delete(obtenerPrendaPorCodigo(code));
    }

    @Override
    public List<Prenda> obtenerPrendasPorTalla(String size) {
        return prendaRepositorio.findByTalle(size);
    }

    private Prenda convertirDtoAPrenda(PrendaRequestDto dto, Prenda prenda) {
        prenda.setNombre(dto.getNombre());
        prenda.setTipo(dto.getTipo());
        prenda.setMarca(dto.getMarca());
        prenda.setColor(dto.getColor());
        prenda.setTalle(dto.getTalle());
        prenda.setCantidad(dto.getCantidad());
        prenda.setPrecioVenta(dto.getPrecioVenta());
        return prenda;
    }

    private Prenda convertirDtoAPrenda(PrendaRequestDto dto) {
        return convertirDtoAPrenda(dto, new Prenda());
    }
}