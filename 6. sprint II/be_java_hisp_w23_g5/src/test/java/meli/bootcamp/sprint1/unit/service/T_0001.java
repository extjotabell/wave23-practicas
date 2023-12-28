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

import static meli.bootcamp.sprint1.utils.Factory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T_0001 {

    @Mock
    GeneralRepository repository;

    @InjectMocks
    UserService service;

    @Test
    @DisplayName("T-0001/ Verify user to follow exist Ok test")
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

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(20)).thenReturn(null);

        //Act
        //Assert
        assertThrows(BadRequestException.class, () -> service.followUser(user.getId(), 20));

    }
}
