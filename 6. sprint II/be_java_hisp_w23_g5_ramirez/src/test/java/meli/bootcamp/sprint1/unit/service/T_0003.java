package meli.bootcamp.sprint1.unit.service;

import meli.bootcamp.sprint1.dto.response.UserWFollowerListDto;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.exception.BadRequestException;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import meli.bootcamp.sprint1.service.impl.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static meli.bootcamp.sprint1.utils.Factory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T_0003 {

  @Mock
  GeneralRepository repository;

  @InjectMocks
  UserService service;

  @Test
  @DisplayName("T-0003/ Verify sorted asc list Ok test")
  void T_0003AscTestOk() {

    // Arrange
    User user = generateUser2();
    User follower = generateSeller();
    User follower2 = generateUser();

    when(repository.findUserById(user.getId())).thenReturn(user);
    when(repository.findUserById(follower.getId())).thenReturn(follower);
    when(repository.findUserById(follower2.getId())).thenReturn(follower2);

    // Act
    UserWFollowerListDto response = service.getFollowersById(user.getId(), "name_asc");

    // Assert
    assertEquals("Marco", response.getFollowers().get(0).getUser_name());
    assertEquals("Nico", response.getFollowers().get(1).getUser_name());

  }

  @Test
  @DisplayName("T-0003/ Verify sorted desc list Ok test")
  void T_0003DescTestOk() {

    // Arrange
    User user = generateUser2();
    User follower = generateSeller();
    User follower2 = generateUser();

    when(repository.findUserById(user.getId())).thenReturn(user);
    when(repository.findUserById(follower.getId())).thenReturn(follower);
    when(repository.findUserById(follower2.getId())).thenReturn(follower2);

    // Act
    UserWFollowerListDto response = service.getFollowersById(user.getId(), "name_desc");

    // Assert
    assertEquals("Nico", response.getFollowers().get(0).getUser_name());
    assertEquals("Marco", response.getFollowers().get(1).getUser_name());

  }

  @Test
  @DisplayName("T-0003/ Verify exception test")
  void T_0003ExceptionTest() {

    // Arrange
    User user = generateUser2();
    User follower = generateSeller();
    User follower2 = generateUser();

    when(repository.findUserById(user.getId())).thenReturn(user);
    when(repository.findUserById(follower.getId())).thenReturn(follower);
    when(repository.findUserById(follower2.getId())).thenReturn(follower2);

    // Act
    // Assert
    assertThrows(BadRequestException.class, () -> service.getFollowersById(user.getId(), " "));

  }
}
