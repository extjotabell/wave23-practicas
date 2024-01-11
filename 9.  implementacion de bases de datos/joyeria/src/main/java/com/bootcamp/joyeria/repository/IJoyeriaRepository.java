package com.bootcamp.joyeria.repository;

import com.bootcamp.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyeriaRepository extends JpaRepository<Joya, Long> {

}
