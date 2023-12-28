package meli.bootcamp.sprint1.unit.service;

import meli.bootcamp.sprint1.dto.response.LastPostsDto;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import meli.bootcamp.sprint1.service.impl.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static meli.bootcamp.sprint1.utils.Factory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T_0006 {
    @Mock
    GeneralRepository repository;
    @InjectMocks
    UserService service;

    @Test
    @DisplayName("T_0006OrderByDateDesc")
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
    @DisplayName("T_0006OrderByDateAsc")
    void T_0006OrderByDateAsc(){

        //Arrange
        String order = "date_asc";
        User seller = generateSeller();
        User user = generateUser();

        LastPostsDto expected = generateLastPostDtoOrdered(order);

        when(repository.findUserById(user.getId())).thenReturn(user);
        when(repository.findUserById(seller.getId())).thenReturn(seller);

        //Act
        LastPostsDto lastPostsDto = service.getLastPosts(user.getId(),order);

        //Assert
        assertEquals(LocalDate.of(2023,12,18),lastPostsDto.getPosts().get(0).getDate());
        assertEquals(expected.getPosts().size(),lastPostsDto.getPosts().size());
    }
}
