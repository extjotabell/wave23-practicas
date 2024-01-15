package com.ospina.showroom.repositorio;

import com.ospina.showroom.modelo.entidad.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositorio extends CrudRepository<Venta, Long> {
}
