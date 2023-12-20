package com.mercadolibre.be_java_hisp_w23_g2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Repository class for handling user-related operations.
 */
@Repository
public class UserRepository implements IUserRepository {
    private final List<User> users;

    public UserRepository() throws IOException {
        users = loadData();
    }

    /**
     * Finds a user by their ID.
     *
     * @param id The ID of the user to find.
     * @return The User object with the specified ID, or null if not found.
     */
    @Override
    public User findUserById(int id) {
        return users
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves a list of all users. (Test)
     *
     * @return List of all users.
     */
    @Override
    public List<User> getAll() {
        return users;
    }

    /**
     * Adds a post to a user's list of posts.
     *
     * @param user The user to add the post to.
     * @param post The post to be added.
     */
    @Override
    public void addPost(User user, Post post) {
        user.getPosts().add(post);
    }

    /**
     * Follows a user by adding them to the followed list.
     *
     * @param userId        The ID of the user initiating the follow.
     * @param userIdToFollow The ID of the user to be followed.
     * @return The updated User object after the follow operation.
     */
    @Override
    public User followUser(int userId, int userIdToFollow) {
        User user = findUserById(userId);
        User user1 = findUserById(userIdToFollow);

        user.getFollowed().add(user1);
        user1.getFollowers().add(user);
        return user;
    }

    /**
     * Unfollows a user by removing them from the followed list.
     *
     * @param currentUser   The user initiating the unfollow.
     * @param userToUnfollow The user to be unfollowed.
     */
    @Override
    public void unfollowUser(User currentUser, User userToUnfollow) {
        currentUser.getFollowed().remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(currentUser);

    }

    @Override
    public int countPromoProduct(int id) {
        return findUserById(id).getPosts().stream().filter(post -> post.isHas_promo()).toList().size();
    }

    @Override
    public List<Post> filterPriceProduct(double min, double max) {
        List<User> users = getAll();
        List<Post> posts = new ArrayList<>();
        List<Post> aux;

        for (int i=0;i<users.size();i++){
            aux = users.get(i).getPosts();
            for (Post post: aux
                 ) {
                posts.add(post);
            }
        }

        return posts.stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max).sorted(Comparator.comparingDouble(Post::getPrice))
                .collect(Collectors.toList());
    }

    /**
     * Loads user data from a JSON file.
     *
     * @return List of User objects loaded from the JSON file.
     * @throws IOException If an I/O error occurs while reading the JSON file.
     */
    public List<User> loadData() throws IOException {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
            //JSON data is being mapped so that repeated users are nor created
            for (User user : users) {
                for (int j = 0; j < user.getFollowers().size(); j++) {
                    List<User> finalUsers = List.copyOf(users);
                    user.setFollowers(user.getFollowers().stream().map(u -> finalUsers
                            .stream().filter(u1 -> u.getId() == u1.getId()).findFirst().orElse(null)).collect(Collectors.toList()));
                }
                for (int j = 0; j < user.getFollowed().size(); j++) {
                    List<User> finalUsers = List.copyOf(users);
                    user.setFollowed(user.getFollowed().stream().map(u -> finalUsers
                            .stream().filter(u1 -> u.getId() == u1.getId()).findFirst().orElse(null)).collect(Collectors.toList()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
