package org.ejercicio.showroom.service;

import org.ejercicio.showroom.model.dto.ClothesDto;
import org.ejercicio.showroom.model.dto.SaleDto;
import org.ejercicio.showroom.model.entty.Clothes;
import org.ejercicio.showroom.model.entty.Sale;
import org.ejercicio.showroom.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public SaleDto getSaleNumber(Integer number) {
        Sale sale = repository.findByNumber(number);
        return modelMapper.map(sale, SaleDto.class);
    }

    @Override
    public SaleDto editSale(SaleDto saleDto, Integer number) {
        Sale sale = repository.findByNumber(number);
        sale.setDate(saleDto.getDate());
        sale.setTotal(saleDto.getTotal());
        sale.setPaymentMethod(saleDto.getPaymentMethod());
        sale.setClothesList(saleDto.getClothesList());
        repository.save(sale);
        return modelMapper.map(sale, SaleDto.class);
    }

    @Override
    public void deleteSale(Integer number) {
        Sale sale = repository.findByNumber(number);
        repository.delete(sale);
    }

    @Override
    public List<SaleDto> getSalesDate(LocalDate date) {
        List<Sale> sales = repository.findAllByDate(date);
        return sales
                .stream()
                .map(sale -> modelMapper.map(sale, SaleDto.class))
                .toList();
    }

    @Override
    public List<ClothesDto> getClothesOfSale(Integer number) {
        Sale sale = repository.findByNumber(number);
        List<Clothes> clothes = sale.getClothesList();

        return clothes
                .stream()
                .map(cloth -> modelMapper.map(cloth, ClothesDto.class))
                .toList();
    }
}
