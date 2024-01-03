package com.example.be_java_hisp_w23_g3.service.user;

import com.example.be_java_hisp_w23_g3.dto.response.MessageResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.UserDTO;
import com.example.be_java_hisp_w23_g3.entity.user.Seller;
import com.example.be_java_hisp_w23_g3.entity.user.User;
import com.example.be_java_hisp_w23_g3.exception.exceptions.*;
import com.example.be_java_hisp_w23_g3.repository.seller.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import com.example.be_java_hisp_w23_g3.util.SellerTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.UserTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTests {

    @Mock
    UserRepository userRepository;

    @Mock
    SellerRepository sellerRepository;

    @InjectMocks
    UserServiceImpl service;

    @Test
    void getFollowersCount_shouldGetResultOfNumberOfUsersWhoFollowingSpecificSeller() {
        // Arrange
        Long param = 1L;
        Seller seller = new SellerTestDataBuilder()
                .withId(param)
                .sellerWithFollowers()
                .build();
        Integer expected = seller.getFollower().size();
        when(sellerRepository.read(param)).thenReturn(Optional.of(seller));

        // Act
        Integer actual = service.getFollowersCount(param).getFollowersCount();

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getFollowersCount_shouldThrowNotFoundException() {
        // Arrange
        when(sellerRepository.read(anyLong())).thenReturn(Optional.empty());

        // Act and Assert
        Assertions.assertThrows(NotFoundException.class, () -> service.getFollowersCount(1L));
    }

    @Test
    void getFollowersCount_shouldResultIsZero() {
        // Arrange
        Long param = 1L;
        Seller seller = new SellerTestDataBuilder()
                .sellerByDefault().build();
        Integer expected = seller.getFollower().size();
        when(sellerRepository.read(param)).thenReturn(Optional.of(seller));

        // Act
        Integer actual = service.getFollowersCount(param).getFollowersCount();

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getFollowersList_shouldReturnNameAscOrderedList() {
        // Arrange
        Long sellerId = 1L;
        String order = "name_asc";
        Seller seller = new SellerTestDataBuilder()
                .withId(sellerId)
                .sellerWithFollowers()
                .build();
        List<Long> expected = seller.getFollower().stream()
                .sorted(Comparator.comparing(User::getUsername))
                .map(User::getId).toList();
        when(sellerRepository.read(sellerId)).thenReturn(Optional.of(seller));

        // Act
        List<Long> actual = service.getFollowersList(sellerId, order).getFollowers()
                .stream().map(UserDTO::getUserId).toList();

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    void getFollowersList_shouldReturnNameDescOrderedList() {
        // Arrange
        Long sellerId = 1L;
        String order = "name_desc";
        Seller seller = new SellerTestDataBuilder()
                .withId(sellerId)
                .sellerWithFollowers()
                .build();
        List<Long> expected = seller.getFollower().stream()
                .sorted(Comparator.comparing(User::getUsername).reversed())
                .map(User::getId).toList();
        when(sellerRepository.read(sellerId)).thenReturn(Optional.of(seller));

        // Act
        List<Long> actual = service.getFollowersList(sellerId, order).getFollowers()
                .stream().map(UserDTO::getUserId).toList();

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    void getFollowersList_shouldReturnNotOrderedList() {
        // Arrange
        Long sellerId = 1L;
        Seller seller = new SellerTestDataBuilder()
                .withId(sellerId)
                .sellerWithFollowers()
                .build();
        List<Long> expected = seller.getFollower().stream()
                .map(User::getId).toList();
        when(sellerRepository.read(sellerId)).thenReturn(Optional.of(seller));

        // Act
        List<Long> actual = service.getFollowersList(sellerId, null).getFollowers()
                .stream().map(UserDTO::getUserId).toList();

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    void getFollowersList_shouldThrowInvalidOrderException() {
        // Arrange
        Long sellerId = 1L;
        String order = "any value other than 'name_asc' or 'name_desc'";
        Seller seller = new SellerTestDataBuilder()
                .withId(sellerId)
                .sellerWithFollowers()
                .build();
        when(sellerRepository.read(sellerId)).thenReturn(Optional.of(seller));

        // Act and Assert
        assertThrows(InvalidOrderException.class, () -> service.getFollowersList(sellerId, order));
    }

    @Test
    void getFollowersList_shouldReturnEmptyList() {
        // Arrange
        Long sellerId = 1L;
        Seller seller = new SellerTestDataBuilder()
                .sellerByDefault()
                .build();
        when(sellerRepository.read(sellerId)).thenReturn(Optional.of(seller));

        // Act
        List<Long> actual = service.getFollowersList(sellerId, null).getFollowers()
                .stream().map(UserDTO::getUserId).toList();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void getFollowersList_shouldThrowNotFoundException() {
        // Arrange
        when(sellerRepository.read(anyLong())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NotFoundException.class, () -> service.getFollowersList(1L, null));
    }

    @Test
    void getFollowedSellersList_shouldReturnNameAscOrderedList() {
        // Arrange
        Long userId = 1L;
        String order = "name_asc";
        User user = new UserTestDataBuilder()
                .withId(userId)
                .userWithFollowings()
                .build();
        List<Long> expected = user.getFollowing().stream()
                .sorted(Comparator.comparing(User::getUsername))
                .map(User::getId).toList();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        // Act
        List<Long> actual = service.getFollowedSellersList(userId, order).getFollowed()
                .stream().map(UserDTO::getUserId).toList();

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    void getFollowedSellersList_shouldReturnNameDescOrderedList() {
        // Arrange
        Long userId = 1L;
        String order = "name_desc";
        User user = new UserTestDataBuilder()
                .withId(userId)
                .userWithFollowings()
                .build();
        List<Long> expected = user.getFollowing().stream()
                .sorted(Comparator.comparing(User::getUsername).reversed())
                .map(User::getId).toList();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        // Act
        List<Long> actual = service.getFollowedSellersList(userId, order).getFollowed()
                .stream().map(UserDTO::getUserId).toList();

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    void getFollowedSellersList_shouldReturnNotOrderedList() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder()
                .withId(userId)
                .userWithFollowings()
                .build();
        List<Long> expected = user.getFollowing().stream()
                .map(User::getId).toList();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        // Act
        List<Long> actual = service.getFollowedSellersList(userId, null).getFollowed()
                .stream().map(UserDTO::getUserId).toList();

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    void getFollowedSellersList_shouldThrowInvalidOrderException() {
        // Arrange
        Long userId = 1L;
        String order = "any value other than 'name_asc' or 'name_desc'";
        User user = new UserTestDataBuilder()
                .withId(userId)
                .userWithFollowings()
                .build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        // Act and Assert
        assertThrows(InvalidOrderException.class, () -> service.getFollowedSellersList(userId, order));
    }

    @Test
    void getFollowedSellersList_shouldReturnEmptyList() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder()
                .userByDefault()
                .build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        // Act
        List<Long> actual = service.getFollowedSellersList(userId, null).getFollowed()
                .stream().map(UserDTO::getUserId).toList();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void getFollowedSellersList_shouldThrowNotFoundException() {
        // Arrange
        when(userRepository.read(anyLong())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NotFoundException.class, () -> service.getFollowedSellersList(1L, null));
    }

    @Test
    void followSeller_shouldWorkWhenSellerExists() {
        // Arrange
        Long userId = 1L;
        Long sellerIdToFollow = 9L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).build();
        Seller sellerToFollow = new SellerTestDataBuilder().sellerByDefault().withId(sellerIdToFollow).build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        when(sellerRepository.read(sellerIdToFollow)).thenReturn(Optional.of(sellerToFollow));

        // Act
        MessageResponseDTO respond = service.followSeller(userId, sellerIdToFollow);

        // Assert
        assertTrue(user.getFollowing().contains(sellerToFollow));
        assertTrue(sellerToFollow.getFollower().contains(user));
        assertEquals(new MessageResponseDTO("Following a new Seller!"), respond);
        verify(sellerRepository, times(1)).read(sellerIdToFollow);
        verify(userRepository, times(1)).read(userId);
    }

    @Test
    void followSeller_shouldThrowNotFoundException() {
        // Arrange
        Long userId = 1L;
        Long sellerIdToFollow = 999L;
        when(sellerRepository.read(sellerIdToFollow)).thenThrow(NotFoundException.class);

        // Act and Assert
        assertThrows(NotFoundException.class, () -> service.followSeller(userId, sellerIdToFollow));
        verify(sellerRepository, times(1)).read(sellerIdToFollow);
    }

    @Test
    void followSeller_shouldThrowFollowingMyselfException() {
        // Arrange
        Long userId = 1L;
        Long sellerIdToFollow = 1L;

        // Act and Assert
        assertThrows(FollowingMyselfException.class, () -> service.followSeller(userId, sellerIdToFollow));
    }

    @Test
    void followSeller_shouldThrowAlreadyAFollowerException() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).userWithFollowings().build();
        Seller sellerFollowed = user.getFollowing().stream().findFirst().get();
        Long sellerIdFollowed = sellerFollowed.getId();
        sellerFollowed.setFollower(new HashSet<>(List.of(user)));
        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        when(sellerRepository.read(sellerIdFollowed)).thenReturn(Optional.of(sellerFollowed));

        // Act and Assert
        assertThrows(AlreadyFollowingException.class, () -> service.followSeller(userId, sellerIdFollowed));
    }

    @Test
    void unfollowSeller_shouldWorkWhenSellerExistsOnFollowings() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).userWithFollowings().build();
        Seller sellerToUnfollow = user.getFollowing().stream().findFirst().get();
        Long sellerIdToUnfollow = sellerToUnfollow.getId();
        sellerToUnfollow.setFollower(new HashSet<>(List.of(user)));
        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        when(userRepository.findSellerInFollowings(user, sellerIdToUnfollow)).thenReturn(Optional.of(sellerToUnfollow));

        // Act
        MessageResponseDTO respond = service.unfollowSeller(userId, sellerIdToUnfollow);

        // Assert
        assertTrue(sellerToUnfollow.getFollower().isEmpty());
        assertFalse(user.getFollowing().contains(sellerToUnfollow));
        assertEquals(new MessageResponseDTO("You have just unfollowed a seller"), respond);
        verify(userRepository, times(1)).findSellerInFollowings(user, sellerIdToUnfollow);
        verify(userRepository, times(1)).read(userId);
    }

    @Test
    void unfollowSeller_shouldThrowNotAFollowerException() {
        // Arrange
        Long userId = 1L;
        Long sellerIdToUnfollow = 999L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).userWithFollowings().build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        when(userRepository.findSellerInFollowings(user, sellerIdToUnfollow)).thenThrow(NotFollowingException.class);

        // Act and Assert
        assertThrows(NotFollowingException.class, () -> service.unfollowSeller(userId, sellerIdToUnfollow));
        verify(userRepository, times(1)).findSellerInFollowings(user, sellerIdToUnfollow);
    }

    @Test
    void unfollowSeller_shouldThrowUnFollowingMyselfException() {
        // Arrange
        Long userId = 1L;
        Long sellerIdToUnFollow = 1L;

        // Act and Assert
        assertThrows(UnfollowingMyselfException.class, () -> service.unfollowSeller(userId, sellerIdToUnFollow));
    }
}
