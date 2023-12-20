package com.example.be_java_hisp_w23_g3.service.user;

import com.example.be_java_hisp_w23_g3.dto.response.user.FollowersCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.user.FollowersListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.user.FollowingListDTO;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import com.example.be_java_hisp_w23_g3.exception.AlreadyFollowingException;
import com.example.be_java_hisp_w23_g3.exception.NotFollowingException;
import com.example.be_java_hisp_w23_g3.exception.NotFoundException;
import com.example.be_java_hisp_w23_g3.repository.user.SellerRepository;
import com.example.be_java_hisp_w23_g3.repository.user.SellerRepositoryImpl;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepository;
import com.example.be_java_hisp_w23_g3.repository.user.UserRepositoryImpl;
import com.example.be_java_hisp_w23_g3.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository, SellerRepositoryImpl sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void setNewFollower(Long userId, Long userIdToFollow) {
        User user = userRepository.read(userId)
                .or(() -> sellerRepository.read(userId))
                .orElseThrow(() -> new NotFoundException("No se ha encontrado un usuario con el ID: " + userId));

        Seller userToFollow = sellerRepository.read(userIdToFollow).orElseThrow(
                () -> new NotFoundException("No se ha encontrado un vendedor con el ID: " + userIdToFollow));

        if (userToFollow.getFollowers().contains(user))
            throw new AlreadyFollowingException(
                    "El usuario con ID: " + userId + " ya sigue al vendedor con ID: " + userIdToFollow);

        userToFollow.getFollowers().add(user);
        user.getFollowing().add(userToFollow);
    }

    @Override
    public void unfollow(Long userId, Long userIdToUnfollow) {
        User user = userRepository.read(userId)
                .or(() -> sellerRepository.read(userId))
                .orElseThrow(() -> new NotFoundException("No se ha encontrado un usuario con el ID: " + userId));

        Seller userToFollow = sellerRepository.read(userIdToUnfollow).orElseThrow(
                () -> new NotFoundException("No se ha encontrado un vendedor con el ID: " + userIdToUnfollow));

        if (!userToFollow.getFollowers().contains(user))
            throw new NotFollowingException(
                    "El usuario con ID: " + userId + " no sigue al vendedor con ID: " + userIdToUnfollow);

        userToFollow.getFollowers().remove(user);
        user.getFollowing().remove(userToFollow);
    }

    @Override
    public FollowersCountDTO getFollowersCount(Long userId) {
        return sellerRepository.read(userId)
                .map(DTOMapper::mapToFollowersCountDTO)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado un vendedor con el ID: " + userId));
    }

    @Override
    public FollowersListDTO getFollowers(Long userId, String order) {
        return sellerRepository.read(userId)
                .map(seller -> DTOMapper.mapToFollowersListDTO(seller, order))
                .orElseThrow(() -> new NotFoundException("No se ha encontrado un vendedor con el ID: " + userId));
    }

    @Override
    public FollowingListDTO getFollowing(Long userId, String order) {
        return userRepository.read(userId)
                .map(user -> DTOMapper.mapToFollowingListDTO(user, order))
                .or(() -> sellerRepository.read(userId).map(user -> DTOMapper.mapToFollowingListDTO(user, order)))
                .orElseThrow(() -> new NotFoundException("No se ha encontrado un vendedor con el ID: " + userId));
    }


}
