package com.example.ejercicioClaveCompuesta.service.impl;

import com.example.ejercicioClaveCompuesta.dto.CompraResponseDto;
import com.example.ejercicioClaveCompuesta.dto.NewCompraRequestDto;
import com.example.ejercicioClaveCompuesta.model.Compra;
import com.example.ejercicioClaveCompuesta.model.CompraKey;
import com.example.ejercicioClaveCompuesta.repository.CompraRepository;
import com.example.ejercicioClaveCompuesta.service.ICompraService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraServiceImpl implements ICompraService {

    private CompraRepository compraRepository;

    public CompraServiceImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public void save(NewCompraRequestDto newCompraRequestDto) {
        CompraKey compraKey = new CompraKey(
                newCompraRequestDto.getClienteId(),
                newCompraRequestDto.getFecha()
        );
        Compra compra = new Compra(compraKey, newCompraRequestDto.getSucursal());
        compraRepository.save(compra);

    }

    @Override
    public List<CompraResponseDto> findAll() {
        List<Compra> compraList = compraRepository.findAll();
        List<CompraResponseDto> compraResponseDtoList = new ArrayList<>();
        compraList.forEach(c -> {
                compraResponseDtoList.add(
                        new CompraResponseDto(
                                c.getCompraKey().getClienteId(),
                                c.getCompraKey().getFecha(),
                                c.getSucursal()
                        )
                );
        }
        );
        return compraResponseDtoList;
    }
}
