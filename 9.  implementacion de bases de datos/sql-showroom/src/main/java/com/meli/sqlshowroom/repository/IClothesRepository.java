package com.meli.sqlshowroom.repository;

import com.meli.sqlshowroom.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClothesRepository extends JpaRepository<Clothes, Long> {
    @Query("FROM Clothes c WHERE c.code = :code")
    List<Clothes> findByCode(@Param("code") String code);
}
