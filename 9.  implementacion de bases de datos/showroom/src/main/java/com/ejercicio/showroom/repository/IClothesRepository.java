package com.ejercicio.showroom.repository;

import com.ejercicio.showroom.dto.ClothesDTO;
import com.ejercicio.showroom.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends JpaRepository<Clothes, Long> {
    @Query("FROM Clothes clothe WHERE clothe.size = :size")
    List<Clothes> getAllClothesBySize(String size);

    @Query("FROM Clothes clothe WHERE clothe.name LIKE %:name%")
    List<Clothes> getAllClothesByName(String name);
}
