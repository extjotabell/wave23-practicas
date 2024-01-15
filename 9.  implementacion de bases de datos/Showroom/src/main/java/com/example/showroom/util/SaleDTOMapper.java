package com.example.showroom.util;

import com.example.showroom.dto.sale.SaleRequestDTO;
import com.example.showroom.dto.sale.SaleResponseDTO;
import com.example.showroom.model.Clothe;
import com.example.showroom.model.Sale;

import java.time.LocalDate;
import java.util.List;

public class SaleDTOMapper {
    public static Sale mapToSale(SaleRequestDTO saleRequestDTO, LocalDate date, Double saleTotal, List<Clothe> clothes) {
        return new Sale(date, saleTotal, saleRequestDTO.getPaymentMethod(), clothes);
    }

    public static SaleResponseDTO mapToSaleResponseDTO(Sale sale) {
        return new SaleResponseDTO(sale.getId(), sale.getDate(),
                sale.getSaleTotal(), sale.getPaymentMethod(),
                sale.getClothes().stream().map(ClotheDTOMapper::mapToClotheResponseDTO).toList());
    }
}
