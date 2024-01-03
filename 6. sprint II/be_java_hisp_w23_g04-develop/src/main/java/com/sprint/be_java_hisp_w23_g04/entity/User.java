package com.sprint.be_java_hisp_w23_g04.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    @JsonProperty("posts_id")
    private List<Integer> postsId = new ArrayList<>();
    @JsonProperty("followed_id")
    private List<Integer> followedId = new ArrayList<>();
    @JsonProperty("followers_id")
    private List<Integer> followersId = new ArrayList<>();
}
