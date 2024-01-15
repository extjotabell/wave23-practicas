package com.ejercicio.showroom.repository;

import com.ejercicio.showroom.dto.SaleDTO;
import com.ejercicio.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
    @Query("FROM Sale sale WHERE sale.date = :date")
    List<SaleDTO> getAllSalesByDate(String date);
}
