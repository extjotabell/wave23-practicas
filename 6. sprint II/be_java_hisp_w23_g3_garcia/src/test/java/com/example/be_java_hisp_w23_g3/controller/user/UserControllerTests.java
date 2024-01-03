package com.example.be_java_hisp_w23_g3.controller.user;


import com.example.be_java_hisp_w23_g3.controller.UserController;
import com.example.be_java_hisp_w23_g3.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowersListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.MessageResponseDTO;
import com.example.be_java_hisp_w23_g3.exception.exceptions.InvalidOrderException;
import com.example.be_java_hisp_w23_g3.service.user.UserService;
import com.example.be_java_hisp_w23_g3.util.FollowedListDTOTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.FollowersListDTOTestDataBuilder;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTests {

    @Mock
    UserService userService;

    @InjectMocks
    UserController controller;

    @Test
    void getFollowersList_shouldAcceptNameAscOrderParameter() {
        // Arrange
        Long userId = 1L;
        String order = "name_asc";
        FollowersListDTO followersListDTO = new FollowersListDTOTestDataBuilder()
                .followersListDTOWithFollowers().build();
        when(userService.getFollowersList(userId, order))
                .thenReturn(followersListDTO);

        // Act
        controller.getFollowersList(userId, order);

        // Assert
        verify(userService).getFollowersList(userId, order);
    }

    @Test
    void getFollowersList_shouldAcceptNameDescOrderParameter() {
        // Arrange
        Long userId = 1L;
        String order = "name_desc";
        FollowersListDTO followersListDTO = new FollowersListDTOTestDataBuilder()
                .followersListDTOWithFollowers().build();
        when(userService.getFollowersList(userId, order))
                .thenReturn(followersListDTO);

        // Act
        controller.getFollowersList(userId, order);

        // Assert
        verify(userService).getFollowersList(userId, order);
    }

    @Test
    void getFollowersList_shouldAcceptNullOrderParameter() {
        // Arrange
        Long userId = 1L;
        FollowersListDTO followersListDTO = new FollowersListDTOTestDataBuilder()
                .followersListDTOWithFollowers().build();
        when(userService.getFollowersList(userId, null))
                .thenReturn(followersListDTO);

        // Act
        controller.getFollowersList(userId, null);

        // Assert
        verify(userService).getFollowersList(userId, null);
    }

    @Test
    void getFollowersList_shouldThrowInvalidOrderException() {
        // Arrange
        Long userId = 1L;
        String order = "any other than name_asc or name_desc";

        doThrow(new InvalidOrderException(
                "The 'order' parameter is invalid. The permitted values are 'name_asc' or 'name_desc'."))
                .when(userService).getFollowersList(userId, order);

        // Act & Assert
        assertThrows(InvalidOrderException.class, () -> controller.getFollowersList(userId, order));

        // Verify
        verify(userService).getFollowersList(userId, order);
    }

    @Test
    void getFollowedSellerList_shouldAcceptNameAscOrderParameter() {
        // Arrange
        Long userId = 1L;
        String order = "name_asc";
        FollowedListDTO followedListDTO = new FollowedListDTOTestDataBuilder()
                .followedListDTOWithFollowed().build();
        when(userService.getFollowedSellersList(userId, order))
                .thenReturn(followedListDTO);

        // Act
        controller.getFollowedSellerList(userId, order);

        // Assert
        verify(userService).getFollowedSellersList(userId, order);
    }

    @Test
    void getFollowedSellerList_shouldAcceptNameDescOrderParameter() {
        // Arrange
        Long userId = 1L;
        String order = "name_desc";
        FollowedListDTO followedListDTO = new FollowedListDTOTestDataBuilder()
                .followedListDTOWithFollowed().build();
        when(userService.getFollowedSellersList(userId, order))
                .thenReturn(followedListDTO);

        // Act
        controller.getFollowedSellerList(userId, order);

        // Assert
        verify(userService).getFollowedSellersList(userId, order);
    }

    @Test
    void getFollowedSellerList_shouldAcceptNullOrderParameter() {
        // Arrange
        Long userId = 1L;
        FollowedListDTO followedListDTO = new FollowedListDTOTestDataBuilder()
                .followedListDTOWithFollowed().build();
        when(userService.getFollowedSellersList(userId, null))
                .thenReturn(followedListDTO);

        // Act
        controller.getFollowedSellerList(userId, null);

        // Assert
        verify(userService).getFollowedSellersList(userId, null);
    }

    @Test
    void getFollowedSellerList_shouldThrowInvalidOrderException() {
        // Arrange
        Long userId = 1L;
        String order = "any other than name_asc or name_desc";
        doThrow(new InvalidOrderException(
                "The 'order' parameter is invalid. The permitted values are 'name_asc' or 'name_desc'."))
                .when(userService).getFollowedSellersList(userId, order);

        // Act & Assert
        assertThrows(InvalidOrderException.class, () -> controller.getFollowedSellerList(userId, order));

        // Verify
        verify(userService).getFollowedSellersList(userId, order);
    }

    @Test
    void getFollowersCount_shouldReturnFollowersCountForValidUserId() {
        // Arrange
        Long userId = 1L;
        FollowersCountDTO followersCountDTO = new FollowersCountDTO(
                userId, "username", 5);
        when(userService.getFollowersCount(userId)).thenReturn(followersCountDTO);

        // Act
        ResponseEntity<FollowersCountDTO> response = controller.getFollowersCount(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(followersCountDTO, response.getBody());

        // Verify
        verify(userService).getFollowersCount(userId);
    }

    @Test
    void getFollowersCount_shouldThrowExceptionForInvalidUserId() {
        // Arrange
        Long userId = -1L;
        doThrow(new ConstraintViolationException("The user_id must be greater than zero", new HashSet<>()))
                .when(userService).getFollowersCount(userId);

        // Act & Assert
        assertThrows(ConstraintViolationException.class, () -> controller.getFollowersCount(userId));

        // Verify
        verify(userService).getFollowersCount(userId);
    }

    @Test
    void followSeller_shouldReturnMessageResponseDTOForValidUserIds() {
        // Arrange
        Long userId = 1L;
        Long userIdToFollow = 2L;
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO("User successfully followed.");
        when(userService.followSeller(userId, userIdToFollow)).thenReturn(messageResponseDTO);

        // Act
        ResponseEntity<MessageResponseDTO> response = controller.followSeller(userId, userIdToFollow);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(messageResponseDTO, response.getBody());

        // Verify
        verify(userService).followSeller(userId, userIdToFollow);
    }

    @Test
    void followSeller_shouldThrowExceptionForInvalidUserId() {
        // Arrange
        Long userId = -1L;
        Long userIdToFollow = 2L;
        doThrow(new ConstraintViolationException("The follower user_id must be greater than zero", new HashSet<>()))
                .when(userService).followSeller(userId, userIdToFollow);

        // Act & Assert
        assertThrows(ConstraintViolationException.class, () -> controller.followSeller(userId, userIdToFollow));

        // Verify
        verify(userService).followSeller(userId, userIdToFollow);
    }

    @Test
    void followSeller_shouldThrowExceptionForInvalidUserIdToFollow() {
        // Arrange
        Long userId = 1L;
        Long userIdToFollow = -1L;
        doThrow(new ConstraintViolationException("The user_id to follow must be greater than zero", new HashSet<>()))
                .when(userService).followSeller(userId, userIdToFollow);

        // Act & Assert
        assertThrows(ConstraintViolationException.class, () -> controller.followSeller(userId, userIdToFollow));

        // Verify
        verify(userService).followSeller(userId, userIdToFollow);
    }

    @Test
    void unFollowSeller_shouldReturnMessageResponseDTOForValidUserIds() {
        // Arrange
        Long userId = 1L;
        Long userIdToUnfollow = 2L;
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO("User successfully unfollowed.");
        when(userService.unfollowSeller(userId, userIdToUnfollow)).thenReturn(messageResponseDTO);

        // Act
        ResponseEntity<MessageResponseDTO> response = controller.unfollowSeller(userId, userIdToUnfollow);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(messageResponseDTO, response.getBody());

        // Verify
        verify(userService).unfollowSeller(userId, userIdToUnfollow);
    }

    @Test
    void unFollowSeller_shouldThrowExceptionForInvalidUserId() {
        // Arrange
        Long userId = -1L;
        Long userIdToUnfollow = 2L;
        doThrow(new ConstraintViolationException("The follower user_id must be greater than zero", new HashSet<>()))
                .when(userService).unfollowSeller(userId, userIdToUnfollow);

        // Act & Assert
        assertThrows(ConstraintViolationException.class, () -> controller.unfollowSeller(userId, userIdToUnfollow));

        // Verify
        verify(userService).unfollowSeller(userId, userIdToUnfollow);
    }

    @Test
    void unFollowSeller_shouldThrowExceptionForInvalidUserIdToUnfollow() {
        // Arrange
        Long userId = 1L;
        Long userIdToUnfollow = -1L;
        doThrow(new ConstraintViolationException("The user_id to unfollow must be greater than zero", new HashSet<>()))
                .when(userService).unfollowSeller(userId, userIdToUnfollow);

        // Act & Assert
        assertThrows(ConstraintViolationException.class, () -> controller.unfollowSeller(userId, userIdToUnfollow));

        // Verify
        verify(userService).unfollowSeller(userId, userIdToUnfollow);
    }

}
