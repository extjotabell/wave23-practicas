package com.example.be_java_hisp_w23_g3.repository.user;

import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepositoryImpl implements SellerRepository {

    private final List<Seller> sellers;

    public SellerRepositoryImpl() {
        this.sellers = new ArrayList<>();
    }

    @Override
    public void create(Seller entity) {
        sellers.add(entity);
    }

    @Override
    public Optional<Seller> read(Long aLong) {
        return sellers.stream().filter(seller -> seller.getId().equals(aLong)).findFirst();
    }

    @Override
    public void update(Seller entity) {

    }

    @Override
    public void delete(Long aLong) {
        sellers.removeIf(seller -> seller.getId().equals(aLong));
    }

    @PostConstruct
    private void load() {
        sellers.addAll(List.of(
                Seller.build(User.build(7L, "seller1")),
                Seller.build(User.build(8L, "seller2")),
                Seller.build(User.build(9L, "seller3")),
                Seller.build(User.build(10L, "seller4")),
                Seller.build(User.build(11L, "seller5")),
                Seller.build(User.build(12L, "seller6"))
        ));
    }
}
