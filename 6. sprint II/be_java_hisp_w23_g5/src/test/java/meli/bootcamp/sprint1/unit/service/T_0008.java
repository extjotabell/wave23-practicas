package meli.bootcamp.sprint1.unit.service;


import meli.bootcamp.sprint1.dto.response.LastPostsDto;

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

import static meli.bootcamp.sprint1.utils.Factory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T_0008 {

    @Mock
    GeneralRepository repository;

    @InjectMocks
    UserService service;

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
