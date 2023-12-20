package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.*;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.dto.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;

import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;

import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w23_g2.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Mapper;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Validator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

/**
 * Service class for handling user-related operations.
 */
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final Mapper mapper;
    private final Validator validator;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = Mapper.getInstance();
        this.validator = Validator.getInstance();
    }

    /**
     * Retrieves the count of followers for a specified user.
     *
     * @param userId The ID of the user.
     * @return UserFollowersCountDTO containing the count of followers.
     */
    @Override
    public UserFollowersCountDTO getFollowersCountSeller(int userId) {
        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Current");

        return mapper.mapUserFollowersCountDTO(user);
    }

    /**
     * Retrieves a list of all users.
     *
     * @return List of UserDTOs representing all users.
     */
    public List<UserDTO> getAll() {
        List<User> users = userRepository.getAll();

        return users.stream().map(mapper::mapUserDTO).toList();
    }

    /**
     * Retrieves the followers of a specified user.
     *
     * @param userId   The ID of the user.
     * @param sortType The sorting type for the followers list.
     * @return UserFollowersDTO containing the list of followers.
     */
    @Override
    public UserFollowersDTO getFollowersUser(int userId, String sortType) {
        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Current");

        if (user.getFollowers() == null || user.getFollowers().isEmpty()) {
            throw new NotFoundException("User with id = " + userId + " has no followers");
        }
        if(sortType != null){
            user.setFollowers(userSortHandler(new ArrayList<>(user.getFollowers()), sortType));
        }
        return mapper.mapUserFollowersDTO(user);
    }

    /**
     * Retrieves the users followed by a specified user.
     *
     * @param userId   The ID of the user.
     * @param sortType The sorting type for the followed users list.
     * @return UserFollowedDTO containing the list of followed users.
     */
    @Override
    public UserFollowedDTO getFollowedUser(int userId, String sortType) {
        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Current");

        validator.checkIfUserHasFollowed(user);

        if(sortType != null){
            user.setFollowed(userSortHandler(new ArrayList<>(user.getFollowed()), sortType));
        }

        return mapper.mapUserFollowedDTO(user);
    }

    /**
     * Unfollows a user.
     *
     * @param userId           The ID of the user initiating the unfollow.
     * @param userIdToUnfollow The ID of the user to be unfollowed.
     * @return MessageDTO indicating the success of the unfollow operation.
     */
    @Override
    public MessageDTO unfollowUser(int userId, int userIdToUnfollow) {
        validator.validateThatItIsNotTheSameUser(userId, userIdToUnfollow);

        User currentUser = userRepository.findUserById(userId);
        validator.validateUserExistence(currentUser, userId, "Current");

        User userToUnfollow = userRepository.findUserById(userIdToUnfollow);
        validator.validateUserExistence(userToUnfollow, userIdToUnfollow, "To unfollow");

        validator.validateFollowing(currentUser, userIdToUnfollow);

        userRepository.unfollowUser(currentUser, userToUnfollow);

        return new MessageDTO("Has stopped following " + userToUnfollow.getUserName());
    }

    /**
     * Follows a user.
     *
     * @param userId         The ID of the user initiating the follow.
     * @param userIdToFollow The ID of the user to be followed.
     * @return UserFollowedDTO containing the updated list of followed users.
     */
    @Override
    public UserFollowedDTO followUser(int userId, int userIdToFollow) {
        validator.validateThatItIsNotTheSameUser(userId, userIdToFollow);

        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Current");

        User user2 = userRepository.findUserById(userIdToFollow);
        validator.validateUserExistence(user2, userIdToFollow, "To Follow");

        if (user.getFollowed().contains(userRepository.findUserById(userIdToFollow))) {
            throw new BadRequestException("The user " + userId + " allready follow " + userIdToFollow);
        }

        return mapper.mapUserFollowedDTO(userRepository.followUser(userId,userIdToFollow));
    }

    /**
     * Retrieves posts from users followed by a specified user.
     *
     * @param userId   The ID of the user.
     * @param sortType The sorting type for the posts list.
     * @return PostFollowedDTO containing the list of posts from followed users.
     */
    @Override
    public PostFollowedDTO getPostsByFollowedUsers(int userId, String sortType) {
        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Current");

        validator.checkIfUserHasFollowed(user);

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        List<Post> allPost = new ArrayList<>();

        for (User followedUser : user.getFollowed()) {
            User userf = userRepository.findUserById(followedUser.getId());
            validator.validateUserExistence(userf, followedUser.getId(), "Followed");

            if (userf.getPosts() == null || userf.getPosts().isEmpty()) {
                throw new NotFoundException("User followed with id = " + followedUser.getId() + " has no post");
            }
            for (Post postF : userf.getPosts()) {
                if (postF.getDate().isAfter(twoWeeksAgo)) {
                    allPost.add(postF);
                }
            }
        }
        if(sortType != null){
            postSortHandler(allPost, sortType);
        }

        return mapper.mapPostFollowedDTO(user.getId(), allPost);
    }

    /**
     * Retrieves followed users who do not follow me back to the user with sent id.
     *
     * @param userId The ID of the user.
     * @return UsersNotFollowedDTO containing the list of users who do not follow me back to the user with sent id.
     */
    @Override
    public UsersNotFollowedDTO followedNotFollowers(int userId) {
        User user = userRepository.findUserById(userId);
        validator.validateUserExistence(user, userId, "Current");
        boolean followMe = false;
        List<User> followedNotFollowers = new ArrayList<>();

        for (User followed : user.getFollowed()) {
            for (User followed2 : followed.getFollowed()) {
                if (user.getId() == followed2.getId()) {
                    followMe = true;
                }
            }
            if (!followMe) {
                followedNotFollowers.add(followed);
            }
            followMe = false;
        }

        return new UsersNotFollowedDTO(userId, user.getUserName(), followedNotFollowers.stream().map(mapper::mapUserDTO).toList());
    }

    /**
     * Handles sorting of posts based on the specified sort type.
     *
     * @param posts    The list of posts to be sorted.
     * @param sortType The sorting type for the posts list.
     */
    private void postSortHandler(List<Post> posts, String sortType){
        String[] attributes = sortType.split("_");
        if(attributes.length < 2){
            return;
        }
        if("date".equals(attributes[0])){
            if("asc".equals(attributes[1])){
                posts.sort(Comparator.comparing(Post::getDate));
            }else{
                posts.sort(Comparator.comparing(Post::getDate).reversed());
            }
        }
    }

    /**
     * Handles sorting of users based on the specified sort type.
     *
     * @param user     The list of users to be sorted.
     * @param sortType The sorting type for the users list.
     * @return The sorted list of users.
     */
    private List<User> userSortHandler(List<User> user, String sortType){
        String[] attributes = sortType.split("_");
        if(attributes.length < 2){
            return user;
        }
        if("name".equals(attributes[0])){
            if("asc".equals(attributes[1])){
                user.sort(Comparator.comparing(User::getUserName));
            }else{
                user.sort(Comparator.comparing(User::getUserName).reversed());
            }
        }
        return user;
    }

}
