package org.ejercicio.showroom.service;

import org.ejercicio.showroom.model.dto.SaleDto;
import org.ejercicio.showroom.model.entty.Sale;
import org.ejercicio.showroom.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class SaleServiceImpl implements ISaleService {

    private final ISaleRepository repository;

    private final ModelMapper modelMapper = new ModelMapper();

    public SaleServiceImpl(ISaleRepository repository) {
        this.repository = repository;
    }

    @Override
    public SaleDto saveSale(SaleDto saleDto) {
        Sale sale = repository.save(modelMapper.map(saleDto, Sale.class));
        return modelMapper.map(sale, SaleDto.class);
    }

    @Override
    public List<SaleDto> getSales() {
        Iterable<Sale> saleIterator = repository.findAll();
        return StreamSupport
                .stream(saleIterator.spliterator(), false)
                .map(sale -> modelMapper.map(sale, SaleDto.class))
                .toList();
    }
}
