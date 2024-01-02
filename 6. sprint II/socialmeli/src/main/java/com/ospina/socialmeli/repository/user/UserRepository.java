package com.ospina.socialmeli.repository.user;

import com.ospina.socialmeli.entity.user.Seller;
import com.ospina.socialmeli.entity.user.User;
import com.ospina.socialmeli.repository.CRUDRepository;

import java.util.Optional;

public interface UserRepository extends CRUDRepository<User, Long> {
    Optional<Seller> findSellerInFollowings(User user, Long sellerId);
}