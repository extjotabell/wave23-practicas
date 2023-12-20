package com.example.be_java_hisp_w23_g3.repository;


import com.example.be_java_hisp_w23_g3.entity.Post;
import com.example.be_java_hisp_w23_g3.entity.Product;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import com.example.be_java_hisp_w23_g3.repository.product.ProductRepository;
import com.example.be_java_hisp_w23_g3.repository.seller.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class DataLoader {

    UserRepository userRepository;
    SellerRepository sellerRepository;
    ProductRepository productRepository;

    public DataLoader(UserRepository userRepository, SellerRepository sellerRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void load() {

        List<User> users = new ArrayList<>(List.of(
            User.build(1L, "Jhon Perez"),
            User.build(2L, "Carlos Martinez"),
            User.build(3L, "Maria Rodriguez"),
            User.build(4L, "Pedro Lopez"),
            User.build(5L, "Eduardo Gomez"),
            User.build(6L, "Natalia Sanchez"),
            User.build(7L, "Samuel Diaz"),
            User.build(8L, "Jorge Hernandez"),
            User.build(9L, "Oscar Ramirez"),
            User.build(10L, "Diego Gonzalez"),
            User.build(11L, "Juan Torres"),
            User.build(12L, "Andres Flores")
        ));

        List<Seller> sellers = new ArrayList<>(List.of(
            Seller.build(users.get(5)),
            Seller.build(users.get(6)),
            Seller.build(users.get(7)),
            Seller.build(users.get(8)),
            Seller.build(users.get(9)),
            Seller.build(users.get(10)),
            Seller.build(users.get(11))
        ));

        List<Product> products = new ArrayList<>(List.of(
            Product.build(1L, "Monitor", "Oficina", "Samsumg", "Black", "1080p"),
            Product.build(2L, "Silla Gamer", "Gamer", "Razer", "Black", "Special Edition"),
            Product.build(3L, "Mouse", "Personal", "Apple", "White", "Only for Mac"),
            Product.build(4L, "Teclado", "Gamer", "Logitech", "White", "With RGB"),
            Product.build(5L, "Audífonos", "Studio", "Beats", "Red", "Wireless")
        ));

        List<Post> posts = new ArrayList<>(List.of(
            Post.build(1L, sellers.get(0), products.get(0), LocalDate.now().minusDays(3), 1, 4812.24),
            Post.build(2L, sellers.get(0), products.get(1), LocalDate.now().minusDays(2), 2, 2345.6),
            Post.build(3L, sellers.get(1), products.get(2), LocalDate.now().minusDays(1), 3, 789.0),
            Post.build(4L, sellers.get(2), products.get(3), LocalDate.now().plusDays(1), 4, 1350.7),
            Post.build(5L, sellers.get(3), products.get(4), LocalDate.now().plusDays(2), 5, 221.198)
        ));

        // Assign posts to sellers
        sellers.get(0).getPosts().put(posts.get(0).getId(), posts.get(0));
        sellers.get(0).getPosts().put(posts.get(1).getId(), posts.get(1));
        sellers.get(1).getPosts().put(posts.get(2).getId(), posts.get(2));
        sellers.get(2).getPosts().put(posts.get(3).getId(), posts.get(3));
        sellers.get(3).getPosts().put(posts.get(4).getId(), posts.get(4));

        // Set followings
        users.get(0).setFollowing(new HashSet<>(List.of(
            sellers.get(0),
            sellers.get(1),
            sellers.get(2)
        )));

        users.get(1).setFollowing(new HashSet<>(List.of(
            sellers.get(0),
            sellers.get(2)
        )));

        users.get(2).setFollowing(new HashSet<>(List.of(
            sellers.get(1),
            sellers.get(2),
            sellers.get(3)
        )));

        users.get(4).setFollowing(new HashSet<>(List.of(
            sellers.get(3)
        )));

        sellers.get(3).setFollowing(new HashSet<>(List.of(
            sellers.get(1),
            sellers.get(2)
        )));

        // Set followers

        sellers.get(0).setFollower(new HashSet<>(List.of(
            users.get(0),
            users.get(1)
        )));

        sellers.get(1).setFollower(new HashSet<>(List.of(
            users.get(0),
            users.get(2),
            sellers.get(3)
        )));

        sellers.get(2).setFollower(new HashSet<>(List.of(
            users.get(0),
            users.get(1),
            users.get(2),
            sellers.get(3)
        )));

        sellers.get(3).setFollower(new HashSet<>(List.of(
            users.get(2),
            users.get(4)
        )));

        // Add everything to repositories
        userRepository.createAll(users);
        sellerRepository.createAll(sellers);
        productRepository.createAll(posts);
    }
}
