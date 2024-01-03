package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.PostsFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFollowingException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w23_g2.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Mapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Service class for handling user-related operations.
 */
@Service
public class UserService implements IUserService {

  private static final String USER_TYPE = "Current";
  private static final String PARAMETER_INVALID = "The entered parameter is invalid.";
  private final IUserRepository userRepository;

  public UserService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Retrieves the count of followers for a specified user.
   *
   * @param userId The ID of the user.
   * @return UserFollowersCountDTO containing the count of followers.
   */
  @Override
  public UserFollowersCountDTO getFollowersCountSeller(Integer userId) {
    User user = userRepository.findUserById(userId);
    validateUserExistence(user, userId, USER_TYPE);

    return Mapper.mapUserFollowersCountDTO(user);
  }

  /**
   * Retrieves a list of all users.
   *
   * @return List of UserDTOs representing all users.
   */
  public List<UserBasicDTO> getAll() {
    List<User> users = userRepository.getAll();

    return users.stream().map(Mapper::mapUserDTO).toList();
  }

  /**
   * Retrieves the followers of a specified user.
   *
   * @param userId   The ID of the user.
   * @param sortType The sorting type for the followers list.
   * @return UserFollowersDTO containing the list of followers.
   */
  @Override
  public UserFollowersDTO getFollowersUser(Integer userId, String sortType) {
    User user = userRepository.findUserById(userId);
    validateUserExistence(user, userId, USER_TYPE);

    if (user.getFollowers().isEmpty()) {
      throw new NotFoundException("User with id = " + userId + " has no followers");
    }
    if (sortType != null) {
      user.setFollowers(userSortHandler(new ArrayList<>(user.getFollowers()), sortType));
    }
    return Mapper.mapUserFollowersDTO(user);
  }

  /**
   * Retrieves the users followed by a specified user.
   *
   * @param userId   The ID of the user.
   * @param sortType The sorting type for the followed users list.
   * @return UserFollowedDTO containing the list of followed users.
   */
  @Override
  public UserFollowedDTO getFollowedUser(Integer userId, String sortType) {
    User user = userRepository.findUserById(userId);
    validateUserExistence(user, userId, USER_TYPE);

    checkIfUserHasFollowed(user);

    if (sortType != null) {
      user.setFollowed(userSortHandler(new ArrayList<>(user.getFollowed()), sortType));
    }

    return Mapper.mapUserFollowedDTO(user);
  }

  /**
   * Unfollows a user.
   *
   * @param userId           The ID of the user initiating the unfollow.
   * @param userIdToUnfollow The ID of the user to be unfollowed.
   * @return MessageDTO indicating the success of the unfollow operation.
   */
  @Override
  public MessageDTO unfollowUser(Integer userId, Integer userIdToUnfollow) {
    validateThatItIsNotTheSameUser(userId, userIdToUnfollow);

    User currentUser = userRepository.findUserById(userId);
    validateUserExistence(currentUser, userId, USER_TYPE);

    User userToUnfollow = userRepository.findUserById(userIdToUnfollow);
    validateUserExistence(userToUnfollow, userIdToUnfollow, "To unfollow");

    validateFollowing(currentUser, userIdToUnfollow);

    userToUnfollow = userRepository.unfollowUser(currentUser, userToUnfollow);

    return new MessageDTO("Has stopped following " + userToUnfollow.getUserName());
  }

  /**
   * Follows a user.
   *
   * @param userId         The ID of the user initiating the follow.
   * @param userIdToFollow The ID of the user to be followed.
   * @return UserFollowedDTO containing the updated list of followed users.
   */
  @Override
  public UserFollowedDTO followUser(Integer userId, Integer userIdToFollow) {
    validateThatItIsNotTheSameUser(userId, userIdToFollow);

    User user = userRepository.findUserById(userId);
    validateUserExistence(user, userId, USER_TYPE);

    User user2 = userRepository.findUserById(userIdToFollow);
    validateUserExistence(user2, userIdToFollow, "To Follow");

    if (user.getFollowed().contains(userRepository.findUserById(userIdToFollow))) {
      throw new BadRequestException("The user " + userId + " already follow " + userIdToFollow);
    }

    return Mapper.mapUserFollowedDTO(userRepository.followUser(userId, userIdToFollow));
  }

