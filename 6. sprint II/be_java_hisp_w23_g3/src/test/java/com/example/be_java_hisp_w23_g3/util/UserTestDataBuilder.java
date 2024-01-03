package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.entity.user.Seller;
import com.example.be_java_hisp_w23_g3.entity.user.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserTestDataBuilder {
    private Long id;
    private String username;
    private Set<Seller> following;

    public UserTestDataBuilder userByDefault() {
        this.id = 1L;
        this.username = "username1";
        this.following = new HashSet<>();
        return this;
    }

    public UserTestDataBuilder userWithFollowings() {
        this.id = 1L;
        this.username = "username1";
        this.following = new HashSet<>(Arrays.asList(
                new SellerTestDataBuilder().sellerByDefault().withId(101L).build(),
                new SellerTestDataBuilder().sellerByDefault().withId(102L).build(),
                new SellerTestDataBuilder().sellerByDefault().withId(103L).build()
        ));
        return this;
    }

    public UserTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserTestDataBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserTestDataBuilder withFollowing(Set<Seller> following) {
        this.following = following;
        return this;
    }

    public User build() {
        return User.build(id, username, following);
    }
}
