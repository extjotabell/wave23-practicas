package com.mercadolibre.starwars.integration;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper writer = new ObjectMapper();

    @Test
    void findCharacterMultipleResultsTest() throws Exception{
        //Arrange
        List<CharacterDTO> expectedList = new ArrayList<>();
        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Luke Skywalker");
        character1.setHeight(172);
        character1.setMass(77);
        character1.setHair_color("blond");
        character1.setSkin_color("fair");
        character1.setEye_color("blue");
        character1.setBirth_year("19BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        expectedList.add(character1);

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Anakin Skywalker");
        character2.setHeight(188);
        character2.setMass(84);
        character2.setHair_color("blond");
        character2.setSkin_color("fair");
        character2.setEye_color("blue");
        character2.setBirth_year("41.9BBY");
        character2.setGender("male");
        character2.setHomeworld("Tatooine");
        character2.setSpecies("Human");
        expectedList.add(character2);

        CharacterDTO character3 = new CharacterDTO();
        character3.setName("Shmi Skywalker");
        character3.setHeight(163);
        character3.setHair_color("black");
        character3.setSkin_color("fair");
        character3.setEye_color("brown");
        character3.setBirth_year("72BBY");
        character3.setGender("female");
        character3.setHomeworld("Tatooine");
        character3.setSpecies("Human");
        expectedList.add(character3);

        //Preparing request
        String queryName = "Skywalker";
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}",
                        queryName);

        // Preparing expected
        ResultMatcher statusExcpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedList));

        //Act and Assert
        mockMvc.perform(request)
                .andExpect(statusExcpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void findCharacterOneResultTest() throws Exception{
        //Arrange
        List<CharacterDTO> expectedList = new ArrayList<>();
        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Lobot");
        character1.setHeight(175);
        character1.setMass(79);
        character1.setHair_color("none");
        character1.setSkin_color("light");
        character1.setEye_color("blue");
        character1.setBirth_year("37BBY");
        character1.setGender("male");
        character1.setHomeworld("Bespin");
        character1.setSpecies("Human");
        expectedList.add(character1);

        //Preparing request
        String queryName = "Lobot";
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}",
                queryName);

        // Preparing expected
        ResultMatcher statusExcpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedList));

        //Act and Assert
        mockMvc.perform(request)
                .andExpect(statusExcpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findCharacterNoneTest() throws Exception{
        //Arrange

        // Preparing expected

        List<CharacterDTO> expectedList = new ArrayList<>();

        ResultMatcher statusExcpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedList));

        String queryName = "Mordor";
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}",
                queryName);


        //Act and Assert
        mockMvc.perform(request)
                .andExpect(statusExcpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

}
