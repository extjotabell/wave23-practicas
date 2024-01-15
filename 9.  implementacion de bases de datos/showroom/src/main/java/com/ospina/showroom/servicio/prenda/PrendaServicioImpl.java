package com.ospina.showroom.servicio.prenda;

import com.ospina.showroom.excepcion.NotFoundException;
import com.ospina.showroom.modelo.dto.request.PrendaRequestDto;
import com.ospina.showroom.modelo.entidad.Prenda;
import com.ospina.showroom.repositorio.PrendaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<Prenda> prendas = nombre != null ? prendaRepositorio.findByNombre(nombre) : (List<Prenda>) prendaRepositorio.findAll();
        if (prendas.isEmpty()) {
            throw new NotFoundException("No se encontraron prendas con el nombre proporcionado: " + nombre);
        }
        return prendas;
    }

    @Override
    public Prenda obtenerPrendaPorCodigo(Long code) {
        return Optional.ofNullable(prendaRepositorio.findByCodigo(code))
                .orElseThrow(() -> new NotFoundException("No se encontró una prenda con el codigo proporcionado: " + code));
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
        List<Prenda> prendas = prendaRepositorio.findByTalle(size);
        if (prendas.isEmpty()) {
            throw new NotFoundException("No se encontraron prendas con la talla proporcionada: " + size);
        }
        return prendas;
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