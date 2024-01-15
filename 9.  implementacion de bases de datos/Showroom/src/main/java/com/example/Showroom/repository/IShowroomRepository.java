package com.example.Showroom.repository;

import com.example.Showroom.model.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IShowroomRepository extends JpaRepository<Prenda, Long> {

    List<Prenda> findPrendaByTalle(String talle);

    List<Prenda> findPrendaByNombre(String nombre);
}
