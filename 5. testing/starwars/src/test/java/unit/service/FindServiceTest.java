package unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Find;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static util.ObjectFactory.createListFindByNameContainsDarth;
import static util.ObjectFactory.createListFindByNameContainsLuke;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository repository;
    @InjectMocks
    FindService service;

    @Test
    void findTestByNameDarthOk(){
        //Arrange
        String query = "Darth";
        List<CharacterDTO> expected = createListFindByNameContainsDarth();

        //Act
        when(repository.findAllByNameContains(query)).thenReturn(expected);
        List<CharacterDTO> actual = service.find(query);
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    void findTestByNameLukeOk(){
        //Arrange
        String query = "Luke";
        List<CharacterDTO> expected = createListFindByNameContainsLuke();

        //Act
        when(repository.findAllByNameContains(query)).thenReturn(expected);
        List<CharacterDTO> actual = service.find(query);
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    void findTestByNoExistName(){
        //Arrange
        String query = "NoExistName";
        List<CharacterDTO> expected = Collections.emptyList();

        //Act
        when(repository.findAllByNameContains(query)).thenReturn(expected);
        List<CharacterDTO> actual = service.find(query);
        //Assert
        assertEquals(expected,actual);
    }
}