  /**
   * Retrieves posts from users followed by a specified user.
   *
   * @param userId   The ID of the user.
   * @param sortType The sorting type for the posts list.
   * @return PostFollowedDTO containing the list of posts from followed users.
   */
  @Override
  public PostsFollowedDTO getPostsByFollowedUsers(Integer userId, String sortType) {
    User user = userRepository.findUserById(userId);
    validateUserExistence(user, userId, USER_TYPE);

    checkIfUserHasFollowed(user);

    LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
    List<Post> allPost = new ArrayList<>();

    for (User followedUser : user.getFollowed()) {
      User userf = userRepository.findUserById(followedUser.getId());
      validateUserExistence(userf, followedUser.getId(), "Followed");

      if (userf.getPosts() == null || userf.getPosts().isEmpty()) {
        throw new NotFoundException(
            "User followed with id = " + followedUser.getId() + " has no post");
      }
      for (Post postF : userf.getPosts()) {
        if (postF.getDate().isAfter(twoWeeksAgo) || postF.getDate().isEqual(twoWeeksAgo)) {
          allPost.add(postF);
        }
      }
    }
    if (sortType != null) {
      postSortHandler(allPost, sortType);
    }

    return Mapper.mapPostFollowedDTO(user.getId(), allPost);
  }

  /**
   * Handles sorting of posts based on the specified sort type.
   *
   * @param posts    The list of posts to be sorted.
   * @param sortType The sorting type for the posts list.
   */
  private void postSortHandler(List<Post> posts, String sortType) {
    String[] attributes = sortType.split("_");
    if (attributes.length < 2) {
      throw new BadRequestException(PARAMETER_INVALID);
    }
    if ("date".equals(attributes[0])) {
      if ("asc".equals(attributes[1])) {
        posts.sort(Comparator.comparing(Post::getDate));
      } else if ("desc".equals(attributes[1])) {
        posts.sort(Comparator.comparing(Post::getDate).reversed());
      } else {
        throw new BadRequestException(PARAMETER_INVALID);
      }
    } else {
      throw new BadRequestException(PARAMETER_INVALID);
    }
  }

  /**
   * Handles sorting of users based on the specified sort type.
   *
   * @param user     The list of users to be sorted.
   * @param sortType The sorting type for the users list.
   * @return The sorted list of users.
   */
  private List<User> userSortHandler(List<User> user, String sortType) {
    String[] attributes = sortType.split("_");
    if (attributes.length < 2) {
      throw new BadRequestException(PARAMETER_INVALID);
    }
    if ("name".equals(attributes[0])) {
      if ("asc".equals(attributes[1])) {
        user.sort(Comparator.comparing(User::getUserName));
      } else if ("desc".equals(attributes[1])) {
        user.sort(Comparator.comparing(User::getUserName).reversed());
      } else {
        throw new BadRequestException(PARAMETER_INVALID);
      }
    } else {
      throw new BadRequestException(PARAMETER_INVALID);
    }
    return user;
  }

  private void checkIfUserHasFollowed(User user) {
    if (user.getFollowed() == null || user.getFollowed().isEmpty()) {
      throw new NotFoundException("User with id = " + user.getId() + " has no followed");
    }
  }

  private void validateThatItIsNotTheSameUser(int userId, int userId2) {
    if (userId == userId2) {
      throw new BadRequestException("A user cannot follow/unfollow himself");
    }
  }

  private void validateUserExistence(User user, int userId, String userType) {
    if (user == null) {
      throw new NotFoundException(
          String.format("%s user with id = %d not exists.", userType, userId));
    }
  }

  private void validateFollowing(User currentUser, int userIdToUnfollow) {
    if (currentUser.getFollowed() == null ||
        currentUser.getFollowed().stream().filter(user -> user.getId() == userIdToUnfollow)
            .findFirst().orElse(null) == null) {
      throw new NotFollowingException("The current user does not follow the user to unfollow.");
    }

  }

}
