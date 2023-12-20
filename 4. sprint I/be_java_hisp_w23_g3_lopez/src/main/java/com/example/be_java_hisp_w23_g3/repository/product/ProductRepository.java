package com.example.be_java_hisp_w23_g3.repository.product;

import com.example.be_java_hisp_w23_g3.entity.product.Post;
import com.example.be_java_hisp_w23_g3.repository.CRUDRepository;

import java.util.List;

public interface ProductRepository extends CRUDRepository<Post, Long> {
    Long getNextId();
    List<Post> readBatchBySellerIds(List<Long> sellerIds);
    List<Post> findAll();
}
