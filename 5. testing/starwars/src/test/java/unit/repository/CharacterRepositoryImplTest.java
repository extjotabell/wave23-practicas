package unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ObjectFactory.createListFindByNameContainsDarth;
import static util.ObjectFactory.createListFindByNameContainsLuke;

public class CharacterRepositoryImplTest {

    @Test
    void findAllByNameContainsDarth(){
        //Arrange
        CharacterRepositoryImpl repository = new CharacterRepositoryImpl();
        String query = "Darth";
        List<CharacterDTO> expected = createListFindByNameContainsDarth();
        //Act
        List<CharacterDTO> actual = repository.findAllByNameContains(query);
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    void findAllByNameContainsLuke(){
        //Arrange
        CharacterRepositoryImpl repository = new CharacterRepositoryImpl();
        String query = "Luke";
        List<CharacterDTO> expected = createListFindByNameContainsLuke();
        //Act
        List<CharacterDTO> actual = repository.findAllByNameContains(query);
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    void findAllByNameNotFound(){
        //Arrange
        CharacterRepositoryImpl repository = new CharacterRepositoryImpl();
        String query = "Isabel";
        List<CharacterDTO> expected = Collections.emptyList();
        //Act
        List<CharacterDTO> actual = repository.findAllByNameContains(query);
        //Assert
        assertEquals(expected,actual);
    }

}
