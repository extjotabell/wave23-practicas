package com.sprint.be_java_hisp_w23_g04.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private List<Post> posts;
    private List<User> followed;
    private List<User> followers;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int userId, String name, List<Post> posts, List<User> followed, List<User> followers) {
        this.id = userId;
        this.name = name;
        this.posts = posts;
        this.followed = followed;
        this.followers = followers;
    }
}
