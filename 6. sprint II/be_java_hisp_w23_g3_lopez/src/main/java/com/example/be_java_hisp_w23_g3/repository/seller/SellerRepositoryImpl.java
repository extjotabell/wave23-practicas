package com.example.be_java_hisp_w23_g3.repository.seller;

import com.example.be_java_hisp_w23_g3.entity.user.Seller;
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
    public void update(Long id, Seller entity) {
        sellers.stream().filter(seller -> seller.getId().equals(id)).findFirst()
                .ifPresent(seller -> {
                    seller.setUsername(entity.getUsername());
                    seller.setFollower(entity.getFollower());
                    seller.setFollowing(entity.getFollowing());
                    seller.setPosts(entity.getPosts());
                });
    }

    @Override
    public void delete(Long aLong) {
        sellers.removeIf(seller -> seller.getId().equals(aLong));
    }

}
