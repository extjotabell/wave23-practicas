package util;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public class ObjectFactory {
    public static List<CharacterDTO> createListFindByNameContainsDarth(){
        return List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow",
                        "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow",
                        "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );
    }
    public static List<CharacterDTO> createListFindByNameContainsLuke(){
        return List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue",
                        "19BBY", "male", "Tatooine", "Human", 172, 77)
        );
    }
}
