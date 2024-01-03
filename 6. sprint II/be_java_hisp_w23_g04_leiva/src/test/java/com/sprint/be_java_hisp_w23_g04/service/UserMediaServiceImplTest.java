package com.sprint.be_java_hisp_w23_g04.service;

import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SellerDTO;
import com.sprint.be_java_hisp_w23_g04.exception.NoContentException;
import com.sprint.be_java_hisp_w23_g04.utils.Verifications;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import com.sprint.be_java_hisp_w23_g04.exception.BadRequestException;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;
import com.sprint.be_java_hisp_w23_g04.gateway.UserGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static com.sprint.be_java_hisp_w23_g04.utils.UtilsTest.getOneUser;
import static com.sprint.be_java_hisp_w23_g04.utils.UtilsTest.getOneUserSeller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import static com.sprint.be_java_hisp_w23_g04.utils.UtilsTest.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UserMediaServiceImplTest {
    @Mock
    UserGatewayImpl userGateway;

    @InjectMocks
    UserMediaServiceImpl userService;

    @Test
    @DisplayName("Verify that the alphabetical asc sort type exists in getFollowersByUserId")
    void test1() {
        // Arrange
        Integer userIdtoFind = 1;
        String orderCriteria = "name_asc";
        BuyerDTO expectedResponse = getBuyerAscendingDTO();

        // Act
        when(userGateway.findUser(any())).thenReturn(new User());
        when(userGateway.getByIds(anyList())).thenReturn(getUsers());
        BuyerDTO response = userService.getFollowersByUserId(userIdtoFind, orderCriteria);

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("Verify that the alphabetical dsc sort type exists in getFollowersByUserId")
    void test7() {
        // Arrange
        Integer userIdtoFind = 1;
        String orderCriteria = "name_dsc";
        BuyerDTO expectedResponse = getBuyerDescendingDTO();

        // Act
        when(userGateway.findUser(any())).thenReturn(new User());
        when(userGateway.getByIds(anyList())).thenReturn(getUsers());
        BuyerDTO response = userService.getFollowersByUserId(userIdtoFind, orderCriteria);

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("Except because userId not exist in getFollowersByUserId")
    void test2() {
        // Arrange
        Integer userIdtoFind = 99;
        String orderCriteria = "name_asc";

        // Act
        when(userGateway.findUser(any())).thenReturn(null);

        // Assert
        assertThrows(NotFoundException.class, () -> userService.getFollowersByUserId(userIdtoFind, orderCriteria));
    }

    @Test
    @DisplayName("Except because not user with followers")
    void test3() {
        // Arrange
        Integer userIdtoFind = 4;
        String orderCriteria = "name_asc";

        // Act
        when(userGateway.findUser(any())).thenReturn(new User());
        when(userGateway.getByIds(anyList())).thenReturn(List.of());

        // Assert
        assertThrows(NoContentException.class, () -> userService.getFollowersByUserId(userIdtoFind, orderCriteria));
    }

    @Test
    @DisplayName("Verify the correct descending order by name in getFollowedByUserId")
    void test4() {
        // Arrange
        Integer userIdToFind = 1;
        String orderCriteria = "name_dsc";
        BuyerDTO expectedResponse = getBuyerDescendingDTO();

        // Act
        when(userGateway.findUser(any())).thenReturn(new User());
        when(userGateway.getByIds(anyList())).thenReturn(getUsers());
        BuyerDTO response = userService.getFollowedByUserId(userIdToFind, orderCriteria);

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("Except because userId not exist in getFollowedByUserId")
    void test5() {
        // Arrange
        Integer userIdToFind = 99;
        String orderCriteria = "name_asc";

        // Act
        when(userGateway.findUser(any())).thenReturn(null);

        // Assert
        assertThrows(NotFoundException.class, () -> userService.getFollowedByUserId(userIdToFind, orderCriteria));
    }

    @Test
    @DisplayName("Except because not user with followed")
    void test6() {
        // Arrange
        Integer userIdToFind = 4;
        String orderCriteria = "name_asc";

        // Act
        when(userGateway.findUser(any())).thenReturn(new User());
        when(userGateway.getByIds(anyList())).thenReturn(List.of());

        // Assert
        assertThrows(NoContentException.class, () -> userService.getFollowersByUserId(userIdToFind, orderCriteria));
    }

    @Test
    @DisplayName("Except because criteria order not exists in getFollowersByUserId")
    void test8() {
        // Arrange
        Integer userIdtoFind = 1;
        String orderCriteria = "name_false";

        // Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowersByUserId(userIdtoFind, orderCriteria));
    }

    @Test
    @DisplayName("Except because criteria order not exists in getFollowedByUserId")
    void test9() {
        // Arrange
        Integer userIdToFind = 1;
        String orderCriteria = "name_false";

        // Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowedByUserId(userIdToFind, orderCriteria));

    }

    @Test
    @DisplayName("User Unfollows Seller User successfully.")
    public void unfollowUserTest() {
        int userId = 4;
        int unfollowId = 1;

        when(userGateway.findUser(userId)).thenReturn(new User(4, "Sofia Gomez", List.of(), List.of(1, 3), List.of()));
        when(userGateway.findUser(unfollowId)).thenReturn(new User(1, "Juan Perez", List.of(1, 2, 7), List.of(), List.of(4, 6)));

        SimpleMessageDTO expectedResponse = new SimpleMessageDTO("El usuario Juan Perez Id: 1 ya no es seguido por el usuario Sofia Gomez Id: 4");

        SimpleMessageDTO actualResponse = userService.unfollowUser(userId, unfollowId);

        assertThat(expectedResponse).isEqualTo(actualResponse);
    }

    @Test
    @DisplayName("User Unfollows Seller User fails when User does not exist.")
    public void unfollowUserWithUserNotFoundTest() {
        int userId = 400;
        int unfollowId = 1;

        when(userGateway.findUser(userId)).thenReturn(null);
        when(userGateway.findUser(unfollowId)).thenReturn(new User(1, "Juan Perez", List.of(1, 2, 7), List.of(), List.of(4, 6)));

        assertThrows(NotFoundException.class, () -> userService.unfollowUser(userId, unfollowId), "No se encontró usuario con el id 400.");
    }

    @Test
    @DisplayName("User Unfollows Seller User fails when Seller is not followed.")
    public void unfollowUserBuyerDontFollowSellerTest() {
        int userId = 6;
        int unfollowId = 1;

        when(userGateway.findUser(userId)).thenReturn(new User(6, "Diego Lopez", List.of(), List.of(7), List.of()));
        when(userGateway.findUser(unfollowId)).thenReturn(new User(1, "Juan Perez", List.of(1, 2, 7), List.of(), List.of(4, 6)));

        assertThrows(BadRequestException.class, () -> userService.unfollowUser(userId, unfollowId), "El usuario con id:6 no sigue al vendedor con id:1");
    }

    @Test
    @DisplayName("User Follows Seller User successfully.")
    void followSellerUserWhenUserExistTestOK() {
        //Arrange
        Integer userId = 3;
        Integer sellerId = 2;
        SimpleMessageDTO expectedMsg = new SimpleMessageDTO("El usuario con id:3 ahora sigue a vendedor con id:2");

        //Act
        when(userGateway.findUser(userId)).thenReturn(getOneUser());
        when(userGateway.findUser(sellerId)).thenReturn(getOneUserSeller());
        SimpleMessageDTO msg = userService.followSellerUser(userId, sellerId);

        //Assert
        assertEquals(expectedMsg, msg);
    }

    @Test
    @DisplayName("User Follows Seller User fails when User does not exist.")
    void followSellerUserWhenUserDoesNotExistTestNotFound() {
        //Arrange
        Integer userId = 99;
        Integer sellerId = 2;

        //Act
        when(userGateway.findUser(userId)).thenReturn(null);
        when(userGateway.findUser(sellerId)).thenReturn(getOneUserSeller());

        //Assert
        assertThrows(NotFoundException.class, () -> {
            userService.followSellerUser(userId, sellerId);
        });
    }

    @Test
    @DisplayName("User Follows Seller User fails when Seller does not exist.")
    void followSellerUserWhenSellerDoesNotExistTestNotFound() {
        //Arrange
        Integer userId = 3;
        Integer sellerId = 99;

        //Act
        when(userGateway.findUser(userId)).thenReturn(getOneUser());
        when(userGateway.findUser(sellerId)).thenReturn(null);

        //Assert
        assertThrows(NotFoundException.class, () -> {
            userService.followSellerUser(userId, sellerId);
        });
    }

    @Test
    @DisplayName("followersCount() should return a SellerDTO - US-0002")
    void testFollowersCountOk() {
        // Arrange
        Integer userId = 1;

        SellerDTO expected = new SellerDTO();
        expected.setFollowersCount(0);
        expected.setId(1);
        expected.setName("test");

        // Act
        when(userGateway.findUser(any())).thenReturn(new User());

        SellerDTO result = userService.followersCount(userId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("followersCount() should throw NotFoundException - US-0002")
    void testFollowersCountThrowsNotFoundException() {
        // Arrange
        Integer userId = 1;

        // Act
        when(userGateway.findUser(any())).thenReturn(null);

        // Assert
        assertThrows(NotFoundException.class, () -> userService.followersCount(userId));
    }
}