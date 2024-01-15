package com.meli.showroom.repositories;

import com.meli.showroom.entities.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IClothesRepository extends JpaRepository<Clothes, Long>{
    Optional<Clothes> findByCode(String code);
    void deleteByCode(String code);
    //Find by size
    @Query("SELECT C FROM clothes C WHERE C.size = :size")
    List<Clothes> findBySize(String size);
}