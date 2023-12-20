package com.example.be_java_hisp_w23_g3.entity;

import com.example.be_java_hisp_w23_g3.util.ArgumentValidator;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final Long id;
    private String username;
    private Set<Seller> following;

    protected User(Long id, String username) {
        this.id = id;
        this.username = username;
        this.following = new HashSet<>();
    }

    protected User(Long id, String username, Set<Seller> following) {
        this.id = id;
        this.username = username;
        this.following = following;
    }

    public static User build(Long id, String username) {
        ArgumentValidator.validateRequired(id, "Id is required");
        ArgumentValidator.validateRequired(username, "Username is required");
        ArgumentValidator.validateMinLength(username, 5, "Username must have at least 5 characters");
        return new User(id, username);
    }

    public static User build(Long id, String username, Set<Seller> following) {
        ArgumentValidator.validateRequired(id, "Id is required");
        ArgumentValidator.validateRequired(username, "Username is required");
        ArgumentValidator.validateMinLength(username, 5, "Username must have at least 5 characters");
        ArgumentValidator.validateRequired(following, "Following is required");
        return new User(id, username, following);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<Seller> getFollowing() {
        return following;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFollowing(Set<Seller> following) {
        this.following = following;
    }
}
