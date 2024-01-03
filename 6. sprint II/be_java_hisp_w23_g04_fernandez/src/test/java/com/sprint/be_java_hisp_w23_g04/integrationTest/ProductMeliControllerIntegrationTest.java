package com.sprint.be_java_hisp_w23_g04.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostListDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.utils.UtilsIntegrationTests;
import org.junit.jupiter.api.DisplayName;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductMeliControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    /** Testing US-0005: POST /products/post **/
    @Test
    @DisplayName("Save post: Should create the new post and inform that it was saved successfully")
    public void savePostTest() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005();
        SimpleMessageDTO expectedResponse = new SimpleMessageDTO("El post para el user: 5 se guardó exitosamente");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 200
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - User not found: Should inform error message")
    public void savePostTestUserNotFound() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("invalid_user");
        SimpleMessageDTO expectedResponse = UtilsIntegrationTests.generateUserNotFoundMessage(88);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 404
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    //Testing validations from payload
    @Test
    @DisplayName("Save post - UserId on Null: Should inform validation error message")
    public void savePostTestUserIdOnNull() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("user_on_null");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El id del usuario no puede estar vacío']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - UserId is 0: Should inform validation error message")
    public void savePostTestUserIdIs0() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("user_on_zero");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El id del usuario debe ser mayor a cero']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Date on null: Should inform validation error message")
    public void savePostTestDateOnNull() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("date_null");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['La fecha no puede estar vacía']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - ProductId on null: Should inform validation error message")
    public void savePostTestProductIdOnNull() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_on_null");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El id del producto no puede estar vacío']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - ProductId is 0: Should inform validation error message")
    public void savePostTestProductIdIs0() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_on_zero");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El id del producto debe ser mayor a cero']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product name is null: Should inform validation error message")
    public void savePostTestProductNameNull() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_name_null");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El nombre del producto no puede estar vacío']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product name is no between 1 < length > 40: Should inform validation error message")
    public void savePostTestProductNameLarge() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_name_large");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['La longitud del nombre del producto no puede superar los 40 caracteres']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product name has special characters: Should inform validation error message")
    public void savePostTestInvalidProductName() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_name_special_chars");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El color del producto no puede poseer caracteres especiales']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product type is null: Should inform validation error message")
    public void savePostTestProductTypeOnNull() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_type_on_null");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El tipo del producto no puede estar vacío']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product type out of range, 1 < length > 15: Should inform validation error message")
    public void savePostTestProductTypeOutOfRange() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_type_large");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['La longitud del tipo del producto no puede superar los 15 caracteres']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product type has special chars: Should inform validation error message")
    public void savePostTestProductTypeWithSpecialChars() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_type_special_chars");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El tipo del producto no puede poseer caracteres especiales']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product brand on null: Should inform validation error message")
    public void savePostTestProductBrandOnNull() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_brand_null");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['La marca del producto no puede estar vacía']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product brand out of range, 1 < length < 25: Should inform validation error message")
    public void savePostTestProductBrandOutOfRange() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_brand_large");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['La longitud de la marca del producto no puede superar los 25 caracteres']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Save post - Product brand contains special chars: Should inform validation error message")
    public void savePostTestProductBrandWithSpecialChars() throws Exception {
        //Arrange
        PostDTO payloadDTO = UtilsIntegrationTests.generatePostDTOUS0005("product_brand_special_chars");
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['La marca del producto no puede poseer caracteres especiales']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payloadDTO));

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(expectedResponse);


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    //TODO: Add validation test for productDTO.message and productDTO.notes

    /** Testing US-0006: GET /products/followed/{userId}/list **/

    @Test
    @DisplayName("Get posts published in the lasts 2 weeks: Should return the list with posts published in the last 2 weeks oby the followed sellers, sorted by date ASC")
    public void getFilteredPostTest() throws Exception {
        //Arrange
        PostListDTO expectedList = UtilsIntegrationTests.generatePostListDTOUS0006(4,"date_asc");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list",4);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedList));


        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 200
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

}
