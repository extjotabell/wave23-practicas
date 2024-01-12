package com.relations.jpa.repository;

import com.relations.jpa.entities.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOneToManyRepository extends JpaRepository<Cart, Long> {

}