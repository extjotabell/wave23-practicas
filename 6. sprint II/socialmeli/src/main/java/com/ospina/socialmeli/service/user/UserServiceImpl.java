package com.ospina.socialmeli.service.user;

import com.ospina.socialmeli.dto.response.*;
import com.ospina.socialmeli.dto.response.MessageResponseDTO;
import com.ospina.socialmeli.entity.user.Seller;
import com.ospina.socialmeli.entity.user.User;
import com.ospina.socialmeli.exception.exceptions.*;
import com.ospina.socialmeli.exception.exceptions.*;
import com.ospina.socialmeli.repository.seller.SellerRepository;
import com.ospina.socialmeli.repository.user.UserRepository;
import com.ospina.socialmeli.util.mapper.DTOMapper;
import com.ospina.socialmeli.util.mapper.UserMapper;
import com.ospina.socialmeli.dto.response.FollowedListDTO;
import com.ospina.socialmeli.dto.response.FollowersCountDTO;
import com.ospina.socialmeli.dto.response.FollowersListDTO;
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
            throw new AlreadyFollowingException("This seller is already part of your followings");
        }
        sellerToFollow.getFollower().add(user);
        user.getFollowing().add(sellerToFollow);
        return new MessageResponseDTO("Following a new Seller!");
    }

    @Override
    public MessageResponseDTO unfollowSeller(Long userId, Long userIdToUnfollow) {
        if(userId.equals(userIdToUnfollow)){
            throw new UnfollowingMyselfException("You can't unfollow yourself");
        }

        User user = getUser(userId);
        Seller sellerToUnfollow = userRepository.findSellerInFollowings(user,userIdToUnfollow)
                .orElseThrow(() -> new NotFollowingException("Seller with id " + userIdToUnfollow + " is not part of your followings"));

        sellerToUnfollow.getFollower().remove(user);
        user.getFollowing().remove(sellerToUnfollow);
        return new MessageResponseDTO("You have just unfollowed a seller");
    }
}