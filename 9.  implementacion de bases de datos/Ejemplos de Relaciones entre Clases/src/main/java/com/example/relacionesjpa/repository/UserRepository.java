package com.example.relacionesjpa.repository;

import com.example.relacionesjpa.entity.OneToOne.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
