package com.mercadolibre.be_java_hisp_w23_g2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Cloneable{

    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String userName;
    private List<Post> posts;
    private List<User> followers;
    private List<User> followed;

    @Override
    public User clone() {
        try {
            User clone = (User) super.clone();

            // Perform deep copy for posts list
            if (this.posts != null) {
                clone.posts = new ArrayList<>();
                clone.posts.addAll(this.posts);
            }

            // Perform deep copy for followers list
            if (this.followers != null) {
                clone.followers = new ArrayList<>();
                clone.followers.addAll(this.followers);
            }

            // Perform deep copy for followed list
            if (this.followed != null) {
                clone.followed = new ArrayList<>();
                clone.followed.addAll(this.followed);
            }

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
