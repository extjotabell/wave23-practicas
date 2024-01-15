package com.example.showroom.service.sale;

import com.example.showroom.dto.clothe.ClotheResponseDTO;
import com.example.showroom.dto.sale.SaleRequestDTO;
import com.example.showroom.dto.sale.SaleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {
    void save(SaleRequestDTO saleRequestDTO);

    List<SaleResponseDTO> findAll(LocalDate date);

    SaleResponseDTO findById(Long id);

    void delete(Long id);

    List<ClotheResponseDTO> findClothesBySale(Long id);
}
