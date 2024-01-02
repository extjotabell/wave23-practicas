package com.ospina.socialmeli.repository.product;

import com.ospina.socialmeli.entity.product.Post;
import com.ospina.socialmeli.repository.CRUDRepository;

import java.util.List;

public interface ProductRepository extends CRUDRepository<Post, Long> {
    Long getNextId();
    List<Post> readBatchBySellerIds(List<Long> sellerIds);
    List<Post> findAll();
}
