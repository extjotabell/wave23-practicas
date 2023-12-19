package com.ospina.socialmeli.repository.product;

import com.ospina.socialmeli.entity.Post;
import com.ospina.socialmeli.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Post, Long> {
    Long getNextId();
    List<Post> readBatchBySellerIds(List<Long> sellerIds);
    List<Post> findAll();
}
