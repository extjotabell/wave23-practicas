package com.ejercicio.showroom.service.Interface;

import com.ejercicio.showroom.dto.ClothesDTO;
import com.ejercicio.showroom.dto.SaleDTO;
import com.ejercicio.showroom.model.Sale;
import com.ejercicio.showroom.repository.ISaleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements ISaleService{
    private ISaleRepository saleRepository;

    public SaleServiceImpl(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Sale sale = mapper.convertValue(saleDTO, Sale.class);

        return mapper.convertValue(saleRepository.save(sale), SaleDTO.class);
    }

    @Override
    public List<SaleDTO> getAllSales() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Sale> sales = saleRepository.findAll();

        return sales.stream()
                .map(sale -> mapper.convertValue(sale, SaleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaleDTO getSaleById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Sale sale = saleRepository.findById(id).orElse(null);

        return mapper.convertValue(sale, SaleDTO.class);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public SaleDTO updateSale(SaleDTO saleDTO, Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Sale sale = mapper.convertValue(saleDTO, Sale.class);

        Sale existSale = saleRepository.findById(id).orElse(null);

        try {
            mapper.updateValue(existSale, sale);
        } catch (Exception e) {
            throw new RuntimeException("Error al mapear DTO a la entidad: " + e.getMessage());
        }

        Sale updatedSale = saleRepository.save(existSale);

        return mapper.convertValue(updatedSale, SaleDTO.class);
    }

    @Override
    public List<SaleDTO> getAllSalesByDate(String date) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<SaleDTO> sales = saleRepository.getAllSalesByDate(date);

        return sales.stream()
                .map(sale -> mapper.convertValue(sale, SaleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClothesDTO> getAllSalesByClothe(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Sale sales = saleRepository.findById(id).orElse(null);

        assert sales != null;
        return sales.getClothes().stream()
                .map(clothe -> mapper.convertValue(clothe, ClothesDTO.class))
                .collect(Collectors.toList());
    }
}
