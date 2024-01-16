package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Integer> {

    @Query("FROM Prenda WHERE codigo = :codigo")
    Prenda getByCode(Integer codigo);

    @Query("FROM Prenda WHERE talle = :size")
    List<Prenda> getBySize(Integer size);

    @Query("FROM Prenda WHERE UPPER(nombre) LIKE UPPER('%' || :name || '%')")
    List<Prenda> getByName(String name);
}
