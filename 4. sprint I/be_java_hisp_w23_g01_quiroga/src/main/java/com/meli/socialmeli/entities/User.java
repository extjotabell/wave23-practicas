package com.meli.socialmeli.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer user_id;
    private String user_name;
    private List<User> followers;
    private List<User> followed;
    private List<Post> posts;

    public User(Integer user_id, String user_name){
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addFollower(User follower){
        this.followers.add(follower);
    }

    public void addFollowed(User followed){
        this.followed.add(followed);
    }

    public void addPost(Post post){ this.posts.add(post); }

}
