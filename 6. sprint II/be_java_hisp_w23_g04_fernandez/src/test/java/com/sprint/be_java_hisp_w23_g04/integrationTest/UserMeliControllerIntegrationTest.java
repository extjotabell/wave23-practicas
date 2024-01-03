package com.sprint.be_java_hisp_w23_g04.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SellerDTO;
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
public class UserMeliControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    /** Testing US-001: POST /users/{userId}/follow/{userIdToFollow} **/
    @Test
    @DisplayName("Follow user: Valid userdId and valid sellerId. User should start follow the seller and show successfully message")
    public void followUserIntegrationTest() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = new SimpleMessageDTO("El usuario con id:5 ahora sigue a vendedor con id:7");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",5,7);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 200
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Follow user - User not exists: Invalid userdId, should inform user not exists")
    public void followUserIntegrationTestUserNotFound() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = UtilsIntegrationTests.generateUserNotFoundMessage(99);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",99,7);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 404
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Follow user - Same userId: Seller try to follow himself. Should inform error message")
    public void followUserIntegrationTestFollowToHimself() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = new SimpleMessageDTO("El usuario y vendedor con id:4 no pueden ser el mismo.");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",4,4);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Follow user - User to follow isn't a seller: Should inform error message")
    public void followUserIntegrationTestFollowToOtherUser() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = new SimpleMessageDTO("El id de usuario vendedor proporcionado no es valido.");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",6,4);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Follow user - User already follows seller: Should inform error message")
    public void followUserIntegrationTestAlreadyFollowsSeller() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = new SimpleMessageDTO("El usuario con id:4 ya sigue al vendedor con id:1");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",4,1);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Follow user - UserId on 0: Should inform error message")
    public void followUserIntegrationTestUserIdOn0() throws Exception {
        //Arrange
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El id debe ser mayor a cero']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",0,1);

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

    /** Testing US-0002: GET /users/{userId}/followers/count **/
    @Test
    @DisplayName("Followers count: Given an userId returns the number of followers")
    public void followersCountTest() throws Exception {
        //Arrange
        SellerDTO expectedResponse = new SellerDTO(1,"Juan Perez",2);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",1);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Followers count - Seller without followers: Should return followers count value on 0")
    public void followersCountTestSellerWithoutFollowers() throws Exception {
        //Arrange
        SellerDTO expectedResponse = new SellerDTO(8,"Pablo Gonzalez",0);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",8);

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
    @DisplayName("Followers count - Invalid userId: Should inform error")
    public void followersCountTestInvalidUserId() throws Exception {
        //Arrange
        SimpleMessageDTO expectedResponse = UtilsIntegrationTests.generateUserNotFoundMessage(66);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",66);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("Followers count - UserId is 0: Should inform error")
    public void followersCountTestUserIdIs0() throws Exception {
        //Arrange
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El id del usuario debe ser mayor a cero']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",0);

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


    /** Testing US-0003: GET /users/{userId}/followers/list **/

    @Test
    @DisplayName("List followers: Given an SellerID Should return the list with the names of followers")
    public void getFollowersByUserIdTest() throws Exception {
        //Arrange
        BuyerDTO expectedResponse = UtilsIntegrationTests.getBuyerDTOTestUS0003();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",1);

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
    @DisplayName("List followers - Invalid order param: Should inform error message")
    public void getFollowersByUserIdTestInvalidOrderParam() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = new SimpleMessageDTO("El criterio de ordenamiento no existe.");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list?order=test",1);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("List followers - Invalid userId: Should inform error message")
    public void getFollowersByUserIdTestInvalidUserId() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = UtilsIntegrationTests.generateUserNotFoundMessage(99);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",99);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 404
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("List followers - Empty body: Seller without followers. Expects No content status")
    public void getFollowersByUserIdTestEmptyBody() throws Exception {
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",4);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();;

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 204
                .andExpect(jsonPath("$").doesNotExist()) // Verify body empty
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("List followers - Sort result by name ASC: Given an SellerID Should return the list with the names of followers sorted by name ASC")
    public void getFollowersByUserIdTestOrderTypeAsc() throws Exception {
        //Arrange
        BuyerDTO expectedResponse = UtilsIntegrationTests.getBuyerDTOTestUS0003("name_asc");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",1);

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
    @DisplayName("List followers - Sort result by name DSC: Given an SellerID Should return the list with the names of followers sorted by name DSC")
    public void getFollowersByUserIdTestOrderTypeDesc() throws Exception {
        //Arrange
        BuyerDTO expectedResponse = UtilsIntegrationTests.getBuyerDTOTestUS0003("name_dsc");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",1);

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

    /** Testing US-0004: GET /users/{userId}/followed/list **/
    @Test
    @DisplayName("List seller followed: Should return the list with sellers followed by user")
    public void getFollowedByUserIdTest() throws Exception {
        //Arrange
        BuyerDTO expectedResponse = UtilsIntegrationTests.getBuyerDTOTestUS0004();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",4);

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
    @DisplayName("List seller followed - Invalid order param: Should inform error message")
    public void getFollowedByUserIdTestInvalidOrderParam() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = new SimpleMessageDTO("El criterio de ordenamiento no existe.");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=test",4);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 400
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("List seller followed - User not found: Should inform error message")
    public void getFollowedByUserIdTestUserNotFound() throws Exception {
        //Arrange
        SimpleMessageDTO expectedMessage = UtilsIntegrationTests.generateUserNotFoundMessage(99);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",99);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedMessage));

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 404
                .andExpect(contentType) // Verify is content type is Application Json
                .andExpect(contentExpected) // Verify is the response has correct message
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("List seller followed - User without followed sellers: Expects no content")
    public void getFollowedByUserIdTestUserWithoutFollowedSellers() throws Exception {
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",1);

        //Expects
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNoContent();

        mockMvc.perform(request)
                .andExpect(statusExpected) // Verify status code 204
                .andExpect(jsonPath("$").doesNotExist()) // Verify body not exists
                .andDo(MockMvcResultHandlers.print()); // Show the request
    }

    @Test
    @DisplayName("List seller followed: Should return the list with sellers followed by user sorted by name ASC")
    public void getFollowedByUserIdTestSortedAsc() throws Exception {
        //Arrange
        BuyerDTO expectedResponse = UtilsIntegrationTests.getBuyerDTOTestUS0004("name_asc");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",4);

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
    @DisplayName("List seller followed: Should return the list with sellers followed by user sorted by name ASC")
    public void getFollowedByUserIdTestSortedDsc() throws Exception {
        //Arrange
        BuyerDTO expectedResponse = UtilsIntegrationTests.getBuyerDTOTestUS0004("name_dsc");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",4);

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
    @DisplayName("List seller followed - UserID is 0: Should inform error message")
    public void getFollowedByUserIdTestUserId0() throws Exception {
        //Arrange
        String expectedResponse = "{'description':'Se encontraron los siguientes errores en las validaciones:','messages':['El id del usuario debe ser mayor a cero']}";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",0);

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
}
