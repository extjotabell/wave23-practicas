package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dtos.response.FollowersCountDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.services.IUserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    IUserService userService;

    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista.")
    void followeSellerOk() {
        //Arrange
        int userIdFollower = 100;
        int userIdFollowed = 1100;
        Mockito.when(userService.followSeller(userIdFollower, userIdFollowed))
               .thenReturn(new MessageDTO("Usuario seguido agregado"));
        ResponseEntity<?> expected = ResponseEntity.ok(new MessageDTO("Usuario seguido agregado"));
        //Act
        ResponseEntity<?> result = userController.followSeller(userIdFollower, userIdFollowed);
        //Assert
        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode());
        Assertions.assertEquals(((MessageDTO)expected.getBody()).getMessage(), ((MessageDTO)result.getBody()).getMessage());
    }

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta.")
    void getFollowersCountOk(){
        //Arrange
        int userId = 1100;
        FollowersCountDTO followersCountDTO = new FollowersCountDTO();
        followersCountDTO.setUser_id(1100);
        followersCountDTO.setUser_name("Dudley");
        followersCountDTO.setFollowers_count(2);
        Mockito.when(userService.getFollowersCount(userId)).thenReturn(followersCountDTO);
        ResponseEntity expected = ResponseEntity.ok(followersCountDTO);
        //Act
        ResponseEntity result = userController.getFollowersCount(userId);
        //Assert
        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode());
        Assertions.assertEquals(((FollowersCountDTO)expected.getBody()).getUser_id(), ((FollowersCountDTO)result.getBody()).getUser_id());
        Assertions.assertEquals(((FollowersCountDTO)expected.getBody()).getUser_name(), ((FollowersCountDTO)result.getBody()).getUser_name());
        Assertions.assertEquals(((FollowersCountDTO)expected.getBody()).getFollowers_count(), ((FollowersCountDTO)result.getBody()).getFollowers_count());
    }
}
