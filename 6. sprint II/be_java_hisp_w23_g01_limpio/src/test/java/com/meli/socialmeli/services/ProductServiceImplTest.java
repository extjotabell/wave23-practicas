package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.PostNoPromoDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.repositories.IUserRepository;
import com.meli.socialmeli.services.impl.ProductServiceImpl;
import com.meli.socialmeli.services.impl.UserServiceImpl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static com.meli.socialmeli.utilities.Mappers.mapPostUserAndProductPromoNoPromoDTO;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import static util.UserEntityUtilsGenerator.getNewPostAdd;
import static util.UserEntityUtilsGenerator.getUserFollwingSellersOrderingAscTest;
import static util.UserEntityUtilsGenerator.getUserFollwingSellersOrderingDescTest;
import static util.UserEntityUtilsGenerator.getUserFollwingSellersOrderingTest;
import static util.UserEntityUtilsGenerator.getUserFollwingSellersTest;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    UserServiceImpl userService;
    @Mock
    IUserRepository userRepository;

    @InjectMocks
    ProductServiceImpl productService;

    private static MockedStatic<LocalDate> localDateNowMock;

    @BeforeAll
    public static void init() {
        localDateNowMock = mockStatic(
                LocalDate.class,
                Mockito.CALLS_REAL_METHODS
        );
        LocalDate time = LocalDate.of(2023, 12, 28);
        localDateNowMock.when(LocalDate::now).thenReturn(time);
    }

    @AfterAll
    public static void close() {
        localDateNowMock.close();
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009): " +
            "El tipo de ordenamiento 'date_asc' existe entonces retorna un PostsFromFollowsDTO sin lanzar excepción.")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoValidoDateAscTest(){
        // Arrange
        String order = "date_asc";
        User user = getUserFollwingSellersTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        // Assert
        assertDoesNotThrow(() -> productService.getAllPostsFollowsLastTwoWeeks(id, order));
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009): " +
            "El tipo de ordenamiento existe 'date_desc' entonces retorna un PostsFromFollowsDTO sin lanzar excepción.")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoValidoDateDescTest(){
        // Arrange
        String order = "date_desc";
        User user = getUserFollwingSellersTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        // Assert
        assertDoesNotThrow(() -> productService.getAllPostsFollowsLastTwoWeeks(id, order));
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009): " +
            "El tipo de ordenamiento no existe entonces lanza BadRequestException.")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoInvalidoTest(){
        // Arrange
        String order = "de_mayor_a_menor";
        User user = new User(1,"User", null, null, null);
        Integer id = user.getUser_id();
        // Act - Assert
        assertThrows(
                BadRequestException.class,
                () -> productService.getAllPostsFollowsLastTwoWeeks(id, order)
                );
    }

    @Test
    @DisplayName("T-0006: Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009): " +
            "En este caso el ordenamiento es ascendente")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoAscTest() {
        // Arrange
        String order = "date_asc";
        User user = getUserFollwingSellersOrderingTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        PostsFromFollowsDTO expected = getUserFollwingSellersOrderingAscTest();
        PostsFromFollowsDTO actual = productService.getAllPostsFollowsLastTwoWeeks(id,order);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0006: Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009): " +
            "En este caso el ordenamiento es descendente")
    void getAllPostsFollowsLastTwoWeeksOrdenamientoDescTest() {
        // Arrange
        String order = "date_desc";
        User user = getUserFollwingSellersOrderingTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        PostsFromFollowsDTO expected = getUserFollwingSellersOrderingDescTest();
        PostsFromFollowsDTO actual = productService.getAllPostsFollowsLastTwoWeeks(id,order);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0008: Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un " +
            "determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)")
    void getAllPostsFollowsLastTwoWeeksAssertLastTwoWeeksTest() {
        // Arrange
        /*
            Se utiliza este método porque en realidad nos sirve para este caso de uso también,
            no veo necesidad de cambiar el nombre.
         */
        User user = getUserFollwingSellersOrderingTest();
        List<User> sellers = user.getFollowed();
        Integer id = user.getUser_id();
        // Act
        when(userService.findFollowsByIdProductService(Mockito.anyInt())).thenReturn(sellers);
        // No importa que se retorne de manera descendente, lo importante es revisar que existan
        List<PostNoPromoDTO> expected = getUserFollwingSellersOrderingDescTest().getPosts();
        PostNoPromoDTO notExpected =  mapPostUserAndProductPromoNoPromoDTO(
                sellers.get(1).getPosts().get(1),
                sellers.get(1)
        );
        List<PostNoPromoDTO> actual = productService.getAllPostsFollowsLastTwoWeeks(id,null).getPosts();
        // Assert
        Assertions.assertTrue(actual.containsAll(expected));
        Assertions.assertFalse(actual.contains(notExpected));
    }

    @Test
    @DisplayName("T-0009: Verificar la corecta creación del producto. (US-0005)")

    void newPostTest (){

        //Arrange
        String fechaString = "2022-01-22"; // Formato: "yyyy-MM-dd"
        LocalDate fecha = LocalDate.parse(fechaString);
        Integer userId = 3;
        User user = getNewPostAdd();
        ProductDTO newProduct = new ProductDTO(1, "Silla", "Mueble", "MSI", "Rojo", "Nuevo" );
        PostDTO post = new PostDTO(userId, fecha, newProduct, 1, 2000.0);
        MessageDTO devolucion = new MessageDTO("El usuario "+ user.getUser_id() + " ha creado una nueva publicación.");

        //Act
        when(userRepository.finById(userId)).thenReturn(user);
        var obtenido = productService.newPost(post);

        //Assert
        Assertions.assertEquals(devolucion, obtenido);
    }
}
