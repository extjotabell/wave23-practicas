package com.ospina.socialmeli.repository.product;

import com.ospina.socialmeli.entity.Post;
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
