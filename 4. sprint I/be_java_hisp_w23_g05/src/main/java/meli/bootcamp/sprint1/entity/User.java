package meli.bootcamp.sprint1.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
  private int id;
  private String name;
  @JsonAlias("isSeller")
  private boolean isSeller;
  private List<Post> posts;
  private List<Integer> followed;
  private List<Integer> followers;

  public void addPost(Post newPost) {
    this.posts.add(newPost);
    this.isSeller = true;
  }

  public void newFollow(Integer userToFollowId) {
    this.followed.add(userToFollowId);
  }

  public void newFollower(Integer userId) {
    this.followers.add(userId);
  }
}
