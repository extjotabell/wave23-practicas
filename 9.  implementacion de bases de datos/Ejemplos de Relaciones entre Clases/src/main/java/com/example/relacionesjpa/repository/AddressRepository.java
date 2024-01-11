package com.example.relacionesjpa.repository;

import com.example.relacionesjpa.entity.OneToOne.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
