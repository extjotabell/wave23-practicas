package com.demospring.demo.integrationtest;

import com.demospring.demo.dto.AlumnoDTO;
import com.demospring.demo.dto.ListAllAlumnosDTO;
import com.demospring.demo.dto.MateriaDTO;
import com.demospring.demo.entity.Alumno;
import com.demospring.demo.entity.Materia;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class AlumnoControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
            .writer();

    @Test
    void getAllAlumnosTest() throws Exception {
        // arrange
        List<AlumnoDTO> alumnoDTOList = new ArrayList<>();
        AlumnoDTO alumnoDTO = new AlumnoDTO("4040", "Jean", LocalDate.of(1998,02,05),25,
                List.of(new MateriaDTO("1", "Matematicas", 9D)
                )
        );
        alumnoDTOList.add(alumnoDTO);

        ListAllAlumnosDTO listAllAlumnosDTO = new ListAllAlumnosDTO();
        listAllAlumnosDTO.setAlumnoList(alumnoDTOList);

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/alumnos/getAll");

        // expect
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(listAllAlumnosDTO));  //pasar de dto a jso

        mockMvc.perform(request)                                //ejecuta request
                .andExpect(contentBodyExpected)                 //que coincida body
                .andExpect(statusExpected)                      //que coincida status
                .andExpect(contentTypeExpected)                 //que coincida content type
                .andDo(MockMvcResultHandlers.print());          //ver respuesta
    }
}
