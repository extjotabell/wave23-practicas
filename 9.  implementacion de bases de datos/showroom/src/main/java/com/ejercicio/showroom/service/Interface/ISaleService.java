package com.ejercicio.showroom.service.Interface;

import com.ejercicio.showroom.dto.ClothesDTO;
import com.ejercicio.showroom.dto.SaleDTO;
import com.ejercicio.showroom.model.Clothes;

import java.util.List;

public interface ISaleService {
    SaleDTO createSale(SaleDTO saleDTO);
    List<SaleDTO> getAllSales();
    SaleDTO getSaleById(Long id);
    void deleteSale(Long id);
    SaleDTO updateSale(SaleDTO saleDTO, Long id);
    List<SaleDTO> getAllSalesByDate(String date);
    List<ClothesDTO> getAllSalesByClothe(Long id);
}
