package com.example.be_java_hisp_w23_g3.repository.user;

import com.example.be_java_hisp_w23_g3.dto.response.PromoDTO;
import com.example.be_java_hisp_w23_g3.entity.Post;
import com.example.be_java_hisp_w23_g3.entity.PostPromo;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import com.example.be_java_hisp_w23_g3.util.ProductMapper;
import com.example.be_java_hisp_w23_g3.util.SellerMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public Optional<User> read(Long userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

    @Override
    public User create(User entity) {
        users.add(entity);
        return entity;
    }

    @Override
    public List<User> createAll(List<User> entities) {
        users.addAll(entities);
        return entities;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }

    @Override
    public Optional<Seller> findSellerInFollowings(User user, Long sellerId) {
        return user.getFollowing().stream()
                .filter(u -> u.getId().equals(sellerId))
                .findFirst();
    }

    @Override
    public List<PromoDTO> getMyPromos(Set<Seller> sellers){
        List<Post> listPromos = new ArrayList<>();
        for (Seller seller: sellers) {
            listPromos.addAll(seller.getPosts().values());
        }
        List<PromoDTO> listPromoDTO = listPromos.stream()
               .filter(post -> post instanceof PostPromo)
               .map(post -> new PromoDTO(ProductMapper.toProductDTO(post.getProduct()),
                       post.getSeller().getUsername()))
               .toList();

        return listPromoDTO;

    }

}
