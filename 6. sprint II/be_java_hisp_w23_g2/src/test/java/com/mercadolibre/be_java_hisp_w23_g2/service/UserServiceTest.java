package com.mercadolibre.be_java_hisp_w23_g2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
      User userFollower = new User();
      userFollower.setId(2);
      userFollower.setUserName("Alice Smith");
      userFollower.setFollowers(List.of());
      userFollower.setFollowed(List.of());

      User userToFollow = new User();
      userToFollow.setId(1);
      userToFollow.setUserName("John Doe");
      userToFollow.setFollowers(List.of());
      userToFollow.setFollowed(List.of(userFollower));

      when(repository.findUserById(1)).thenReturn(userToFollow);
      when(repository.findUserById(2)).thenReturn(userFollower);
      when(repository.followUser(2, 1)).thenReturn(userToFollow);

      UserFollowedDTO expected = new UserFollowedDTO(1, "John Doe",
              new ArrayList<>(List.of(new UserBasicDTO(2, "Alice Smith"))));

      // ACT
      UserFollowedDTO result = service.followUser(2, 1);

      // ASSERT
      assertEquals(expected, result);
    }
    @Test
    @DisplayName("T-0001: Verify that the user to follow exists. Exception.")
    void followUserExceptionTest() {
      // ARRANGE
      User userFollower = new User();
      userFollower.setId(2);
      userFollower.setUserName("Alice Smith");

      when(repository.findUserById(2)).thenReturn(userFollower);

      // ACT & ASSERT
      assertThrows(NotFoundException.class, () -> {
        service.followUser(2, 1);
      });
    }
    @Test
    @DisplayName("T-0002: Verify that the user to unfollow exists.")
    void unfollowUserTest() {
      // ARRANGE
      User userToUnfollow = new User();
      userToUnfollow.setId(2);
      userToUnfollow.setUserName("Alice Smith");
      userToUnfollow.setFollowers(List.of());
      userToUnfollow.setFollowed(List.of());

      User userFollower = new User();
      userFollower.setId(1);
      userFollower.setUserName("John Doe");
      userFollower.setFollowers(List.of());
      userFollower.setFollowed(List.of(userToUnfollow));

      when(repository.findUserById(1)).thenReturn(userFollower);
      when(repository.findUserById(2)).thenReturn(userToUnfollow);

      String expected = "Has stopped following Alice Smith";

      // ACT
      MessageDTO result = service.unfollowUser(1, 2);

      // ASSERT
      assertNotNull(result);
      assertEquals(expected, result.getMessage());
    }
    @Test
    @DisplayName("T-0002: Verify that the user to unfollow exists. Exception.")
    void unfollowUserExceptionTest() {
      // ARRANGE
      User userFollower = new User();
      userFollower.setId(1);
      userFollower.setUserName("John Doe");

      when(repository.findUserById(1)).thenReturn(userFollower);

      // ACT & ASSERT
      assertThrows(NotFoundException.class, () -> {
        service.unfollowUser(1, 2);
      });
    }

    @Test
    @DisplayName("T-0003: Validates that alphabetical order exists (followed).")
    void getFollowedUserTest() {
      //ARRANGE
      User user_test = new User(1, "melilackington", null, null,
              List.of(new User(54, "zendaya99", null, null, null),
                      new User(96, "tomHoland87", null, null, null)));

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT
      UserFollowedDTO obtain = service.getFollowedUser(1, "name_asc");

      //ASSERT
      assertNotEquals(null, obtain);
    }

    @Test
    @DisplayName("T-0003: Validates that alphabetical order exists (followed). Exception.")
    void getFollowedUserExceptionTest() {
      //ARRANGE
      User user_test = new User(1, "melilackington", null, null,
              List.of(new User(54, "zendaya99", null, null, null),
                      new User(96, "tomHoland87", null, null, null)));

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT && ASSERT
      assertThrows(BadRequestException.class, () -> service.getFollowedUser(1, "cualquier_cosa"));
    }

    @Test
    @DisplayName("T-0003: Validates that alphabetical order exists (followers).")
    void getFollowersUserTest() {
      //ARRANGE
      User user_test = new User(1, "melilackington", null,
              List.of(new User(54, "zendaya99", null, null, null),
                      new User(96, "tomHoland87", null, null, null)), null);

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT
      UserFollowersDTO obtain = service.getFollowersUser(1, "name_asc");

      //ASSERT
      assertNotEquals(null, obtain);
    }

    @Test
    @DisplayName("T-0003: Validates that alphabetical order exists (followed). Exception")
    void getFollowersUserExceptionTest() {
      //ARRANGE
      User user_test = new User(1, "melilackington", null,
              List.of(new User(54, "zendaya99", null, null, null),
                      new User(96, "tomHoland87", null, null, null)), null);

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT && ASSERT
      assertThrows(BadRequestException.class, () -> service.getFollowersUser(1, "cualquier_cosa"));
    }

    @Test
    @DisplayName("T-0004: Validates that alphabetical order exists on getFollowersUser (asc).")
    void getFollowersUserAscTest() {
      //ARRANGE
      User user_test = new User(1, "melilackington", null,
              List.of(new User(54, "zendaya99", null, null, null),
                      new User(96, "tomHoland87", null, null, null)), null);

      UserFollowersDTO expected = new UserFollowersDTO(1, "melilackington",
              List.of(new UserBasicDTO(96, "tomHoland87"), new UserBasicDTO(54, "zendaya99")));

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT

      UserFollowersDTO obtain = service.getFollowersUser(1, "name_asc");

      //ASSERT
      assertEquals(expected, obtain);
    }

    @Test
    @DisplayName("T-0004: Validates that alphabetical order exists on getFollowersUser (desc).")
    void getFollowersUserDescTest() {
      //ARRANGE
      User user_test = new User(1, "melilackington", null,
              List.of(new User(54, "zendaya99", null, null, null),
                      new User(96, "tomHoland87", null, null, null)), null);

      UserFollowersDTO expected = new UserFollowersDTO(1, "melilackington",
              List.of(new UserBasicDTO(54, "zendaya99"), new UserBasicDTO(96, "tomHoland87")));

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT

      UserFollowersDTO obtain = service.getFollowersUser(1, "name_desc");

      //ASSERT
      assertEquals(expected, obtain);
    }

    @Test
    @DisplayName("T-0004: Validates that alphabetical order exists on getFollowersUser. Exception.")
    void getFollowersUserDescExceptionTest() {
      //ARRANGE
      List<User> empty_followers = new ArrayList<>();
      User user_test = new User(1, "melilackington", null, empty_followers, null);

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT && ASSERT
      assertThrows(NotFoundException.class, () -> service.getFollowersUser(1, "name_desc"));
    }

    @Test
    @DisplayName("T-0004: Validates that alphabetical order exists on getFollowedUser (asc).")
    void getFollowedUserAscTest() {
      //ARRANGE
      User user_test = new User(1, "melilackington", null, null,
              List.of(new User(54, "zendaya99", null, null, null),
                      new User(96, "tomHoland87", null, null, null)));

      UserFollowedDTO expected = new UserFollowedDTO(1, "melilackington",
              List.of(new UserBasicDTO(96, "tomHoland87"), new UserBasicDTO(54, "zendaya99")));

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT

      UserFollowedDTO obtain = service.getFollowedUser(1, "name_asc");

      //ASSERT
      assertEquals(expected, obtain);
    }

    @Test
    @DisplayName("T-0004: Validates that alphabetical order exists on getFollowedUser (desc).")
    void getFollowedUserDescTest() {
      //ARRANGE
      User user_test = new User(1, "melilackington", null, null,
              List.of(new User(54, "zendaya99", null, null, null),
                      new User(96, "tomHoland87", null, null, null)));

      UserFollowedDTO expected = new UserFollowedDTO(1, "melilackington",
              List.of(new UserBasicDTO(54, "zendaya99"), new UserBasicDTO(96, "tomHoland87")));

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT

      UserFollowedDTO obtain = service.getFollowedUser(1, "name_desc");

      //ASSERT
      assertEquals(expected, obtain);
    }

    @Test
    @DisplayName("T-0004: Validates that alphabetical order exists on getFollowedUser. Exception.")
    void getFollowedUserDescExceptionTest() {
      //ARRANGE
      List<User> empty_followed = new ArrayList<>();
      User user_test = new User(1, "melilackington", null, null, empty_followed);

      when(repository.findUserById(1)).thenReturn(user_test);

      //ACT && ASSERT
      assertThrows(NotFoundException.class, () -> service.getFollowedUser(1, "name_desc"));
    }

    @Test
    @DisplayName("T-0005: Test method to verify that the type of ascending sort by date exists.")
    void verifyTypeAscSortingExistsTest() {
      // Arrange
      User user = new User();
      User follower1 = new User();
      user.setId(1);
      follower1.setId(2);

      Post post21 = new Post(1, 2, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post22 = new Post(2, 2, LocalDate.now().minusDays(5), new Product(), null, 0.0);

      follower1.setPosts(new ArrayList<>(Arrays.asList(post21, post22)));

      user.setFollowed(List.of(follower1));

      ObjectMapper mapper = new ObjectMapper();
      List<PostBasicDTO> postDTOS = new ArrayList<>(
              Stream.of(post21, post22).map(post -> mapper.convertValue(post, PostBasicDTO.class))
                      .toList());
      postDTOS.sort(Comparator.comparing(PostBasicDTO::getDate));

      PostsFollowedDTO followedDTO = new PostsFollowedDTO(user.getId(), postDTOS);

      when(repository.findUserById(1)).thenReturn(user);
      when(repository.findUserById(2)).thenReturn(follower1);

      // Act
      PostsFollowedDTO result = service.getPostsByFollowedUsers(user.getId(), "date_asc");

      // Assert
      assertNotNull(result);
    }

    @Test
    @DisplayName("T-0005: Test method to verify that the type of descending sort by date exists.")
    void verifyTypeDescSortingExistsTest() {
      // Arrange
      User user = new User();
      User follower1 = new User();
      user.setId(1);
      follower1.setId(2);

      Post post21 = new Post(1, 2, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post22 = new Post(2, 2, LocalDate.now().minusDays(5), new Product(), null, 0.0);

      follower1.setPosts(new ArrayList<>(Arrays.asList(post21, post22)));

      user.setFollowed(List.of(follower1));

      ObjectMapper mapper = new ObjectMapper();
      List<PostBasicDTO> postDTOS = new ArrayList<>(
              Stream.of(post21, post22).map(post -> mapper.convertValue(post, PostBasicDTO.class))
                      .toList());
      postDTOS.sort(Comparator.comparing(PostBasicDTO::getDate).reversed());

      PostsFollowedDTO followedDTO = new PostsFollowedDTO(user.getId(), postDTOS);

      when(repository.findUserById(1)).thenReturn(user);
      when(repository.findUserById(2)).thenReturn(follower1);

      // Act
      PostsFollowedDTO result = service.getPostsByFollowedUsers(user.getId(), "date_desc");

      // Assert
      assertNotNull(result);
    }

    @Test
    @DisplayName("T-0005: Test method to verify that the type of sort by date. Exception.")
    void verifyTypeSortingExistsExceptionTest() {
      // Arrange
      User user = new User();
      User follower1 = new User();
      Integer id = 1;
      user.setId(id);
      follower1.setId(2);

      Post post21 = new Post(1, 2, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post22 = new Post(2, 2, LocalDate.now().minusDays(5), new Product(), null, 0.0);

      follower1.setPosts(new ArrayList<>(Arrays.asList(post21, post22)));

      user.setFollowed(List.of(follower1));

      ObjectMapper mapper = new ObjectMapper();
      List<PostBasicDTO> postDTOS = new ArrayList<>(
              Stream.of(post21, post22).map(post -> mapper.convertValue(post, PostBasicDTO.class))
                      .toList());
      postDTOS.sort(Comparator.comparing(PostBasicDTO::getDate).reversed());

      PostsFollowedDTO followedDTO = new PostsFollowedDTO(user.getId(), postDTOS);

      when(repository.findUserById(1)).thenReturn(user);
      when(repository.findUserById(2)).thenReturn(follower1);

      // Act & Assert
      assertThrows(BadRequestException.class, () -> service.getPostsByFollowedUsers(id, "fake"));
    }

    @Test
    @DisplayName("T-0006: Test method to verify correct ascending order by date.")
    void verifyAscSortingByDateTest() {
      // Arrange
      User user = new User();
      User follower1 = new User();
      User follower2 = new User();
      user.setId(1);
      follower1.setId(2);
      follower2.setId(3);

      Post post21 = new Post(1, 2, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post22 = new Post(2, 2, LocalDate.now().minusDays(5), new Product(), null, 0.0);
      Post post23 = new Post(3, 2, LocalDate.now().minusDays(11), new Product(), null, 0.0);
      Post post24 = new Post(4, 2, LocalDate.now().minusDays(12), new Product(), null, 0.0);

      Post post31 = new Post(1, 3, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post32 = new Post(2, 3, LocalDate.now().minusDays(13), new Product(), null, 0.0);
      Post post33 = new Post(3, 3, LocalDate.now().minusDays(10), new Product(), null, 0.0);

      follower1.setPosts(new ArrayList<>(Arrays.asList(post21, post22, post23, post24)));
      follower2.setPosts(new ArrayList<>(Arrays.asList(post31, post32, post33)));

      user.setFollowed(List.of(follower1, follower2));

      ObjectMapper mapper = new ObjectMapper();
      List<PostBasicDTO> postDTOS = new ArrayList<>(
              Stream.of(post21, post22, post23, post24, post31, post32, post33)
                      .map(post -> mapper.convertValue(post, PostBasicDTO.class)).toList());
      postDTOS.sort(Comparator.comparing(PostBasicDTO::getDate));

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
      User user = new User();
      User follower1 = new User();
      User follower2 = new User();
      user.setId(1);
      follower1.setId(2);
      follower2.setId(3);

      Post post21 = new Post(1, 2, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post22 = new Post(2, 2, LocalDate.now().minusDays(5), new Product(), null, 0.0);
      Post post23 = new Post(3, 2, LocalDate.now().minusDays(11), new Product(), null, 0.0);
      Post post24 = new Post(4, 2, LocalDate.now().minusDays(12), new Product(), null, 0.0);

      Post post31 = new Post(1, 3, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post32 = new Post(2, 3, LocalDate.now().minusDays(13), new Product(), null, 0.0);
      Post post33 = new Post(3, 3, LocalDate.now().minusDays(10), new Product(), null, 0.0);

      follower1.setPosts(new ArrayList<>(Arrays.asList(post21, post22, post23, post24)));
      follower2.setPosts(new ArrayList<>(Arrays.asList(post31, post32, post33)));

      user.setFollowed(List.of(follower1, follower2));

      ObjectMapper mapper = new ObjectMapper();
      List<PostBasicDTO> postDTOS = new ArrayList<>(
              Stream.of(post21, post22, post23, post24, post31, post32, post33)
                      .map(post -> mapper.convertValue(post, PostBasicDTO.class)).toList());
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
      User user = new User();
      user.setId(1);
      user.setUserName("John Doe");

      User follower1 = new User();
      User follower2 = new User();

      follower1.setId(2);
      follower1.setUserName("Alice Smith");
      follower2.setId(3);
      follower2.setUserName("Bob Jones");

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
      User user = new User();
      User follower1 = new User();
      User follower2 = new User();
      user.setId(1);
      follower1.setId(2);
      follower2.setId(3);

      Post post21 = new Post(1, 2, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post22 = new Post(2, 2, LocalDate.now().minusDays(5), new Product(), null, 0.0);
      Post post23 = new Post(3, 2, LocalDate.now().minusDays(14), new Product(), null, 0.0);
      Post post24 = new Post(4, 2, LocalDate.now().minusDays(15), new Product(), null, 0.0);

      Post post31 = new Post(1, 3, LocalDate.now().minusWeeks(1), new Product(), null, 0.0);
      Post post32 = new Post(2, 3, LocalDate.now().minusDays(15), new Product(), null, 0.0);
      Post post33 = new Post(3, 3, LocalDate.now().minusDays(14), new Product(), null, 0.0);

      follower1.setPosts(List.of(post21, post22, post23, post24));
      follower2.setPosts(List.of(post31, post32, post33));

      user.setFollowed(List.of(follower1, follower2));

      ObjectMapper mapper = new ObjectMapper();
      List<PostBasicDTO> postDTOS = Stream.of(post21, post22, post23, post31, post33)
          .map(post -> mapper.convertValue(post, PostBasicDTO.class)).toList();

      PostsFollowedDTO followedDTO = new PostsFollowedDTO(user.getId(), postDTOS);

      when(repository.findUserById(1)).thenReturn(user);
      when(repository.findUserById(2)).thenReturn(follower1);
      when(repository.findUserById(3)).thenReturn(follower2);
      //Act
      PostsFollowedDTO result = service.getPostsByFollowedUsers(user.getId(), null);
      //Assert
      Assertions.assertEquals(followedDTO, result);
    }
}
