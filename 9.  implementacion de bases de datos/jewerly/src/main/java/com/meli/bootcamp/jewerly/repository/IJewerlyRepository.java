package com.meli.bootcamp.jewerly.repository;

import com.meli.bootcamp.jewerly.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly,Long> {
}
