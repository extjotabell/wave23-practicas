package meli.bootcamp.sprint1.entity;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
  private int id;
  private String name;
  private List<Post> posts;
  private Set<Integer> followed;
  private Set<Integer> followers;

  public void addPost(Post newPost) {
    this.posts.add(newPost);
  }

  public void newFollow(Integer userToFollowId) {
    this.followed.add(userToFollowId);
  }

  public void newFollower(Integer userId) {
    this.followers.add(userId);
  }

  public void removeFollow(Integer userToUnfollowId) {
    this.followed.remove(userToUnfollowId);
  }

  public void removeFollower(Integer userId) {
    this.followers.remove(userId);
  }

}
