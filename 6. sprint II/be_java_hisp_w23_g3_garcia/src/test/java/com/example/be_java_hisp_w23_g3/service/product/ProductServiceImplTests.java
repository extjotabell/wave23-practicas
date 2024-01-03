package com.example.be_java_hisp_w23_g3.service.product;

import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowedPostsListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.product.Post;
import com.example.be_java_hisp_w23_g3.entity.user.User;
import com.example.be_java_hisp_w23_g3.exception.exceptions.AlreadyExistsException;
import com.example.be_java_hisp_w23_g3.exception.exceptions.NotFoundException;
import com.example.be_java_hisp_w23_g3.repository.product.ProductRepository;
import com.example.be_java_hisp_w23_g3.repository.seller.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import com.example.be_java_hisp_w23_g3.util.PostRequestDTOTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.PostTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.UserTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTests {

    @Mock
    ProductRepository productRepository;

    @Mock
    SellerRepository sellerRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    ProductServiceImpl service;

    @Test
    void followedPosts_ListReturnsCorrectDTOWhenUserFollowsSellers() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userWithFollowings().withId(userId).build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));
        List<Post> posts = Collections.singletonList(new PostTestDataBuilder().postByDefault().build());
        when(productRepository.readBatchBySellerIds(anyList())).thenReturn(posts);

        // Act
        FollowedPostsListDTO result = service.followedPostsList(userId, null);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertEquals(posts.size(), result.getPosts().size());
    }

    @Test
    void followedPosts_ListThrowsNotFoundExceptionWhenUserDoesNotExist() {
        // Arrange
        Long userId = 1L;
        when(userRepository.read(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> service.followedPostsList(userId, null));
    }

    @Test
    void followedPosts_ListReturnsEmptyDTOWhenUserFollowsNoSellers() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        // Act
        FollowedPostsListDTO result = service.followedPostsList(userId, null);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertTrue(result.getPosts().isEmpty());
    }

    @Test
    void followedPosts_ListReturnsCorrectlyOrderedDTOWhenOrderIsDateAsc() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userWithFollowings().withId(userId).build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        List<Post> posts = Arrays.asList(
                new PostTestDataBuilder().postByDefault().withId(1L).withDate(LocalDate.now().minusDays(2)).build(),
                new PostTestDataBuilder().postByDefault().withId(2L).withDate(LocalDate.now().minusDays(1)).build(),
                new PostTestDataBuilder().postByDefault().withId(3L).withDate(LocalDate.now()).build()
        );
        when(productRepository.readBatchBySellerIds(anyList())).thenReturn(posts);

        // Act
        FollowedPostsListDTO result = service.followedPostsList(userId, "date_asc");

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertEquals(posts.size(), result.getPosts().size());
        assertEquals(1L, result.getPosts().get(0).getPostId());
        assertEquals(2L, result.getPosts().get(1).getPostId());
        assertEquals(3L, result.getPosts().get(2).getPostId());
    }

    @Test
    void followedPosts_ListReturnsCorrectlyOrderedDTOWhenOrderIsDateDesc() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userWithFollowings().withId(userId).build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        List<Post> posts = Arrays.asList(
                new PostTestDataBuilder().postByDefault().withId(1L).withDate(LocalDate.now().minusDays(2)).build(),
                new PostTestDataBuilder().postByDefault().withId(2L).withDate(LocalDate.now().minusDays(1)).build(),
                new PostTestDataBuilder().postByDefault().withId(3L).withDate(LocalDate.now()).build()
        );
        when(productRepository.readBatchBySellerIds(anyList())).thenReturn(posts);

        // Act
        FollowedPostsListDTO result = service.followedPostsList(userId, "date_desc");

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertEquals(posts.size(), result.getPosts().size());
        assertEquals(3L, result.getPosts().get(0).getPostId());
        assertEquals(2L, result.getPosts().get(1).getPostId());
        assertEquals(1L, result.getPosts().get(2).getPostId());
    }

    @Test
    void followedPostsList_ReturnsPostsWithinLastTwoWeeks() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userWithFollowings().withId(userId).build();

        List<Post> posts = Arrays.asList(
                new PostTestDataBuilder().postByDefault().withId(1L).withDate(LocalDate.now().minusDays(7)).build(),
                new PostTestDataBuilder().postByDefault().withId(2L).withDate(LocalDate.now().minusDays(10)).build(),
                new PostTestDataBuilder().postByDefault().withId(3L).withDate(LocalDate.now().minusWeeks(2).minusDays(1)).build(),
                new PostTestDataBuilder().postByDefault().withId(4L).withDate(LocalDate.now().minusWeeks(3)).build()
        );

        when(productRepository.readBatchBySellerIds(anyList())).thenReturn(posts);
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        // Act
        FollowedPostsListDTO result = service.followedPostsList(userId, null);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertEquals(2, result.getPosts().size());
        assertTrue(result.getPosts().stream().anyMatch(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2))));
    }

    @Test
    void postProduct_shouldReturnCorrectDTOWhenProductIsPosted() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        Post post = new PostTestDataBuilder().postByDefault().build();
        when(productRepository.getNextId()).thenReturn(post.getId());
        when(productRepository.create(any(Post.class))).thenReturn(post);

        // Act
        PostRequestDTO request = new PostRequestDTOTestDataBuilder().postRequestDTOByDefault().build();
        PostResponseDTO result = service.postProduct(request);

        // Assert
        assertNotNull(result);
        assertEquals(post.getId(), result.getPostId());
        assertEquals(post.getDate(), result.getDate());
        assertEquals(post.getCategory(), result.getCategory());
        assertEquals(post.getPrice(), result.getPrice());
    }

    @Test
    void postProduct_shouldThrowNotFoundExceptionWhenUserDoesNotExist() {
        // Arrange
        Long userId = 1L;
        when(userRepository.read(userId)).thenReturn(Optional.empty());

        // Act & Assert
        PostRequestDTO request = new PostRequestDTOTestDataBuilder().postRequestDTOByDefault().build();
        assertThrows(NotFoundException.class, () -> service.postProduct(request));
    }

    @Test
    void postProduct_shouldThrowAlreadyExistsExceptionWhenProductIsAlreadyPosted() {
        // Arrange
        Long userId = 1L;
        User user = new UserTestDataBuilder().userByDefault().withId(userId).build();
        when(userRepository.read(userId)).thenReturn(Optional.of(user));

        PostRequestDTO request = new PostRequestDTOTestDataBuilder().postRequestDTOByDefault().build();
        when(productRepository.findAll()).thenReturn(Collections.singletonList(new PostTestDataBuilder().postByDefault().build()));

        // Act & Assert
        assertThrows(AlreadyExistsException.class, () -> service.postProduct(request));
    }
}
