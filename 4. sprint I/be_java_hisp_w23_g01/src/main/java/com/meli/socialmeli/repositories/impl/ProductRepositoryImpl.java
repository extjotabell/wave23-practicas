package com.meli.socialmeli.repositories.impl;

import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.repositories.IProductRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private List<User> users = new ArrayList<>();
    @Override
    public List<Post> getPostsFollowersLastTwoWeeks(List<User> follows) {
        return follows.stream()
                .filter(u -> u.getPosts() != null && !u.getPosts().isEmpty())
                .flatMap(u -> u.getPosts().stream())
                .filter(p -> !p.getDate().isBefore(LocalDate.now().minusWeeks(2)))
                .toList();
    }

}