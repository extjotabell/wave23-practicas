package com.mercadolibre.be_java_hisp_w23_g2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.mercadolibre.be_java_hisp_w23_g2.dto.PostBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.PostsFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Product;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w23_g2.repository.UserRepository;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Mapper;
import com.mercadolibre.be_java_hisp_w23_g2.utils.ObjectCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  UserRepository repository;

  @InjectMocks
  UserService service;

  @Test
  @DisplayName("T-0001: Verify that the user to follow exists.")
  void followUserTest() {
    // ARRANGE
    User userFollower = ObjectCreator.createUser(2, "Alice Smith");
    User userToFollow = ObjectCreator.createUser(1, "John Doe");
    userToFollow.setFollowed(List.of(userFollower));

    when(repository.findUserById(1)).thenReturn(userToFollow);
    when(repository.findUserById(2)).thenReturn(userFollower);
    when(repository.followUser(2, 1)).thenReturn(userToFollow);

    UserFollowedDTO expected = new UserFollowedDTO(1, "John Doe",
        List.of(new UserBasicDTO(2, "Alice Smith")));

    // ACT
    UserFollowedDTO result = service.followUser(2, 1);

    // ASSERT
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("T-0001: Verify that the user to follow exists. Exception.")
  void followUserExceptionTest() {
    // ARRANGE
    User userFollower = ObjectCreator.createUser(2);
    Integer userId = userFollower.getId();

    when(repository.findUserById(2)).thenReturn(userFollower);

    // ACT & ASSERT
    assertThrows(NotFoundException.class, () -> service.followUser(userId, 1));
  }

  @Test
  @DisplayName("T-0002: Verify that the user to unfollow exists.")
  void unfollowUserTest() {
    // ARRANGE
    User userToUnfollow = ObjectCreator.createUser(2, "Alice Smith");
    User userFollower = ObjectCreator.createUser(1, "John Doe");
    userFollower.setFollowed(List.of(userToUnfollow));

    when(repository.findUserById(1)).thenReturn(userFollower);
    when(repository.findUserById(2)).thenReturn(userToUnfollow);
    when(repository.unfollowUser(userFollower, userToUnfollow)).thenReturn(userToUnfollow);

    String expected = "Has stopped following Alice Smith";

    // ACT
    MessageDTO result = service.unfollowUser(1, 2);

    // ASSERT
    assertEquals(expected, result.getMessage());
  }

  @Test
  @DisplayName("T-0002: Verify that the user to unfollow exists. Exception.")
  void unfollowUserExceptionTest() {
    // ARRANGE
    User userFollower = ObjectCreator.createUser(1, "John Doe");
    Integer userId = userFollower.getId();

    when(repository.findUserById(1)).thenReturn(userFollower);

    // ACT & ASSERT
    assertThrows(NotFoundException.class, () -> service.unfollowUser(userId, 2));
  }

  @Test
  @DisplayName("T-0003: Validates that alphabetical order exists (followed).")
  void getFollowedUserTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    user.setFollowed(List.of(ObjectCreator.createUser(2, "Alice Smith")));

    when(repository.findUserById(1)).thenReturn(user);

    //ACT
    UserFollowedDTO obtain = service.getFollowedUser(1, "name_asc");

    //ASSERT
    assertNotNull(obtain);
  }

  @Test
  @DisplayName("T-0003: Validates that alphabetical order exists (followed). Exception.")
  void getFollowedUserExceptionTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    user.setFollowed(List.of(ObjectCreator.createUser(2, "Alice Smith")));
    Integer userId = user.getId();

    when(repository.findUserById(1)).thenReturn(user);

    //ACT && ASSERT
    assertThrows(BadRequestException.class,
        () -> service.getFollowedUser(userId, "cualquier_cosa"));
  }

  @Test
  @DisplayName("T-0003: Validates that alphabetical order exists (followers).")
  void getFollowersUserTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    user.setFollowers(List.of(ObjectCreator.createUser(3, "Bob Jones")));
    Integer userId = user.getId();

    when(repository.findUserById(1)).thenReturn(user);

    //ACT
    UserFollowersDTO obtain = service.getFollowersUser(userId, "name_asc");

    //ASSERT
    assertNotNull(obtain);
  }

  @Test
  @DisplayName("T-0003: Validates that alphabetical order exists (followed). Exception")
  void getFollowersUserExceptionTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    user.setFollowers(List.of(ObjectCreator.createUser(2, "Alice Smith")));
    Integer userId = user.getId();

    when(repository.findUserById(1)).thenReturn(user);

    //ACT && ASSERT
    assertThrows(BadRequestException.class,
        () -> service.getFollowersUser(userId, "cualquier_cosa"));
  }

  @Test
  @DisplayName("T-0004: Validates that alphabetical order exists on getFollowersUser (asc).")
  void getFollowersUserAscTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    user.setFollowers(List.of(ObjectCreator.createUser(3, "Bob Jones"),
        ObjectCreator.createUser(2, "Alice Smith")));

    UserFollowersDTO expected = new UserFollowersDTO(1, "John Doe",
        List.of(new UserBasicDTO(2, "Alice Smith"), new UserBasicDTO(3, "Bob Jones")));

    when(repository.findUserById(1)).thenReturn(user);

    //ACT
    UserFollowersDTO obtain = service.getFollowersUser(1, "name_asc");

    //ASSERT
    assertEquals(expected, obtain);
  }

  @Test
  @DisplayName("T-0004: Validates that alphabetical order exists on getFollowersUser (desc).")
  void getFollowersUserDescTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    user.setFollowers(List.of(ObjectCreator.createUser(2, "Alice Smith"),
        ObjectCreator.createUser(3, "Bob Jones")));

    UserFollowersDTO expected = new UserFollowersDTO(1, "John Doe",
        List.of(new UserBasicDTO(3, "Bob Jones"), new UserBasicDTO(2, "Alice Smith")));

    when(repository.findUserById(1)).thenReturn(user);

    //ACT
    UserFollowersDTO obtain = service.getFollowersUser(1, "name_desc");

    //ASSERT
    assertEquals(expected, obtain);
  }

  @Test
  @DisplayName("T-0004: Validates that alphabetical order exists on getFollowersUser. Exception.")
  void getFollowersUserDescExceptionTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    Integer userId = user.getId();

    when(repository.findUserById(1)).thenReturn(user);

    //ACT && ASSERT
    assertThrows(NotFoundException.class, () -> service.getFollowersUser(userId, "name_desc"));
  }

  @Test
  @DisplayName("T-0004: Validates that alphabetical order exists on getFollowedUser (asc).")
  void getFollowedUserAscTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    user.setFollowed(List.of(ObjectCreator.createUser(3, "Bob Jones"),
        ObjectCreator.createUser(2, "Alice Smith")));

    UserFollowedDTO expected = new UserFollowedDTO(1, "John Doe",
        List.of(new UserBasicDTO(2, "Alice Smith"), new UserBasicDTO(3, "Bob Jones")));

    when(repository.findUserById(1)).thenReturn(user);

    //ACT
    UserFollowedDTO obtain = service.getFollowedUser(1, "name_asc");

    //ASSERT
    assertEquals(expected, obtain);
  }

  @Test
  @DisplayName("T-0004: Validates that alphabetical order exists on getFollowedUser (desc).")
  void getFollowedUserDescTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    user.setFollowed(List.of(ObjectCreator.createUser(2, "Alice Smith"),
        ObjectCreator.createUser(3, "Bob Jones")));

    UserFollowedDTO expected = new UserFollowedDTO(1, "John Doe",
        List.of(new UserBasicDTO(3, "Bob Jones"), new UserBasicDTO(2, "Alice Smith")));

    when(repository.findUserById(1)).thenReturn(user);

    //ACT
    UserFollowedDTO obtain = service.getFollowedUser(1, "name_desc");

    //ASSERT
    assertEquals(expected, obtain);
  }

  @Test
  @DisplayName("T-0004: Validates that alphabetical order exists on getFollowedUser. Exception.")
  void getFollowedUserDescExceptionTest() {
    //ARRANGE
    User user = ObjectCreator.createUser(1, "John Doe");
    Integer userId = user.getId();

    when(repository.findUserById(1)).thenReturn(user);

    //ACT && ASSERT
    assertThrows(NotFoundException.class, () -> service.getFollowedUser(userId, "name_desc"));
  }

  @Test
  @DisplayName("T-0005: Test method to verify that the type of ascending sort by date exists.")
  void verifyTypeAscSortingExistsTest() {
    // Arrange
    User user = ObjectCreator.createUser(1);
    User follower = ObjectCreator.createUser(2);
    user.setFollowed(List.of(follower));

    Post post21 = ObjectCreator.createPost(1, 2, LocalDate.now().minusWeeks(1));
    Post post22 = ObjectCreator.createPost(2, 2, LocalDate.now().minusWeeks(5));

    follower.setPosts(List.of(post21, post22));

    when(repository.findUserById(1)).thenReturn(user);
    when(repository.findUserById(2)).thenReturn(follower);

    // Act
    PostsFollowedDTO result = service.getPostsByFollowedUsers(user.getId(), "date_asc");

    // Assert
    assertNotNull(result);
  }

  @Test
  @DisplayName("T-0005: Test method to verify that the type of descending sort by date exists.")
  void verifyTypeDescSortingExistsTest() {
    // Arrange
    User user = ObjectCreator.createUser(1);
    User follower = ObjectCreator.createUser(2);
    user.setFollowers(List.of(follower));

    Post post21 = ObjectCreator.createPost(1, 2, LocalDate.now().minusWeeks(1));
    Post post22 = ObjectCreator.createPost(2, 2, LocalDate.now().minusWeeks(5));

    follower.setPosts(List.of(post21, post22));
    user.setFollowed(List.of(follower));

    when(repository.findUserById(1)).thenReturn(user);
    when(repository.findUserById(2)).thenReturn(follower);

    // Act
    PostsFollowedDTO result = service.getPostsByFollowedUsers(user.getId(), "date_desc");

    // Assert
    assertNotNull(result);
  }

  @Test
  @DisplayName("T-0005: Test method to verify that the type of sort by date. Exception.")
  void verifyTypeSortingExistsExceptionTest() {
    // Arrange
    User user = ObjectCreator.createUser(1);
    User follower = ObjectCreator.createUser(2);
    user.setFollowers(List.of(follower));

    Post post21 = ObjectCreator.createPost(1, 2, LocalDate.now().minusWeeks(1));
    Post post22 = ObjectCreator.createPost(2, 2, LocalDate.now().minusWeeks(5));

    follower.setPosts(List.of(post21, post22));
    user.setFollowed(List.of(follower));

    when(repository.findUserById(1)).thenReturn(user);
    when(repository.findUserById(2)).thenReturn(follower);

    // Act & Assert
    assertThrows(BadRequestException.class, () -> service.getPostsByFollowedUsers(1, "fake"));
  }

  @Test
  @DisplayName("T-0006: Test method to verify correct ascending order by date.")
  void verifyAscSortingByDateTest() {
    // Arrange
    User user = ObjectCreator.createUser(1);
    User follower1 = ObjectCreator.createUser(2);
    User follower2 = ObjectCreator.createUser(3);
    user.setFollowed(List.of(follower1, follower2));

    Post post21 = new Post(1, 2, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
    Post post22 = new Post(2, 2, LocalDate.now().minusDays(5), new Product(), null, 0.0);
    Post post23 = new Post(3, 2, LocalDate.now().minusDays(11), new Product(), null, 0.0);
    Post post24 = new Post(4, 2, LocalDate.now().minusDays(12), new Product(), null, 0.0);

    Post post31 = new Post(1, 3, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
    Post post32 = new Post(2, 3, LocalDate.now().minusDays(13), new Product(), null, 0.0);
    Post post33 = new Post(3, 3, LocalDate.now().minusDays(10), new Product(), null, 0.0);

    follower1.setPosts(List.of(post21, post22, post23, post24));
    follower2.setPosts(List.of(post31, post32, post33));

    List<PostBasicDTO> postDTOS = Stream.of(post21, post22, post23, post24, post31, post32, post33)
        .map(Mapper::mapPostToPostBasicDTO).sorted(Comparator.comparing(PostBasicDTO::getDate))
        .collect(Collectors.toList());

    PostsFollowedDTO followedDTO = new PostsFollowedDTO(user.getId(), postDTOS);

    when(repository.findUserById(1)).thenReturn(user);
    when(repository.findUserById(2)).thenReturn(follower1);
    when(repository.findUserById(3)).thenReturn(follower2);

    // Act
    PostsFollowedDTO result = service.getPostsByFollowedUsers(user.getId(), "date_asc");

    // Assert
    assertEquals(followedDTO, result);
  }

  @Test
  @DisplayName("T-0006: Test method to verify correct descending order by date.")
  void verifyDescSortingByDateTest() {
    // Arrange
    User user = ObjectCreator.createUser(1);
    User follower1 = ObjectCreator.createUser(2);
    User follower2 = ObjectCreator.createUser(3);
    user.setFollowed(List.of(follower1, follower2));

    Post post21 = ObjectCreator.createPost(LocalDate.now().minusWeeks(1));
    Post post22 = ObjectCreator.createPost(LocalDate.now().minusDays(5));
    Post post23 = ObjectCreator.createPost(LocalDate.now().minusDays(11));
    Post post24 = ObjectCreator.createPost(LocalDate.now().minusDays(12));

    Post post31 = ObjectCreator.createPost(LocalDate.now().minusWeeks(1));
    Post post32 = ObjectCreator.createPost(LocalDate.now().minusDays(13));
    Post post33 = ObjectCreator.createPost(LocalDate.now().minusDays(10));

    follower1.setPosts(List.of(post21, post22, post23, post24));
    follower2.setPosts(List.of(post31, post32, post33));

    List<PostBasicDTO> postDTOS = new ArrayList<>(
        Stream.of(post21, post22, post23, post24, post31, post32, post33)
            .map(Mapper::mapPostToPostBasicDTO).toList());
    postDTOS.sort(Comparator.comparing(PostBasicDTO::getDate).reversed());

    PostsFollowedDTO followedDTO = new PostsFollowedDTO(user.getId(), postDTOS);

    when(repository.findUserById(1)).thenReturn(user);
    when(repository.findUserById(2)).thenReturn(follower1);
    when(repository.findUserById(3)).thenReturn(follower2);

    // Act
    PostsFollowedDTO result = service.getPostsByFollowedUsers(user.getId(), "date_desc");

    // Assert
    assertEquals(followedDTO, result);
  }

  @DisplayName("T-0007: Followers count seller OK.")
  @Test
  void getFollowersCountSellerTest() {
    //Arrange
    User user = ObjectCreator.createUser(1);
    User follower1 = ObjectCreator.createUser(2);
    User follower2 = ObjectCreator.createUser(3);
    user.setFollowers(List.of(follower1, follower2));

    when(repository.findUserById(user.getId())).thenReturn(user);

    // Act
    UserFollowersCountDTO expectedResult = service.getFollowersCountSeller(user.getId());

    // Assert
    Assertions.assertEquals(user.getFollowers().size(), expectedResult.getFollowersCount());
  }

  @Test
  @DisplayName("T-0008: Test method to obtain posts with the last two weeks old.")
  void getPostsWithLastTwoWeeksOld() {
    //Arrange
    User user = ObjectCreator.createUser(1);
    User follower1 = ObjectCreator.createUser(2);
    User follower2 = ObjectCreator.createUser(3);
    user.setFollowed(List.of(follower1, follower2));

    Post postRecent1 = ObjectCreator.createPostRecent();
    Post postRecent2 = ObjectCreator.createPostRecent();
    Post postRecent3 = ObjectCreator.createPostRecent();
    Post postOld1 = ObjectCreator.createPostOld();

    Post postRecent4 = ObjectCreator.createPostRecent();
    Post postOld2 = ObjectCreator.createPostOld();
    Post postRecent5 = ObjectCreator.createPostRecent();

    follower1.setPosts(List.of(postRecent1, postRecent2, postRecent3, postOld1));
    follower2.setPosts(List.of(postRecent4, postOld2, postRecent5));

    PostsFollowedDTO followedDTO = Mapper.mapPostFollowedDTO(1,
        List.of(postRecent1, postRecent2, postRecent3, postRecent4, postRecent5));

    when(repository.findUserById(1)).thenReturn(user);
    when(repository.findUserById(2)).thenReturn(follower1);
    when(repository.findUserById(3)).thenReturn(follower2);
    //Act
    PostsFollowedDTO result = service.getPostsByFollowedUsers(user.getId(), null);
    //Assert
    Assertions.assertEquals(followedDTO, result);
  }
}
