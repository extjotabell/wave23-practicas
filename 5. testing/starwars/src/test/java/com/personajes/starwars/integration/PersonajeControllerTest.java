package com.personajes.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.personajes.starwars.dto.request.PersonajeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonajeControllerTest {
    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer;

    @Test
    void obtenerMatchesTest() throws Exception {
        PersonajeDto p1 = new  PersonajeDto();
        p1.setName("Darth Vader");
        p1.setHeight(202);
        p1.setMass(136);
        p1.setGender("male");
        p1.setHomeworld("Tatooine");
        p1.setSpecies("Human");
        PersonajeDto p2 = new  PersonajeDto();
        p2.setName("Darth Maul");
        p2.setHeight(175);
        p2.setMass(80);
        p2.setGender("male");
        p2.setHomeworld("Dathomir");
        p2.setSpecies("Zabrak");
        List<PersonajeDto> personajes = List.of(p1, p2);
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(personajes);
        MvcResult mvcResult = this.mockMvc.perform(get("/findMatches/{pattern}", "Darth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8), payloadJson);
    }

}
