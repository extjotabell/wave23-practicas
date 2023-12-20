package com.example.be_java_hisp_w23_g3.repository.user;

import com.example.be_java_hisp_w23_g3.dto.response.PromoDTO;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import com.example.be_java_hisp_w23_g3.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<Seller> findSellerInFollowings(User user, Long sellerId);
    List<PromoDTO> getMyPromos(Set<Seller> sellers);

}