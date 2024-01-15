package com.example.Showroom.service;

import com.example.Showroom.exception.NotFoundException;
import com.example.Showroom.model.dto.request.NewPrendaDto;
import com.example.Showroom.model.dto.response.BaseResponseDto;
import com.example.Showroom.model.entity.Prenda;
import com.example.Showroom.repository.IShowroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShowroomService implements IShowroomService{

    private final IShowroomRepository repository;

    public ShowroomService(IShowroomRepository repository) {
        this.repository = repository;
    }
    @Override
    public BaseResponseDto savePrenda(NewPrendaDto prenda) {

        Prenda newPrenda = repository.save(PrendaDtoToEntity(prenda));
        return new BaseResponseDto("Prenda guardada con id " + newPrenda.getCodigo());
    }

    @Override
    public List<Prenda> getAllPrendas() {
        return repository.findAll();
    }

    @Override
    public Prenda getPrenda(Long code) {
        return repository.findById(code).orElseThrow(() -> new NotFoundException("No se encontró la prenda id: " + code));
    }

    @Override
    public Prenda editPrenda(Long code, Prenda prenda) {
        Prenda prendaOriginal = repository.findById(code).orElseThrow(() -> new NotFoundException("No se encontró la prenda id: " + code));

        prendaOriginal.setNombre(prenda.getNombre());
        prendaOriginal.setColor(prenda.getColor());
        prendaOriginal.setPrecio_venta(prenda.getPrecio_venta());
        prendaOriginal.setMarca(prenda.getMarca());
        prendaOriginal.setTalle(prenda.getTalle());
        prendaOriginal.setTipo(prenda.getTipo());
        prendaOriginal.setCantidad(prenda.getCantidad());

        return repository.save(prendaOriginal);
    }

    @Override
    public BaseResponseDto removePrenda(Long code) {

        Prenda prenda = repository.findById(code).orElseThrow(() -> new NotFoundException("No se encontró la prenda id: " + code));

        repository.delete(prenda);
        return new BaseResponseDto("Prenda eliminada");
    }

    @Override
    public List<Prenda> getPrendaTalle(String size) {
        return repository.findPrendaByTalle(size);
    }

    @Override
    public List<Prenda> getPrendaNombre(String nombre) {
        return repository.findPrendaByNombre(nombre);
    }

    private Prenda PrendaDtoToEntity(NewPrendaDto dto){

        Prenda prenda = new Prenda();
        prenda.setCantidad(dto.getCantidad());
        prenda.setColor(dto.getColor());
        prenda.setNombre(dto.getNombre());
        prenda.setMarca(dto.getMarca());
        prenda.setTalle(dto.getTalle());
        prenda.setTipo(dto.getTipo());
        prenda.setPrecio_venta(dto.getPrecio_venta());

        return prenda;

    }
}
