package com.meli.jewelry.repositories;

import com.meli.jewelry.entities.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
