package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.dto.VentaCompleteDTO;
import com.mercadolibre.showroom.dto.VentaDTO;
import com.mercadolibre.showroom.dto.response.MessageDTO;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    VentaDTO addSale(VentaDTO ventaDTO);
    List<VentaCompleteDTO> getSales();
    VentaCompleteDTO getSaleByNumber(Integer number);
    VentaCompleteDTO updateSaleByNumber(Integer number, VentaDTO ventaDTO);
    MessageDTO deleteSaleByNumber(Integer number);
    List<VentaCompleteDTO> getSalesByDate(LocalDate date);
    List<PrendaDTO> getClothesOfSale(Integer number);
}
