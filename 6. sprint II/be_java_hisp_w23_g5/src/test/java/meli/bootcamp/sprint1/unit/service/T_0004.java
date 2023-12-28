package meli.bootcamp.sprint1.unit.service;

import meli.bootcamp.sprint1.dto.response.UserWFollowerListDto;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.exception.EmptyListException;
import meli.bootcamp.sprint1.repository.impl.GeneralRepository;
import meli.bootcamp.sprint1.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static meli.bootcamp.sprint1.utils.Factory.generateUserDtoList;
import static meli.bootcamp.sprint1.utils.Factory.generateUsersList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class T_0004 {
    @Mock
    GeneralRepository repository;
    @InjectMocks
    UserService service;
    @Test
    public void validarDesc(){
        int userId = 4;
        String order = "name_desc";

        UserWFollowerListDto userExpected = generateUserDtoList(order);

        List<User> users = generateUsersList();

        users.stream().forEach(user -> when(repository.findUserById(user.getId())).thenReturn(user));

        UserWFollowerListDto actual = service.getFollowersById(userId,order);

        assertEquals(actual.getFollowers().size(),userExpected.getFollowers().size());
        assertEquals(actual.getFollowers(),userExpected.getFollowers());
    }
    @Test
    public void validarAsc(){
        int userId = 4;
        String order = "name_asc";

        UserWFollowerListDto userExpected = generateUserDtoList(order);

        List<User> users = generateUsersList();

        users.stream().forEach(user -> when(repository.findUserById(user.getId())).thenReturn(user));

        UserWFollowerListDto actual = service.getFollowersById(userId,order);

        assertEquals(actual.getFollowers().size(),userExpected.getFollowers().size());
        assertEquals(actual.getFollowers(),userExpected.getFollowers());
    }

    @Test
    void emptyListTest (){
        int userId = 4;
        String orderAsc = "name_asc";
        String orderDesc = "name_desc";
        String order = "";

        User user4 = new User(userId,"Geronimo Schmidt",true, Collections.emptyList(),Collections.emptyList(),Collections.emptyList());

        when(repository.findUserById(user4.getId())).thenReturn(user4);

        assertThrows(EmptyListException.class,()-> service.getFollowersById(user4.getId(),orderAsc));
        assertThrows(EmptyListException.class,()-> service.getFollowersById(user4.getId(),orderDesc));
        assertThrows(EmptyListException.class,()-> service.getFollowersById(user4.getId(),order));
    }

}
