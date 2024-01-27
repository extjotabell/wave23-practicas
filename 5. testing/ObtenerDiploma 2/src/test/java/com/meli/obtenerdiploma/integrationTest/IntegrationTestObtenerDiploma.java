package com.meli.obtenerdiploma.integrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTestObtenerDiploma {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void testAnalyzeScores () throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(7.333333333333333))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name").value("Matemática"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].score").value(10.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[1].name").value("Física"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[1].score").value(8.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[2].name").value("Química"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[2].score").value(4.0)).andReturn();
    }

    @Test
    public void testAnalyzeScoresNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", "99"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 99 no se encuetra registrado."))
                .andReturn();
    }

    @Test
    public void testAnalyzeScoresMethodArgumentNotValid() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", "ErrorString"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

}
