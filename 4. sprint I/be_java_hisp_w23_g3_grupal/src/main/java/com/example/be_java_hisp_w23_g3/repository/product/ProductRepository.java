package com.example.be_java_hisp_w23_g3.repository.product;

import com.example.be_java_hisp_w23_g3.entity.Post;
import com.example.be_java_hisp_w23_g3.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Post, Long> {
    Long getNextId();
    List<Post> readBatchBySellerIds(List<Long> sellerIds);
    List<Post> findAll();
}
