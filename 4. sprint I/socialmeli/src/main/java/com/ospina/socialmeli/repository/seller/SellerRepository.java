package com.ospina.socialmeli.repository.seller;

import com.ospina.socialmeli.entity.Seller;
import com.ospina.socialmeli.repository.CrudRepository;

import java.util.List;

public interface SellerRepository extends CrudRepository<Seller, Long> {
    List<Seller> createAll(List<Seller> entities);
}