package com.mercadolibre.blog.integrationTesting;

import com.mercadolibre.blog.dto.response.EntradaDto;
import com.mercadolibre.blog.dto.response.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static com.mercadolibre.blog.utils.FactoryObjetcts.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test: crearEntrada")
    public void crearEntrada() throws Exception {
        System.out.println("Ejecutando test: crearEntrada" );
        String requestJson = writer().writeValueAsString(getInstanciaDeEntradaRequestDto());
        String responseJson = writer().writeValueAsString(getInstanciaDeEntradaIdDto());

        this.mockMvc.perform(post("/blog")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().json(responseJson))
                        .andReturn();
    }

    @Test
    @DisplayName("Test: buscarPorId que no encuentre")
    public void buscarPorIdNotOk() throws Exception {
        System.out.println("Ejecutando test: buscarPorIdNotOk" );
        ErrorDto errorDto = new ErrorDto("No existe entrada con el id: 1", 404);

        String responseJson = writer().writeValueAsString(errorDto);

        this.mockMvc.perform(get("/blog/{id}", 1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().json(responseJson))
                .andReturn();
    }

    @Test
    @DisplayName("Test: buscarPorId")
    public void buscarPorId() throws Exception {
        System.out.println("Ejecutando test: buscarPorId" );
        String requestJson = writer().writeValueAsString(getInstanciaDeEntradaRequestDto());
        String responseJson = writer().writeValueAsString(getInstanciaDeEntradaDto());

        //Agregar entrada al blog si no se corren todos los test juntos
        this.mockMvc.perform(post("/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson));

        //Buscar por ID
        MvcResult mvcResult = this.mockMvc.perform(get("/blog/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson))
                .andReturn();

    }

}
