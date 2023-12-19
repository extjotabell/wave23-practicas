package com.ospina.socialmeli.repository.seller;

import com.ospina.socialmeli.entity.Seller;
import com.ospina.socialmeli.entity.User;
import jakarta.annotation.PostConstruct;
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
    public void update(Seller entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @PostConstruct
    private void load() {
        sellers.addAll(List.of(
                Seller.build(User.build(7L, "seller1"),
                        new HashSet<>(
                                Arrays.asList(
                                        User.build(13L, "abcdef"),
                                        User.build(6L, "bcdefg"),
                                        User.build(15L, "cdefgh")
                                )),
                        new HashMap<>()),
                Seller.build(User.build(8L, "seller2")),
                Seller.build(User.build(9L, "seller3")),
                Seller.build(User.build(10L, "seller4")),
                Seller.build(User.build(11L, "seller5")),
                Seller.build(User.build(12L, "seller6"))
        ));
    }
}
