package com.ospina.socialmeli.repository.seller;

import com.ospina.socialmeli.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SellerRepositoryImpl implements SellerRepository{

    private final List<Seller> sellers;

    public SellerRepositoryImpl() {
        this.sellers = new ArrayList<>();
    }

    @Override
    public Optional<Seller> read(Long sellerId) {
        return sellers.stream().filter(seller -> seller.getId().equals(sellerId)).findFirst();
    }

    @Override
    public Seller create(Seller entity) {
        sellers.add(entity);
        return entity;
    }

    @Override
    public List<Seller> createAll(List<Seller> entities) {
        sellers.addAll(entities);
        return entities;
    }

    @Override
    public void update(Seller entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

}