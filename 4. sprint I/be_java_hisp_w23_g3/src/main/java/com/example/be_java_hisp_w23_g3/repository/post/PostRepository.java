package com.example.be_java_hisp_w23_g3.repository.post;

import com.example.be_java_hisp_w23_g3.entity.Post;
import com.example.be_java_hisp_w23_g3.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, String> {
    List<Post> readBatchBySellerId(Long sellerId);
    List<Post> readBatchBySellerIds(List<Long> sellerIds);
}
