package meli.bootcamp.sprint1.unit.service;

import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.dto.response.FollowersDto;
import meli.bootcamp.sprint1.dto.response.LastPostsDto;
import meli.bootcamp.sprint1.dto.response.UserWFollowerListDto;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.exception.BadRequestException;
import meli.bootcamp.sprint1.exception.EmptyListException;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import meli.bootcamp.sprint1.service.impl.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static meli.bootcamp.sprint1.utils.Factory.*;
import static meli.bootcamp.sprint1.utils.Factory.generateSeller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class UserServiceTest {

    @Mock
    GeneralRepository repository;

    @InjectMocks
    UserService service;

    @Test
    @DisplayName("T-0001/ Verify user to follow exists test")
    void T_0001OkTest(){

        //Arrange
        User seller = generateSellerNoFollowers();
        User user = generateUser();

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(seller.getId())).thenReturn(seller);
        BaseResponseDto expected = new BaseResponseDto("User followed");

        //Act
        BaseResponseDto response = service.followUser(user.getId(), seller.getId());

        //Assert
        assertEquals(expected,response);
    }

    @Test
    @DisplayName("T-0001/ Verify user to follow not exist test")
    void T_0001ExceptionTest(){

        //Arrange
        User user = generateUser();
        int userId = user.getId();

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(20)).thenReturn(null);

        //Act
        //Assert
        assertThrows(BadRequestException.class, () -> service.followUser(userId, 20));

    }

    @Test
    @DisplayName("T-0002/ Verify user exists")
    void T_0002(){
        //Arrange
        User userFollower = generateUser();
        User userFollowed = generateSeller();
        BaseResponseDto expected = new BaseResponseDto("User " + userFollowed.getId() + " was unfollowed");

        when(repository.findUserById(userFollower.getId())).thenReturn(userFollower);
        when(repository.findUserById(userFollowed.getId())).thenReturn(userFollowed);
        when(repository.unfollowUser(userFollower.getId(), userFollowed.getId())).thenReturn(true);

        //Act
        BaseResponseDto actual = service.unfollowUser(userFollower.getId(), userFollowed.getId());

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("T-0002/ Verify user not exists")
    void T_0002NotOk(){
        //Arrange
        User userFollower = generateUser();
        User userFollowed = generateSeller();
        int userFollowerId = userFollower.getId();
        int userFollowedId = userFollowed.getId();


        when(repository.findUserById(userFollower.getId())).thenReturn(userFollower);
        when(repository.findUserById(userFollowed.getId())).thenReturn(null);

        //Act
        //Assert
        assertThrows(BadRequestException.class, ()-> service.unfollowUser(userFollowerId, userFollowedId));
    }

    @Test
    @DisplayName("T-0003/ Verify sorted asc list test")
    void T_0003AscTestOk(){

        //Arrange
        User user = generateUser2();
        User follower = generateSeller();
        User follower2 = generateUser();

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(follower.getId())).thenReturn(follower);
        when(repository.findUserById(follower2.getId())).thenReturn(follower2);

        //Act
        UserWFollowerListDto response = service.getFollowersById(user.getId(), "name_asc");

        //Assert
        assertEquals("Marco",response.getFollowers().get(0).getUser_name());
        assertEquals("Nico",response.getFollowers().get(1).getUser_name());

    }

    @Test
    @DisplayName("T-0003/ Verify sorted desc list test")
    void T_0003DescTestOk(){

        //Arrange
        User user = generateUser2();
        User follower = generateSeller();
        User follower2 = generateUser();

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(follower.getId())).thenReturn(follower);
        when(repository.findUserById(follower2.getId())).thenReturn(follower2);

        //Act
        UserWFollowerListDto response = service.getFollowersById(user.getId(), "name_desc");

        //Assert
        assertEquals("Nico",response.getFollowers().get(0).getUser_name());
        assertEquals("Marco",response.getFollowers().get(1).getUser_name());

    }

    @Test
    @DisplayName("T-0003/ Verify exception test")
    void T_0003ExceptionTest(){

        //Arrange
        User user = generateUser2();
        User follower = generateSeller();
        User follower2 = generateUser();
        int userId = user.getId();

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(follower.getId())).thenReturn(follower);
        when(repository.findUserById(follower2.getId())).thenReturn(follower2);

        //Act
        //Assert
        assertThrows(BadRequestException.class, () -> service.getFollowersById(userId, " "));

    }

    @Test
    @DisplayName("T-0004/ Validate sort by name desc test")
     void validateDesc(){
        int userId = 4;
        String order = "name_desc";

        UserWFollowerListDto userExpected = generateUserDtoList(order);

        List<User> users = generateUsersList();

        users.forEach(user -> when(repository.findUserById(user.getId())).thenReturn(user));

        UserWFollowerListDto actual = service.getFollowersById(userId,order);

        assertEquals(actual.getFollowers().size(),userExpected.getFollowers().size());
        assertEquals(actual.getFollowers(),userExpected.getFollowers());
    }
    @Test
    @DisplayName("T-0004/ Validate sort by name asc test")
     void validateAsc(){
        int userId = 4;
        String order = "name_asc";

        UserWFollowerListDto userExpected = generateUserDtoList(order);

        List<User> users = generateUsersList();

        users.forEach(user -> when(repository.findUserById(user.getId())).thenReturn(user));

        UserWFollowerListDto actual = service.getFollowersById(userId,order);

        assertEquals(actual.getFollowers().size(),userExpected.getFollowers().size());
        assertEquals(actual.getFollowers(),userExpected.getFollowers());
    }

    @Test
    @DisplayName("T-0004/ Validate sort by name test, throws exception")
    void emptyListTest (){
        int userId = 4;
        String orderAsc = "name_asc";
        String orderDesc = "name_desc";
        String order = "";

        User user4 = new User(userId,"Geronimo Schmidt",true, Collections.emptyList(),Collections.emptyList(),Collections.emptyList());
        int user4id = user4.getId();

        when(repository.findUserById(user4.getId())).thenReturn(user4);

        assertThrows(EmptyListException.class,()-> service.getFollowersById(user4id,orderAsc));
        assertThrows(EmptyListException.class,()-> service.getFollowersById(user4id,orderDesc));
        assertThrows(EmptyListException.class,()-> service.getFollowersById(user4id,order));
    }

    @Test
    @DisplayName("T-0005/ Verify parameter order")
    void T_0005Ok(){
        //Arrange
        int userId = 2;
        User user = generateUser();
        User seller = generateSeller();

        String order = "date_desc";

        LastPostsDto expected = generateLastPostDto();

        when(repository.findUserById(2)).thenReturn(user);
        when(repository.findUserById(seller.getId())).thenReturn(seller);
        //Act
        LastPostsDto actual = service.getLastPosts(userId,order);
        //Assert
        assertEquals(expected.getUser_id(), actual.getUser_id());
    }

    @Test
    @DisplayName("T-0005/ Verify parameter order: null")
    void T_0005Null(){
        //Arrange
        int userId = 2;
        User user = generateUser();
        User seller = generateSeller();

        LastPostsDto expected = generateLastPostDto();

        when(repository.findUserById(2)).thenReturn(user);
        when(repository.findUserById(seller.getId())).thenReturn(seller);
        //Act
        LastPostsDto actual = service.getLastPosts(userId, null);
        //Assert
        assertEquals(expected.getUser_id(), actual.getUser_id());
    }

    @Test
    @DisplayName("T-0005/ Verify parameter order, throws exception")
    void T_0005NotOk(){
        //Arrange
        int userId = 1;
        String order = "";
        //Act
        //Assert
        assertThrows(BadRequestException.class, ()-> service.getLastPosts(userId,order));
    }

    @Test
    @DisplayName("T_0006/ Verify order by date: desc")
    void T_0006OrderByDateDesc(){

        //Arrange
        String order = "date_desc";
        User seller = generateSeller();
        User user = generateUser();

        LastPostsDto expected = generateLastPostDtoOrdered(order);

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(seller.getId())).thenReturn(seller);

        //Act
        LastPostsDto lastPostsDto = service.getLastPosts(user.getId(),order);

        //Assert
        assertEquals(LocalDate.now(),lastPostsDto.getPosts().get(0).getDate());
        assertEquals(expected.getPosts().size(),lastPostsDto.getPosts().size());
    }

    @Test
    @DisplayName("T_0006/ Verify order by date: asc")
    void T_0006OrderByDateAsc(){

        //Arrange
        LocalDate today = LocalDate.now();
        String order = "date_asc";
        User seller = generateSeller();
        User user = generateUser();

        LastPostsDto expected = generateLastPostDtoOrdered(order);

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(seller.getId())).thenReturn(seller);

        //Act
        LastPostsDto lastPostsDto = service.getLastPosts(user.getId(),order);

        //Assert
        assertEquals(today.minusDays(11),lastPostsDto.getPosts().get(0).getDate());
        assertEquals(expected.getPosts().size(),lastPostsDto.getPosts().size());
    }

    @Test
    @DisplayName("T-0007/ Verify user followers list count")
    void verifyFollowersCount() {
        //Arrange
        User user = generateUser2();

        when(repository.findUserById(user.getId())).thenReturn(user);

        //Act
        FollowersDto followers = service.getFollowersByUserId(user.getId());

        //Assert
        assertEquals(2, followers.getFollowers_count());
    }

    @Test
    @DisplayName("T-0007/ Verify user followers list count equals 0")
    void verifyFollowersCount0() {
        //Arrange
        User user = generateUser();

        when(repository.findUserById(user.getId())).thenReturn(user);

        //Act
        FollowersDto followers = service.getFollowersByUserId(user.getId());

        //Assert
        assertEquals(0, followers.getFollowers_count());
    }

    @Test
    @DisplayName("T-0008/ Verify posts from last two weeks ")
    void T_0008OkTest(){

        //Arrange
        User seller = generateSeller();
        User user = generateUser();
        int expected = 3;

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(seller.getId())).thenReturn(seller);

        //Act
        LastPostsDto lastPostsDto = service.getLastPostsFromFollowed(user.getId());

        //Assert
        assertEquals(expected,lastPostsDto.getPosts().size());
    }

    @Test
    @DisplayName("T-0008/ Verify exception test ")
    void T_0008BadRequestExceptionTest(){

        //Arrange
        when(repository.findUserById(anyInt())).thenReturn(null);

        //Act
        //Assert
        assertThrows(BadRequestException.class, () -> service.getLastPostsFromFollowed(20));
    }
}