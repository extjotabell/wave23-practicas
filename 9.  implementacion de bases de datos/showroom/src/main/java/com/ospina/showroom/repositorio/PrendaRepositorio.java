package com.ospina.showroom.repositorio;

import com.ospina.showroom.modelo.entidad.Prenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepositorio extends CrudRepository<Prenda, Long> {

    @Query("SELECT p FROM Prenda p WHERE p.codigo = :codigo")
    Prenda findByCodigo(@Param("codigo") Long codigo);

    @Query("SELECT p FROM Prenda p WHERE LOWER(p.talle) LIKE LOWER(CONCAT('%', :talle, '%'))")
    List<Prenda> findByTalle(@Param("talle") String talle);

    @Query("SELECT p FROM Prenda p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Prenda> findByNombre(@Param("nombre") String nombre);
}