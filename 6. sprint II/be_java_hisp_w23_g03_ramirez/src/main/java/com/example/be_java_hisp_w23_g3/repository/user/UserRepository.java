package com.example.be_java_hisp_w23_g3.repository.user;

import com.example.be_java_hisp_w23_g3.entity.user.Seller;
import com.example.be_java_hisp_w23_g3.entity.user.User;
import com.example.be_java_hisp_w23_g3.repository.CRUDRepository;

import java.util.Optional;

public interface UserRepository extends CRUDRepository<User, Long> {
    Optional<Seller> findSellerInFollowings(User user, Long sellerId);
}