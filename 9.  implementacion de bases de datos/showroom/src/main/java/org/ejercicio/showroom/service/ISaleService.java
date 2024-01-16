package org.ejercicio.showroom.service;

import org.ejercicio.showroom.model.dto.SaleDto;
import org.ejercicio.showroom.model.entty.Sale;

import java.util.List;

public interface ISaleService {
    SaleDto saveSale(SaleDto saleDto);

    List<SaleDto> getSales();

    SaleDto getSaleNumber(Integer number);

    SaleDto editSale(SaleDto saleDto, Integer number);
}
