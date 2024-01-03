package com.sprint.be_java_hisp_w23_g04.gateway;

import com.sprint.be_java_hisp_w23_g04.entity.User;
import com.sprint.be_java_hisp_w23_g04.repository.IUserMediaRepository;
import com.sprint.be_java_hisp_w23_g04.repository.UserMediaRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGatewayImpl implements IUserGateway {

    private final IUserMediaRepository userMediaRepository;

    public UserGatewayImpl(UserMediaRepositoryImpl userMediaRepository) {
        this.userMediaRepository = userMediaRepository;
    }

    /**
     * Retrieves a user based on their user ID.
     * <p>
     * This method is a straightforward lookup that delegates the task of finding a user to the userMediaRepository.
     * It takes a user ID as an input and returns the corresponding User object. The method provides a direct way
     * to access user details stored in the repository. If no user is found with the given ID, the behavior depends
     * on the implementation of the userMediaRepository's findUser method, which might return null or throw an exception.
     *
     * @param userId The ID of the user to be retrieved.
     * @return User The User object corresponding to the provided userId, or null if no user is found.
     */
    @Override
    public List<User> getAllUsers() {
        return userMediaRepository.getAllUsers();
    }

    @Override
    public User findUser(Integer userId) {
        return userMediaRepository.findUser(userId);
    }

    /**
     * Get users by list ids
     *
     * @param usersId list with users ids to get.
     * @return the list of User
     **/
    @Override
    public List<User> getByIds(List<Integer> usersId) {
        return userMediaRepository.getByIds(usersId);
    }

    @Override
    public void unfollowUser(int userId, int unfollowId){
        userMediaRepository.unfollowUser(userId, unfollowId);
    }
}