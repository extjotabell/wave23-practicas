package com.ospina.socialmeli.util;

import com.ospina.socialmeli.entity.product.Post;
import com.ospina.socialmeli.entity.product.Product;
import com.ospina.socialmeli.entity.user.Seller;

import java.time.LocalDate;

public class PostTestDataBuilder {

    private Long id;
    private Seller seller;
    private Product product;
    private LocalDate date;
    private int category;
    private Double price;

    public PostTestDataBuilder postByDefault() {
        this.id = 1L;
        this.seller = new SellerTestDataBuilder().sellerByDefault().withId(103L).build();
        this.product = new ProductTestDataBuilder().productByDefault().build();
        this.date = LocalDate.now();
        this.category = 1;
        this.price = 100.0;
        return this;
    }

    public PostTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PostTestDataBuilder withSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    public PostTestDataBuilder withProduct(Product product) {
        this.product = product;
        return this;
    }

    public PostTestDataBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public PostTestDataBuilder withCategory(int category) {
        this.category = category;
        return this;
    }

    public PostTestDataBuilder withPrice(Double price) {
        this.price = price;
        return this;
    }

    public Post build() {
        return Post.build(id, seller, product, date, category, price);
    }


}
