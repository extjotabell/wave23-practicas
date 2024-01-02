package com.example.be_java_hisp_w23_g3.service.user;

import com.example.be_java_hisp_w23_g3.dto.response.UserDTO;
import com.example.be_java_hisp_w23_g3.entity.user.Seller;
import com.example.be_java_hisp_w23_g3.entity.user.User;
import com.example.be_java_hisp_w23_g3.dto.response.MessageResponseDTO;
import com.example.be_java_hisp_w23_g3.exception.exceptions.*;
import com.example.be_java_hisp_w23_g3.repository.seller.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import com.example.be_java_hisp_w23_g3.util.SellerTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.UserTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
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
    void getFollowersCount_shouldGetResultOfNumberOfUsersWhoFollowingSpecificSeller(){
        Long param = 1L;

        Seller seller = new SellerTestDataBuilder()
                .withId(param)
                .sellerWithFollowers()
                .build();

        Integer expected = seller.getFollower().size();

        when(sellerRepository.read(param)).thenReturn(Optional.of(seller));

        Integer actual = service.getFollowersCount(param).getFollowersCount();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getFollowersCount_shouldThrowNotFoundException(){
        when(sellerRepository.read(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> service.getFollowersCount(1L));
    }

    @Test
    void getFollowersCount_shouldResultIsZero(){
        Long param = 1L;

        Seller seller = new SellerTestDataBuilder()
                .sellerByDefault().build();

        Integer expected = seller.getFollower().size();

        when(sellerRepository.read(param)).thenReturn(Optional.of(seller));

        Integer actual = service.getFollowersCount(param).getFollowersCount();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void getFollowersList_shouldReturnNameAscOrderedList() {
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

        List<Long> actual = service.getFollowersList(sellerId, order).getFollowers()
                .stream().map(UserDTO::getUserId).toList();

        assertEquals(actual, expected);
    }

    @Test
    void getFollowersList_shouldReturnNameDescOrderedList() {
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

        List<Long> actual = service.getFollowersList(sellerId, order).getFollowers()
                .stream().map(UserDTO::getUserId).toList();

        assertEquals(actual, expected);
    }

    @Test
    void getFollowersList_shouldReturnNotOrderedList() {
        Long sellerId = 1L;
        Seller seller = new SellerTestDataBuilder()
                .withId(sellerId)
                .sellerWithFollowers()
                .build();
        List<Long> expected = seller.getFollower().stream()
                .map(User::getId).toList();

        when(sellerRepository.read(sellerId)).thenReturn(Optional.of(seller));

        List<Long> actual = service.getFollowersList(sellerId, null).getFollowers()
                .stream().map(UserDTO::getUserId).toList();

        assertEquals(actual, expected);
    }

    @Test
    void getFollowersList_shouldThrowInvalidOrderException() {
        Long sellerId = 1L;
        String order = "any value other than 'name_asc' or 'name_desc'";
        Seller seller = new SellerTestDataBuilder()
                .withId(sellerId)
                .sellerWithFollowers()
                .build();

        when(sellerRepository.read(sellerId)).thenReturn(Optional.of(seller));

        assertThrows(InvalidOrderException.class, () -> service.getFollowersList(sellerId, order));
    }

    @Test
    void getFollowersList_shouldReturnEmptyList() {
        Long sellerId = 1L;
        Seller seller = new SellerTestDataBuilder()
                .sellerByDefault()
                .build();

        when(sellerRepository.read(sellerId)).thenReturn(Optional.of(seller));

        List<Long> actual = service.getFollowersList(sellerId, null).getFollowers()
                .stream().map(UserDTO::getUserId).toList();

        assertTrue(actual.isEmpty());
    }

    @Test
    void getFollowersList_shouldThrowNotFoundException() {
        when(sellerRepository.read(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.getFollowersList(1L, null));
    }

    @Test
    void getFollowedSellersList_shouldReturnNameAscOrderedList() {
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

        List<Long> actual = service.getFollowedSellersList(userId, order).getFollowed()
                .stream().map(UserDTO::getUserId).toList();

        assertEquals(actual, expected);
    }

    @Test
    void getFollowedSellersList_shouldReturnNameDescOrderedList() {
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

        List<Long> actual = service.getFollowedSellersList(userId, order).getFollowed()
                .stream().map(UserDTO::getUserId).toList();

        assertEquals(actual, expected);
    }

    @Test
    void getFollowedSellersList_shouldReturnNotOrderedList() {
        Long userId = 1L;
        User user = new UserTestDataBuilder()
                .withId(userId)
                .userWithFollowings()
                .build();
        List<Long> expected = user.getFollowing().stream()
                .map(User::getId).toList();

        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        List<Long> actual = service.getFollowedSellersList(userId, null).getFollowed()
                .stream().map(UserDTO::getUserId).toList();

        assertEquals(actual, expected);
    }

    @Test
    void getFollowedSellersList_shouldThrowInvalidOrderException() {
        Long userId = 1L;
        String order = "any value other than 'name_asc' or 'name_desc'";
        User user = new UserTestDataBuilder()
                .withId(userId)
                .userWithFollowings()
                .build();

        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        assertThrows(InvalidOrderException.class, () -> service.getFollowedSellersList(userId, order));
    }

    @Test
    void getFollowedSellersList_shouldReturnEmptyList() {
        Long userId = 1L;
        User user = new UserTestDataBuilder()
                .userByDefault()
                .build();

        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        List<Long> actual = service.getFollowedSellersList(userId, null).getFollowed()
                .stream().map(UserDTO::getUserId).toList();

        assertTrue(actual.isEmpty());
    }

    @Test
    void getFollowedSellersList_shouldThrowNotFoundException() {
        when(userRepository.read(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.getFollowedSellersList(1L, null));

    }

    @Test
    void followSeller_shouldWorkWhenSellerExists() {
        Long userId = 1L;
        Long sellerIdToFollow = 9L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).build();
        Seller sellerToFollow = new SellerTestDataBuilder().sellerByDefault().withId(sellerIdToFollow).build();

        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        when(sellerRepository.read(sellerIdToFollow)).thenReturn(Optional.of(sellerToFollow));
        MessageResponseDTO respond = service.followSeller(userId, sellerIdToFollow);

        assertTrue(user.getFollowing().contains(sellerToFollow));
        assertTrue(sellerToFollow.getFollower().contains(user));
        assertEquals(new MessageResponseDTO("Following a new Seller!"), respond);
        verify(sellerRepository,times(1)).read(sellerIdToFollow);
        verify(userRepository, times(1)).read(userId);
    }

    @Test
    void followSeller_shouldThrowNotFoundException(){
        Long userId = 1L;
        Long sellerIdToFollow = 999L;
        when(sellerRepository.read(sellerIdToFollow)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class,() -> service.followSeller(userId,sellerIdToFollow));
        verify(sellerRepository,times(1)).read(sellerIdToFollow);
    }

    @Test
    void followSeller_shouldThrowFollowingMyselfException(){
        Long userId = 1L;
        Long sellerIdToFollow = 1L;
        assertThrows(FollowingMyselfException.class,() -> service.followSeller(userId,sellerIdToFollow));
    }

    @Test
    void followSeller_shouldThrowAlreadyAFollowerException(){
        Long userId = 1L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).userWithFollowings().build();
        Seller sellerFollowed = user.getFollowing().stream().findFirst().get();
        Long sellerIdFollowed = sellerFollowed.getId();
        sellerFollowed.setFollower(new HashSet<>(Arrays.asList(user)));

        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        when(sellerRepository.read(sellerIdFollowed)).thenReturn(Optional.of(sellerFollowed));
        assertThrows(AlreadyFollowingException.class,() -> service.followSeller(userId,sellerIdFollowed));
       }

    @Test
    void unfollowSeller_shouldWorkWhenSellerExistsOnFollowings() {
        Long userId = 1L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).userWithFollowings().build();
        Seller sellerToUnfollow = user.getFollowing().stream().findFirst().get();
        Long sellerIdToUnfollow = sellerToUnfollow.getId();
        sellerToUnfollow.setFollower(new HashSet<>(Arrays.asList(user)));

        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        when(userRepository.findSellerInFollowings(user, sellerIdToUnfollow)).thenReturn(Optional.of(sellerToUnfollow));
        MessageResponseDTO respond = service.unfollowSeller(userId, sellerIdToUnfollow);

        assertTrue(sellerToUnfollow.getFollower().isEmpty());
        assertFalse(user.getFollowing().contains(sellerToUnfollow));
        assertEquals(new MessageResponseDTO("You have just unfollowed a seller"), respond);
        verify(userRepository,times(1)).findSellerInFollowings(user,sellerIdToUnfollow);
        verify(userRepository, times(1)).read(userId);
    }

    @Test
    void unfollowSeller_shouldThrowNotAFollowerException(){
        Long userId = 1L;
        Long sellerIdToUnfollow = 999L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).userWithFollowings().build();

        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        when(userRepository.findSellerInFollowings(user, sellerIdToUnfollow)).thenThrow(NotFollowingException.class);

        assertThrows(NotFollowingException.class,() -> service.unfollowSeller(userId,sellerIdToUnfollow));
        verify(userRepository,times(1)).findSellerInFollowings(user, sellerIdToUnfollow);
    }

    @Test
    void unfollowSeller_shouldThrowUnFollowingMyselfException(){
        Long userId = 1L;
        Long sellerIdToUnFollow = 1L;
        assertThrows(UnfollowingMyselfException.class,() -> service.unfollowSeller(userId,sellerIdToUnFollow));
    }
}
