package com.example.be_java_hisp_w23_g3.repository;

import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import com.example.be_java_hisp_w23_g3.repository.product.ProductRepository;
import com.example.be_java_hisp_w23_g3.repository.seller.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
        userRepository.createAll(List.of(
            User.build(
                1L,
                "user1",
                new HashSet<>(Arrays.asList(
                    Seller.build(User.build(8L, "abcdef")),
                    Seller.build(User.build(9L, "bcdefg")),
                    Seller.build(User.build(10L, "cdefgh"))
                ))
            ),
            User.build(2L, "user2"),
            User.build(3L, "user3"),
            User.build(4L, "user4"),
            User.build(5L, "user5"),
            User.build(6L, "user6")
        ));

        sellerRepository.createAll(List.of(
            Seller.build(
                User.build(
                    7L,
                    "seller1"),
                    new HashSet<>(Arrays.asList(
                        User.build(13L, "abcdef"),
                        User.build(6L, "bcdefg"),
                        User.build(15L, "cdefgh")
                    )
                ),
                new HashMap<>()
            ),
            Seller.build(User.build(8L, "seller2")),
            Seller.build(User.build(9L, "seller3")),
            Seller.build(User.build(10L, "seller4")),
            Seller.build(User.build(11L, "seller5")),
            Seller.build(User.build(12L, "seller6"))
        ));
    }
}
