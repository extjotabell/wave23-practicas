package com.example.be_java_hisp_w23_g3.repository.product;

import com.example.be_java_hisp_w23_g3.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final List<Post> posts;

    public ProductRepositoryImpl(){
        posts = new ArrayList<>();
    }

    @Override
    public Post create(Post entity) {
        posts.add(entity);
        return entity;
    }

    @Override
    public List<Post> createAll(List<Post> entities) {
        posts.addAll(entities);
        return entities;
    }

    @Override
    public Optional<Post> read(Long postId) {
        return posts.stream().filter(post -> post.getId().equals(postId)).findFirst();
    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Long getNextId() {
        return (long) (posts.size() + 1);
    }

    @Override
    public List<Post> readBatchBySellerIds(List<Long> sellerIds) {
        return posts.stream().filter(post -> sellerIds.contains(post.getSeller().getId())).toList();
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

}
