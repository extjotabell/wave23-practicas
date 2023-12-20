package com.example.be_java_hisp_w23_g3.repository.post;

import com.example.be_java_hisp_w23_g3.entity.Post;
import com.example.be_java_hisp_w23_g3.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final List<Post> posts;

    public PostRepositoryImpl() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void create(Post entity) {
        posts.add(entity);
    }

    @Override
    public Optional<Post> read(String s) {
        return posts.stream().filter(post -> post.getId().equals(s)).findFirst();
    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(String s) {
        posts.removeIf(post -> post.getId().equals(s));
    }

    @Override
    public List<Post> readBatchBySellerId(Long sellerId) {
        return posts.stream().filter(post -> post.getSeller().getId().equals(sellerId)).toList();
    }

    @Override
    public List<Post> readBatchBySellerIds(List<Long> sellerIds) {
        return posts.stream().filter(post -> sellerIds.contains(post.getSeller().getId())).toList();
    }
}
