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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T_0005 {
    @Mock
    GeneralRepository repository;

    @InjectMocks
    UserService service;

    @Test
    @DisplayName("T-0008/ Verify parameter order")
    void T_0008Ok(){
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
    @DisplayName("T-0008/ Verify parameter order: null")
    void T_0008Null(){
        //Arrange
        int userId = 2;
        User user = generateUser();
        User seller = generateSeller();

        String order = null;

        LastPostsDto expected = generateLastPostDto();

        when(repository.findUserById(2)).thenReturn(user);
        when(repository.findUserById(seller.getId())).thenReturn(seller);
        //Act
        LastPostsDto actual = service.getLastPosts(userId,order);
        //Assert
        assertEquals(expected.getUser_id(), actual.getUser_id());
    }

    @Test
    @DisplayName("T-0008/ Verify parameter order, throws exception")
    void T_0008NotOk(){
        //Arrange
        int userId = 1;
        String order = "";
        //Act
        //Assert
        assertThrows(BadRequestException.class, ()-> service.getLastPosts(userId,order));
    }
}
