package com.meli.JoyeriaLasPerlas.repository;

import com.meli.JoyeriaLasPerlas.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {
}
