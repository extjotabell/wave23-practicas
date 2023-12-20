package com.example.be_java_hisp_w23_g3.entity;

import com.example.be_java_hisp_w23_g3.util.ArgumentValidator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Seller extends User {
    private Set<User> follower;
    private Map<Long, Post> posts;

    private Seller(Long id, String username) {
        super(id, username);
        this.follower = new HashSet<>();
        this.posts = new HashMap<>();
    }

    private Seller(Long id, String username, Set<Seller> following) {
        super(id, username, following);
        this.follower = new HashSet<>();
        this.posts = new HashMap<>();
    }

    private Seller(Long id, String username, Set<Seller> following, Set<User> follower, Map<Long, Post> posts) {
        super(id, username, following);
        this.follower = follower;
        this.posts = posts;
    }

    public static Seller build(User user) {
        return new Seller(user.getId(), user.getUsername(), user.getFollowing());
    }

    public static Seller build(User user, Set<User> follower,Map<Long, Post> posts) {
        ArgumentValidator.validateRequired(posts, "Posts is required");
        ArgumentValidator.validateRequired(follower, "Follower is required");
        return new Seller(user.getId(), user.getUsername(), user.getFollowing(), follower, posts);
    }

    public Set<User> getFollower() {
        return follower;
    }

    public Map<Long, Post> getPosts() {
        return posts;
    }

    public void setFollower(Set<User> follower) {
        this.follower = follower;
    }

    public void setPosts(Map<Long, Post> posts) {
        this.posts = posts;
    }
}