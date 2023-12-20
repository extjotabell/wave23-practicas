package com.example.be_java_hisp_w23_g3.entity;

import com.example.be_java_hisp_w23_g3.util.ArgumentValidator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Seller extends User {
    private Set<User> followers;

    private Seller(Long id, String username) {
        super(id, username);
        this.followers = new HashSet<>();
    }

    private Seller(Long id, String username, Set<Seller> following) {
        super(id, username, following);
        this.followers = new HashSet<>();
    }

    private Seller(Long id, String username, Set<Seller> following, Set<User> followers) {
        super(id, username, following);
        this.followers = followers;
    }

    public static Seller build(User user, Set<User> followers) {
        ArgumentValidator.validateRequired(followers, "Follower is required");
        return new Seller(user.getId(), user.getUsername(), user.getFollowing(), followers);
    }

    public static Seller build(User user) {
        return new Seller(user.getId(), user.getUsername(), user.getFollowing());
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }
}
