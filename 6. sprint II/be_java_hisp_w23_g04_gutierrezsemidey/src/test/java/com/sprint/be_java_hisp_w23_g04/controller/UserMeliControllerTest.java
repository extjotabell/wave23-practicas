package com.sprint.be_java_hisp_w23_g04.controller;

import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.service.UserMediaServiceImpl;
import org.junit.jupiter.api.DisplayName;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import com.sprint.be_java_hisp_w23_g04.exception.BadRequestException;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;
import com.sprint.be_java_hisp_w23_g04.gateway.UserGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.service.UserMediaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static com.sprint.be_java_hisp_w23_g04.utils.UtilsTest.getBuyerAscendingDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserMeliControllerTest {

    @Mock
    UserMediaServiceImpl userService;

    @InjectMocks
    UserMeliController controller;

    @Test
    @DisplayName("Verify that the alphabetical sort type exists")
    void test1() {
        // Arrange
        BuyerDTO expectedBuyerDTO = getBuyerAscendingDTO();
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(expectedBuyerDTO, HttpStatus.OK);

        // Act
        when(userService.getFollowersByUserId(any(), any())).thenReturn(expectedBuyerDTO);
        ResponseEntity<?> response = controller.getAllFollowersByUserId(1, "name_asc");

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("Verify the correct descending order by name")
    void test2() {
        // Arrange
        BuyerDTO expectedBuyerDTO = getBuyerAscendingDTO();
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(expectedBuyerDTO, HttpStatus.OK);

        // Act
        when(userService.getFollowedByUserId(any(), any())).thenReturn(expectedBuyerDTO);
        ResponseEntity<?> response = controller.getFollowedByUserId(1, "name_asc");

        // Assert
        assertEquals(expectedResponse, response);
    }


    @Test
    @DisplayName("check if sorting criteria exist in getFollowedByUserId")
    void test4() {
        // Arrange
        BuyerDTO expectedBuyerDTO = getBuyerAscendingDTO();
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(expectedBuyerDTO, HttpStatus.OK);

        // Act
        when(userService.getFollowedByUserId(any(), any())).thenReturn(expectedBuyerDTO);
        ResponseEntity<?> response = controller.getFollowedByUserId(1, "name_false");

        // Assert
        assertEquals(expectedResponse, response);
    }
   
    @Test
    @DisplayName("Unfollow User Successfully")
    public void unfollowSuccessfulTest(){
        int userId = 4;
        int unfollowedId = 1;

        SimpleMessageDTO expectedServiceResponse = new SimpleMessageDTO("El usuario Juan Perez Id: 1 ya no es seguido por el usuario Sofia Gomez Id: 4");
        when(userService.unfollowUser(anyInt(), anyInt()))
                .thenReturn(expectedServiceResponse);
        ResponseEntity<?> actualResponse = controller.unfollowUser(userId, unfollowedId);

        assertThat(new ResponseEntity<>(expectedServiceResponse,HttpStatus.ACCEPTED)).isEqualTo(actualResponse);
    }

    @Test
    @DisplayName("Try to unfollow an user that doesn't exist")
    public void unfollowUserNotFoundTest(){
        int userId = 99;
        int unfollowedId = 2;
        when(userService.unfollowUser(anyInt(), anyInt()))
                .thenThrow(new NotFoundException("No se encontró usuario c   on el id " + userId + "."));
        assertThrows(NotFoundException.class ,()-> controller.unfollowUser(userId, unfollowedId));
    }

    @Test
    @DisplayName("Try to unfollow an user that is not being followed")
    public void unfollowUserNotFollowedTest(){
        int userId = 99;
        int unfollowedId = 2;
        when(userService.unfollowUser(anyInt(), anyInt()))
                .thenThrow(new BadRequestException("El vendedor con id:" + userId + " no es seguido por el usuario con id:" + unfollowedId));
        assertThrows(BadRequestException.class ,()-> controller.unfollowUser(userId, unfollowedId));
    }

    @Test
    void followSellerUser() {
        // arrange
        int userId = 1;
        int sellerId = 2;

        // act
        controller.followSellerUser(userId, sellerId);

        // assert
        verify(userService, atLeastOnce()).followSellerUser(any(), any());
    }
}
