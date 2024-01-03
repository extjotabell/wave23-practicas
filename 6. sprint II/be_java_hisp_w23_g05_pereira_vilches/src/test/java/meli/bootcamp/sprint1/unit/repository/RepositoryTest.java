package meli.bootcamp.sprint1.unit.repository;

import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("Test: Find user by id")
    void findUserById(){
        //Arrange
        int userId = 2;
        //Act
        User actual = repository.findUserById(userId);
        //Assert
        assertEquals("Brenda Torrico", actual.getName());
    }

    @Test
    @DisplayName("Test: Find user by id")
    void findCategoryById(){
        //Arrange
        int categoryId = 4;
        //Act
        Category actual = repository.findCategoryById(categoryId);
        //Assert
        assertNotNull(actual);
        assertEquals("Toys", actual.getDescription());
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
        assertTrue(user.getFollowers().contains(userIdToFollow));
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
        assertFalse(user.getFollowed().contains(userIdToUnfollow));
    }
}
