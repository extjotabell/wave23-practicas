package meli.bootcamp.sprint1.unit.service;

import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.exception.BadRequestException;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import meli.bootcamp.sprint1.service.impl.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static meli.bootcamp.sprint1.utils.Factory.generateSeller;
import static meli.bootcamp.sprint1.utils.Factory.generateUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T_0002 {
    @Mock
    GeneralRepository repository;

    @InjectMocks
    UserService service;

    @Test
    @DisplayName("T-0008/ Verify user existance")
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
    @DisplayName("T-0008/ Verify user not exists")
    void T_0002NotOk(){
        //Arrange
        User userFollower = generateUser();
        User userFollowed = generateSeller();

        when(repository.findUserById(userFollower.getId())).thenReturn(userFollower);
        when(repository.findUserById(userFollowed.getId())).thenReturn(null);

        //Act
        //Assert
        assertThrows(BadRequestException.class, ()-> service.unfollowUser(userFollower.getId(), userFollowed.getId()));
    }

}
