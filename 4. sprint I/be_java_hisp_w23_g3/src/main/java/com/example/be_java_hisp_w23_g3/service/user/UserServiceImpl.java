package com.example.be_java_hisp_w23_g3.service.user;

import com.example.be_java_hisp_w23_g3.dto.response.*;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import com.example.be_java_hisp_w23_g3.exception.*;
import com.example.be_java_hisp_w23_g3.repository.seller.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import com.example.be_java_hisp_w23_g3.util.DTOMapper;
import com.example.be_java_hisp_w23_g3.util.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;

    public UserServiceImpl(UserRepository userRepository, SellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    private Seller getSeller(Long userId) {
        return sellerRepository.read(userId)
                .orElseThrow(() -> new NotFoundException("Seller with id " + userId + " not found"));
    }

    private User getUser(Long userId) {
        return userRepository.read(userId)
                .or(() -> sellerRepository.read(userId))
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));
    }

    @Override
    public FollowersCountDTO getFollowersCount(Long userId) {
        return DTOMapper.mapToFollowersCountDTO(getSeller(userId));
    }

    @Override
    public FollowersListDTO getFollowersList(Long userId, String order) {
        return UserMapper.mapToFollowersListDTO(getSeller(userId), order);
    }

    @Override
    public FollowedListDTO getFollowedSellersList(Long userID, String order) {
        return UserMapper.mapToFollowedListDTO(getUser(userID), order);
    }

    @Override
    public MessageResponseDTO followSeller(Long userId, Long userIdToFollow) {
        if(userId.equals(userIdToFollow)){
            throw new FollowingMyselfException("You can't follow yourself");
        }

        Seller sellerToFollow = getSeller(userIdToFollow);
        User user = getUser(userId);

        if(user.getFollowing().contains(sellerToFollow)){
            throw new AlreadyAFollowerException("This seller is already part of your followings");
        }
        sellerToFollow.getFollower().add(user);
        user.getFollowing().add(sellerToFollow);
        return new MessageResponseDTO("Following a new Seller!");
    }

    @Override
    public MessageResponseDTO unFollowSeller(Long userId, Long userIdToUnfollow) {
        if(userId.equals(userIdToUnfollow)){
            throw new UnFollowingMyselfException("You can't unfollow yourself");
        }

        User user = getUser(userId);
        Seller sellerToUnfollow = userRepository.findSellerInFollowings(user,userIdToUnfollow)
                .orElseThrow(() -> new NotAFollowerException("Seller with id " + userIdToUnfollow + " is not part of your followings"));

        sellerToUnfollow.getFollower().remove(user);
        user.getFollowing().remove(sellerToUnfollow);
        return new MessageResponseDTO("You have just unfollowed a seller");
    }
}