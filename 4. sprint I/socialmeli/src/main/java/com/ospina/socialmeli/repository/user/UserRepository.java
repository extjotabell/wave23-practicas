package com.ospina.socialmeli.repository.user;

import com.ospina.socialmeli.entity.Seller;
import com.ospina.socialmeli.entity.User;
import com.ospina.socialmeli.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> createAll(List<User> entities);

    Optional<Seller> findSellerInFollowings(User user, Long sellerId);
}