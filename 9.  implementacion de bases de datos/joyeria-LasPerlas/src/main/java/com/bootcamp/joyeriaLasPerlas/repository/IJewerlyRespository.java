package com.bootcamp.joyeriaLasPerlas.repository;

import com.bootcamp.joyeriaLasPerlas.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRespository extends JpaRepository<Jewerly,Long> {
}
