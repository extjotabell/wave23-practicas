package com.example.InsuranceCompany.repository;

import com.example.InsuranceCompany.entity.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISinisterRepository extends JpaRepository<Sinister, Long> {
}
