package com.ospina.socialmeli.util;

import com.ospina.socialmeli.entity.product.Post;
import com.ospina.socialmeli.entity.user.Seller;
import com.ospina.socialmeli.entity.user.User;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SellerTestDataBuilder {

    private Long id;
    private String username;
    private Set<Seller> following;
    private Set<User> follower;
    private Map<Long, Post> posts;

    public SellerTestDataBuilder sellerByDefault() {
        this.id = 1L;
        this.username = "sellerUsername1";
        this.following = Set.of();
        this.follower = new HashSet<>();
        this.posts = Map.of();
        return this;
    }

    public SellerTestDataBuilder sellerWithFollowings() {
        this.id = 1L;
        this.username = "sellerUsername1";
        this.following = Set.of(
                new SellerTestDataBuilder().sellerByDefault().withId(101L).build(),
                new SellerTestDataBuilder().sellerByDefault().withId(102L).build(),
                new SellerTestDataBuilder().sellerByDefault().withId(103L).build()
        );
        this.follower = Set.of();
        this.posts = Map.of();
        return this;
    }

    public SellerTestDataBuilder sellerWithFollowers() {
        this.id = 1L;
        this.username = "sellerUsername1";
        this.following = Set.of();
        this.follower = Set.of(
                new UserTestDataBuilder().userByDefault().withId(101L).build(),
                new UserTestDataBuilder().userByDefault().withId(102L).build(),
                new UserTestDataBuilder().userByDefault().withId(103L).build()
        );
        this.posts = Map.of();
        return this;
    }

    public SellerTestDataBuilder sellerWithPosts() {
        this.id = 1L;
        this.username = "sellerUsername1";
        this.following = Set.of();
        this.follower = Set.of();
        this.posts = Map.of(1L, new PostTestDataBuilder().postByDefault().withId(101L).build());
        return this;
    }

    public SellerTestDataBuilder sellerWithFollowingsAndFollowers() {
        this.id = 1L;
        this.username = "sellerUsername1";
        this.following = Set.of(new SellerTestDataBuilder().sellerByDefault().withId(102L).build());
        this.follower = Set.of(new UserTestDataBuilder().userByDefault().withId(101L).build());
        this.posts = Map.of();
        return this;
    }

    public SellerTestDataBuilder sellerWithFollowingsPostsAndFollowers() {
        this.id = 1L;
        this.username = "sellerUsername1";
        this.following = Set.of(new SellerTestDataBuilder().sellerByDefault().withId(102L).build());
        this.follower = Set.of(new UserTestDataBuilder().userByDefault().withId(101L).build());
        this.posts = Map.of(1L, new PostTestDataBuilder().postByDefault().withId(101L).build());
        return this;
    }

    public SellerTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public SellerTestDataBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public SellerTestDataBuilder withFollowing(Set<Seller> following) {
        this.following = following;
        return this;
    }

    public SellerTestDataBuilder withFollower(Set<User> follower) {
        this.follower = follower;
        return this;
    }

    public SellerTestDataBuilder withPosts(Map<Long, Post> posts) {
        this.posts = posts;
        return this;
    }

    public Seller build() {
        return Seller.build(User.build(id, username, following), follower, posts);
    }
}
