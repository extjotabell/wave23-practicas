package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.response.FollowersCountDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.UserFollowedDTO;
import com.meli.socialmeli.dtos.response.UserFollowersDTO;
import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.exceptions.custom.DataSourceException;
import com.meli.socialmeli.exceptions.custom.NotFoundException;
import com.meli.socialmeli.repositories.IUserRepository;
import com.meli.socialmeli.services.impl.UserServiceImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

import util.UserDTOUtilsGenerator;
import util.UserEntityUtilsGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.util.ResourceUtils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import static util.UserEntityUtilsGenerator.userStaticTest;
import static util.UserEntityUtilsGenerator.userToUnfollowStaticTest;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    private List<User> loadTestUsers(){
        List<User> userList;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            File file= ResourceUtils.getFile("classpath:static/users-2.json");
            userList = objectMapper.readValue(file,new TypeReference<List<User>>(){});
        } catch (IOException e) {
            throw new DataSourceException("There is an internal problem with the connection to the data source.");
        }
        return userList;
    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista. Todo ok")
    void followSellerOk(){
        //Arrange
        int userIdFollower = 100;
        int userIdFollowed = 1100;
        MessageDTO expected = new MessageDTO();
        expected.setMessage("Usuario seguido agregado");
        List<User> userList = loadTestUsers();
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        //Act
        MessageDTO result = userService.followSeller(userIdFollower, userIdFollowed);
        //Assert
        Assertions.assertEquals(expected.getMessage(), result.getMessage());
        Assertions.assertEquals(1, userList.get(0).getFollowed().size());
    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista. Usuario a seguir no encontrado")
    void followSellerInvalidFollowed(){
        //Arrange
        int userIdFollower = 100;
        int userIdFollowed = 9999;
        String expectedMessage = "Usuario a seguir no encontrado";
        List<User> userList = loadTestUsers();
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        //Act & Assert
        Exception e = Assertions.assertThrows(BadRequestException.class, () -> {
            userService.followSeller(userIdFollower, userIdFollowed);
        });
        Assertions.assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista. Usuario seguidor no encontrado")
    void followSellerInvalidFollower(){
        //Arrange
        int userIdFollower = 9999;
        int userIdFollowed = 100;
        String expectedMessage = "Usuario seguidor no encontrado";
        List<User> userList = loadTestUsers();
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        //Act & Assert
        Exception e = Assertions.assertThrows(BadRequestException.class, () -> {
            userService.followSeller(userIdFollower, userIdFollowed);
        });
        Assertions.assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista. Vendedor ya seguido")
    void followSellerAlreadyFollowed(){
        //Arrange
        List<User> userList = loadTestUsers();
        int userIdFollower = userList.get(0).getUser_id();
        int userIdFollowed = userList.get(1).getUser_id();
        userList.get(0).addFollowed(userList.get(1));
        userList.get(1).addFollower(userList.get(0));
        String expectedMessage = "El usuario ya sigue al usuario deseado";
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        //Act & Assert
        Exception e = Assertions.assertThrows(BadRequestException.class, () -> {
            userService.followSeller(userIdFollower, userIdFollowed);
        });
        Assertions.assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista. Usuario a seguir sin posts")
    void followSellerWithoutPosts(){
        //Arrange
        List<User> userList = loadTestUsers();
        int userIdFollower = 100;
        int userIdFollowed = 5100;
        String expectedMessage = "Usuario inválido para seguir";
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        //Act & Assert
        Exception e = Assertions.assertThrows(BadRequestException.class, () -> {
            userService.followSeller(userIdFollower, userIdFollowed);
        });
        Assertions.assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista. Usuario siguiéndose a sí mismo")
    void followSellerSameUser(){
        //Arrange
        List<User> userList = loadTestUsers();
        int userIdFollower = 100;
        int userIdFollowed = 100;
        String expectedMessage = "Usuario inválido para seguir";
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        //Act & Assert
        Exception e = Assertions.assertThrows(BadRequestException.class, () -> {
            userService.followSeller(userIdFollower, userIdFollowed);
        });
        Assertions.assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    @DisplayName("T-0002 Verificar que el usuario a dejar de seguir exista. Permite continuar con normalidad.")
    void testUnfollowUser_UserToUnfollowDoesExist() {
        // Arrange
        int userId = 100;
        int userIdToUnfollow = 2100;

        User user = userStaticTest();
        User userToUnfollow = userToUnfollowStaticTest();

        user.getFollowed().add(userToUnfollow);
        userToUnfollow.getFollowers().add(user);

        // Act
        when(userRepository.finById(userId)).thenReturn(user);
        when(userRepository.finById(userIdToUnfollow)).thenReturn(userToUnfollow);

        // Assert
        assertDoesNotThrow(() -> userService.unfollowUser(userId, userIdToUnfollow));
    }

    @Test
    @DisplayName("T-0002 Verificar que el usuario a dejar de seguir exista. Notifica la no existencia mediante una excepción.")
    void testUnfollowUser_UserToUnfollowDoesNotExist() {
        // Arrange
        int userId = 100;
        int userIdToUnfollow = 2100;

        // Act
        when(userRepository.finById(userId)).thenReturn(userStaticTest());
        when(userRepository.finById(userIdToUnfollow)).thenReturn(null);

        // Assert
        assertThrows(NotFoundException.class, () -> userService.unfollowUser(userId, userIdToUnfollow));
    }

    @Test
    @DisplayName("T-0002 Verificar que el usuario a dejar de seguir exista. Usuario no existe, notifica mediante excepción.")
    void testUnfollowUser_UserDoesNotExists() {
        // Arrange
        int userId = 100;
        int userIdToUnfollow = 2100;

        // Act
        when(userRepository.finById(userId)).thenReturn(null);
        when(userRepository.finById(userIdToUnfollow)).thenReturn(userToUnfollowStaticTest());

        // Assert
        assertThrows(NotFoundException.class, () -> userService.unfollowUser(userId, userIdToUnfollow));
    }

    @Test
    @DisplayName("T-0003:Verificar que el tipo de ordenamiento alfabético exista. Continuar con normalidad - name_asc")
    void getFollowersListByNameAscShouldReturnSortedList() {
        //Arrange
        User userFromRepository = UserEntityUtilsGenerator.getUserWithThreeFollowers();
        when(userRepository.finById(100000)).thenReturn(userFromRepository);

        UserFollowersDTO userFollowersExpected = UserDTOUtilsGenerator.getUserFollowersDTOWithThreeFollowersOrderAsc();

        //Act
        UserFollowersDTO resultUserFollowers = userService.findFollowersById(100000, "name_asc");

        //Assert
        assertEquals(userFollowersExpected.getUser_id(),resultUserFollowers.getUser_id());
        assertEquals(userFollowersExpected.getUser_name(),resultUserFollowers.getUser_name());
        assertEquals(userFollowersExpected.getFollowers(),resultUserFollowers.getFollowers());
    }

    @Test
    @DisplayName("T-0003:Verificar que el tipo de ordenamiento alfabético exista. Continuar con normalidad - name_desc")
    void getFollowersListByNameDescShouldReturnSortedList() {
        //Arrange
        User userFromRepository = UserEntityUtilsGenerator.getUserWithThreeFollowers();
        when(userRepository.finById(100000)).thenReturn(userFromRepository);

        UserFollowersDTO userFollowersExpected = UserDTOUtilsGenerator.getUserFollowersDTOWithThreeFollowersOrderDesc();

        //Act
        UserFollowersDTO resultUserFollowers = userService.findFollowersById(100000, "name_desc");

        //Assert
        assertEquals(userFollowersExpected.getUser_id(),resultUserFollowers.getUser_id());
        assertEquals(userFollowersExpected.getUser_name(),resultUserFollowers.getUser_name());
        assertEquals(userFollowersExpected.getFollowers(),resultUserFollowers.getFollowers());
    }

    @Test
    @DisplayName("T-0003:Verificar que el tipo de ordenamiento alfabético exista. Continuar con normalidad - Orden no válido")
    void getFollowersListByNameEmptyShouldThrowException() {
        //Arrange
        User userFromRepository = UserEntityUtilsGenerator.getUserWithThreeFollowers();
        when(userRepository.finById(100000)).thenReturn(userFromRepository);

        //Act - Assert
        assertThrows(BadRequestException.class, ()->userService.findFollowersById(100000, "empty"));
    }

    @Test
    @DisplayName("T-0004:Verificar el correcto ordenamiento por nombre. Continuar con normalidad - name_asc")
    void getFollowedListByNameAscShouldReturnSortedList() {
        //Arrange
        User userFromRepository = UserEntityUtilsGenerator.getUserWithThreeFollowed();
        when(userRepository.finById(100000)).thenReturn(userFromRepository);

        UserFollowedDTO userFollowedExpected = UserDTOUtilsGenerator.getUserFollowedDTOWithThreeFollowedOrderAsc();

        //Act
        UserFollowedDTO resultUserFollowers = userService.findFollowedById(100000, "name_asc");

        //Assert
        assertEquals(userFollowedExpected.getUser_id(),resultUserFollowers.getUser_id());
        assertEquals(userFollowedExpected.getUser_name(),resultUserFollowers.getUser_name());
        assertEquals(userFollowedExpected.getFollowed(),resultUserFollowers.getFollowed());
    }

    @Test
    @DisplayName("T-0004:Verificar el correcto ordenamiento por nombre. Continuar con normalidad - name_desc")
    void getFollowedListByNameDescShouldReturnSortedList() {
        //Arrange
        User userFromRepository = UserEntityUtilsGenerator.getUserWithThreeFollowed();
        when(userRepository.finById(100000)).thenReturn(userFromRepository);

        UserFollowedDTO userFollowedExpected = UserDTOUtilsGenerator.getUserFollowedDTOWithThreeFollowedOrderDesc();

        //Act
        UserFollowedDTO resultUserFollowers = userService.findFollowedById(100000, "name_desc");

        //Assert
        assertEquals(userFollowedExpected.getUser_id(),resultUserFollowers.getUser_id());
        assertEquals(userFollowedExpected.getUser_name(),resultUserFollowers.getUser_name());
        assertEquals(userFollowedExpected.getFollowed(),resultUserFollowers.getFollowed());
    }

    @Test
    @DisplayName("T-0004:Verificar el correcto ordenamiento por nombre. Notificar con excepción - Orden no válido")
    void getFollowedListByNameEmptyShouldThrowException() {
        //Arrange
        User userFromRepository = UserEntityUtilsGenerator.getUserWithThreeFollowers();
        when(userRepository.finById(100000)).thenReturn(userFromRepository);

        //Act - Assert
        assertThrows(BadRequestException.class, ()->userService.findFollowedById(100000, "empty"));
    }

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta. Todo ok")
    void getFollowersCountOk(){
        //Arrange
        int userId = 1100;
        List<User> userList = loadTestUsers();
        User userMock = userList.get(1);

        userMock.addFollower(userList.get(0));
        userMock.addFollower(userList.get(2));

        userList.get(0).addFollowed(userMock);
        userList.get(2).addFollowed(userMock);

        Mockito.when(userRepository.finById(userId)).thenReturn(userList.get(1));

        FollowersCountDTO expected = new FollowersCountDTO();
        expected.setUser_id(userMock.getUser_id());
        expected.setUser_name(userMock.getUser_name());
        expected.setFollowers_count(userMock.getFollowers().size());
        //Act
        FollowersCountDTO result = userService.getFollowersCount(userId);
        //Assert
        assertEquals(expected.getUser_id(), result.getUser_id());
        assertEquals(expected.getUser_name(), result.getUser_name());
        assertEquals(expected.getFollowers_count(), result.getFollowers_count());
    }

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta. Usuario inválido")
    void getFollowersCountNotFoundUser(){
        //Arrange
        int userId = 9999;
        when(userRepository.finById(userId)).thenReturn(null);
        String expectedMessage = "Usuario no encontrado";
        //Act & Assert
        Exception e = assertThrows(NotFoundException.class, () -> {
            userService.getFollowersCount(userId);
        });
        assertEquals(expectedMessage, e.getMessage());
    }
}
