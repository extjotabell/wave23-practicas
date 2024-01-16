package org.ejercicio.showroom.service;

import org.ejercicio.showroom.model.dto.SaleDto;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    SaleDto saveSale(SaleDto saleDto);

    List<SaleDto> getSales();

    SaleDto getSaleNumber(Integer number);

    SaleDto editSale(SaleDto saleDto, Integer number);

    void deleteSale(Integer number);

    List<SaleDto> getSalesDate(LocalDate date);
}
