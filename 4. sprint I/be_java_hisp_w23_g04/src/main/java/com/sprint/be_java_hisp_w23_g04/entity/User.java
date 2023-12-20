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
}
