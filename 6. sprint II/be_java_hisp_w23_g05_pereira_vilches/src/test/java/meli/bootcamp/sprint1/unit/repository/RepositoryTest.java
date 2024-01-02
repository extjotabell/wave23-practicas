package meli.bootcamp.sprint1.unit.repository;

import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryTest {

    GeneralRepository repository = new GeneralRepository();
    User user;
    int followed;

    @BeforeEach
    void setup(){
        user = repository.findUserById(1);
        followed = user.getFollowed().size();
    }

    @Test
    @DisplayName("Test: Add new follower/followed")
    void testNewFollower(){
        //Arrange
        int userId = 1;
        int userIdToFollow = user.getFollowed().get(0);
        int sizeExpected = followed + 1;
        //Act
        repository.addNewFollowed(userId, userIdToFollow);
        //Assert
        assertEquals(sizeExpected, user.getFollowed().size());
    }

    @Test
    @DisplayName("Test: Unfollow user")
    void testUnfollow(){
        //Arrange
        int userId = 1;
        int userIdToUnfollow = user.getFollowed().get(0);
        int sizeExpected = followed - 1;
        //Act
        repository.unfollowUser(userId, userIdToUnfollow);
        //Assert
        assertEquals(sizeExpected, user.getFollowed().size());
    }
}
