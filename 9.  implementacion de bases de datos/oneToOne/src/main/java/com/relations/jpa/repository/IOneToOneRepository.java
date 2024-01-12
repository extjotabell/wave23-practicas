package com.relations.jpa.repository;

import com.relations.jpa.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOneToOneRepository extends JpaRepository<User, Long> {

}