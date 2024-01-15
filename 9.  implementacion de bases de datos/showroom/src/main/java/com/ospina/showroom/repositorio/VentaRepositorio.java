package com.ospina.showroom.repositorio;

import com.ospina.showroom.modelo.entidad.Prenda;
import com.ospina.showroom.modelo.entidad.Venta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepositorio extends CrudRepository<Venta, Long> {

    @Query("SELECT v FROM Venta v WHERE v.numero = :numero")
    Venta findByNumero(@Param("numero") Long numero);

    @Query("SELECT v FROM Venta v WHERE v.fecha = :fecha")
    List<Venta> findByFecha(@Param("fecha") String fecha);

    @Query("SELECT p FROM Venta v JOIN v.prendas p WHERE v.numero = :numero")
    List<Prenda> findPrendasByNumero(@Param("numero") Long numero);

}
