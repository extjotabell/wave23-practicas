package meli.bootcamp.sprint1.unit.service;

import meli.bootcamp.sprint1.dto.response.FollowersDto;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import meli.bootcamp.sprint1.service.impl.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static meli.bootcamp.sprint1.utils.Factory.generateUser;
import static meli.bootcamp.sprint1.utils.Factory.generateUser2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T_0007 {
  @Mock
  GeneralRepository repository;

  @InjectMocks
  UserService service;

  @Test
  @DisplayName("T-0007/ Verify user followers list count")
  void verifyFollowersCount() {
    // Arrange
    User user = generateUser2();

    when(repository.findUserById(user.getId())).thenReturn(user);

    // Act
    FollowersDto followers = service.getFollowersByUserId(user.getId());

    // Assert
    assertEquals(2, followers.getFollowers_count());
  }

  @Test
  @DisplayName("T-0007/ Verify user followers list count equals 0")
  void verifyFollowersCount0() {
    // Arrange
    User user = generateUser();

    when(repository.findUserById(user.getId())).thenReturn(user);

    // Act
    FollowersDto followers = service.getFollowersByUserId(user.getId());

    // Assert
    assertEquals(0, followers.getFollowers_count());
  }
}
