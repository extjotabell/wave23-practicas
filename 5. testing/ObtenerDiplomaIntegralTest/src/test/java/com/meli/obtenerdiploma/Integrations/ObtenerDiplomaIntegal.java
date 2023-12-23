package com.meli.obtenerdiploma.Integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaIntegralTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testSayHelloOk() throws Exception {
        StudentDTO responseDTO = new StudentDTO(1L, "Juan",
                                                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                                                7.333333333333333, List.of(new SubjectDTO("Matematica", 9.0),
                                                                           new SubjectDTO("Fisica", 7.0),
                                                                           new SubjectDTO("Quimica", 6.0)));

        ObjectWriter objecTWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(responseDTO);

        this.mockMvc.perform(get("/analyzeScores/{studentId}", 1L)).andDo(print())
                                          .andExpect(status().isOk())
                                          .andExpect(content().contentType("application/json")).andExpect(jsonPath("$.id").value(1L));

    }

    @Test
    void testSayHelloNonOk() throws Exception {

        Long id = -1L;
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id -1 no se encuetra registrado.");

        //Segundo : deserializer to string - JSON manualmente
        ObjectWriter objecTWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        //dato de salida
        String responseJson = objecTWriter.writeValueAsString(errorDTO);

        //when
        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}", id)).andDo(print())
                                          .andExpect(status().isNotFound())
                                          .andExpect(content().contentType("application/json")).andReturn();

        assertEquals(mvcResult.getResponse().getContentAsString(), responseJson);
    }

}
