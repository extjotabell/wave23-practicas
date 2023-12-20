package com.meli.socialmeli.services.impl;

import com.meli.socialmeli.dtos.response.*;

import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.repositories.IUserRepository;
import com.meli.socialmeli.exceptions.custom.NotFoundException;
import com.meli.socialmeli.services.IUserService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserFollowersDTO findFollowersById(int userId, String order) {
        Optional<User> userFound = Optional.ofNullable(userRepository.finById(userId));
        if (userFound.isEmpty()) throw new NotFoundException("There is no user with the id: " + userId);

        List<UserInfoDTO> followers = userFound.get().getFollowers()
                                                     .stream()
                                                     .sorted(order.equals("name_asc")
                                                        ? Comparator.comparing(User::getUser_name)
                                                        : Comparator.comparing(User::getUser_name).reversed())
                                                    .map(f -> new UserInfoDTO(f.getUser_id(), f.getUser_name()))
                                                    .toList();
        return new UserFollowersDTO(userFound.get().getUser_id(), userFound.get().getUser_name(), followers);
    }

    @Override
    public List<User> findFollowsByIdProductService(int id) {
        Optional<User> user = Optional.ofNullable(userRepository.finById(id));
        if (user.isEmpty()) throw new NotFoundException("There is no user with the id: " + id);

        return userRepository.getUserFollowed(user.get());
    }
    @Override
    public List<UserResponseDTO> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDTO> userResponseDtoList = new ArrayList<>();
        userList.forEach(u ->  {
            UserResponseDTO userResponseDto = new UserResponseDTO();

            userResponseDto.setUser_id(u.getUser_id());
            userResponseDto.setUser_name(u.getUser_name());

            List<String> followers = u.getFollowers().stream()
                    .map(User::getUser_name)
                    .toList();
            userResponseDto.setFollowers(followers);

            List<String> followed = u.getFollowed().stream()
                    .map(User::getUser_name)
                    .toList();
            userResponseDto.setFollowed(followed);

            userResponseDtoList.add(userResponseDto);
        });
        return userResponseDtoList;
    }

    @Override
    public MessageDTO followSeller(int userId, int userIdToFollow) {
        User followerUser = userRepository.findAll()
                .stream()
                .filter(u -> userId == u.getUser_id())
                .findFirst()
                .orElse(null);
        if(followerUser == null){
            throw new BadRequestException("User not found");
        }

        User followedUser = userRepository.findAll()
                .stream()
                .filter(u -> userIdToFollow == u.getUser_id())
                .findFirst()
                .orElse(null);
        if(followedUser == null){
            throw new BadRequestException("User not found");
        }

        if(followedUser.getFollowers().contains(followerUser)){
            throw new BadRequestException("User already followed");
        }

        if(followedUser.getPosts().isEmpty() || userId == userIdToFollow){
            throw new BadRequestException("Invalid User to follow");
        }

        followerUser.addFollowed(followedUser);
        followedUser.addFollower(followerUser);

        return new MessageDTO("Followed added");

    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) {
        User user = userRepository.finById(userId);
        if(user == null){
            throw new NotFoundException("Invalid user");
        }
        FollowersCountDTO followersCountDto = new FollowersCountDTO();
        followersCountDto.setUser_id(user.getUser_id());
        followersCountDto.setUser_name(user.getUser_name());
        followersCountDto.setFollowers_count(user.getFollowers().size());
        return followersCountDto;
    }

    @Override
    public UserFollowedDTO findFollowedById(int userId, String order) {
        Optional<User> userFound = Optional.ofNullable(userRepository.finById(userId));
        if (userFound.isEmpty()) throw new NotFoundException("There is no user with the id: " + userId);

        List<UserInfoDTO> followed = userFound.get().getFollowed()
                                                    .stream()
                                                    .sorted(order.equals("name_asc")
                                                            ? Comparator.comparing(User::getUser_name)
                                                            : Comparator.comparing(User::getUser_name).reversed())
                                                    .map(f -> new UserInfoDTO(f.getUser_id(), f.getUser_name()))
                                                    .toList();
        return new UserFollowedDTO(userFound.get().getUser_id(), userFound.get().getUser_name(), followed);
    }

    @Override
    public UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow) {
        User user = this.userRepository.finById(userId);
        User userToUnfollow = this.userRepository.finById(userIdToUnfollow);

        if (user == null || userToUnfollow == null) {
            throw new NotFoundException("User not found");
        }

        boolean removedFromFollowed = user.getFollowed().remove(userToUnfollow);
        boolean removedFromFollowers = userToUnfollow.getFollowers().remove(user);

        if (!removedFromFollowed || !removedFromFollowers) {
            throw new NotFoundException("Followed user not found");
        }

        return new UserUnfollowDTO(userId, userIdToUnfollow);
    }

    @Override
    public UserSellersSuggestedDTO getSuggestionsToFollow(int userId) {
        Optional<User> userFound = Optional.ofNullable(userRepository.finById(userId));
        if (userFound.isEmpty()) throw new NotFoundException("There is no user with the id: " + userId);

        List<User> followedSellers = userFound.get().getFollowed();

        List<Integer> categories = followedSellers.stream()
                                                  .flatMap(seller -> seller.getPosts().stream())
                                                  .map(Post::getCategory)
                                                  .toList();


        List<UserInfoDTO> suggestions= userRepository.findAll()
                                                     .stream()
                                                     .filter(u -> !u.getPosts().isEmpty()
                                                                && !followedSellers.contains(u))
                                                     .filter(u -> u.getPosts().stream()
                                                                            .anyMatch(p -> categories.contains(p.getCategory())))
                                                     .map(u -> new UserInfoDTO(u.getUser_id(), u.getUser_name()))
                                                     .toList();

        return new UserSellersSuggestedDTO(userFound.get().getUser_id(), userFound.get().getUser_name(), suggestions);
    }
}