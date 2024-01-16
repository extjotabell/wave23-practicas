package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.dto.VentaCompleteDTO;
import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {

    @Query("FROM Venta WHERE numero = :number")
    Venta getBySaleNumber(Integer number);

    @Query("FROM Prenda WHERE codigo = :codigo")
    Prenda getInfoClothe(Integer codigo);

    @Query("FROM Venta WHERE fecha = :date")
    List<Venta> getSalesByDate(LocalDate date);
}
