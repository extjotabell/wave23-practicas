package com.sprint.be_java_hisp_w23_g04.service;

import com.sprint.be_java_hisp_w23_g04.dto.response.*;
import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SellerDTO;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import com.sprint.be_java_hisp_w23_g04.exception.BadRequestException;
import com.sprint.be_java_hisp_w23_g04.exception.NoContentException;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;
import com.sprint.be_java_hisp_w23_g04.gateway.IUserGateway;
import com.sprint.be_java_hisp_w23_g04.gateway.UserGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.utils.Verifications;
import com.sprint.be_java_hisp_w23_g04.utils.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import static com.sprint.be_java_hisp_w23_g04.utils.Verifications.*;

@Service
public class UserMediaServiceImpl implements IUserMediaService {

    private IUserGateway userGateway;

    public UserMediaServiceImpl(UserGatewayImpl userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO> getAllUsers() {
        List<User> users = userGateway.getAllUsers();
        return users.stream().map(UserMapper::mapUser).toList();
    }

    @Override
    public SimpleMessageDTO followSellerUser(Integer userId, Integer userIdToFollow) {
        User user = userGateway.findUser(userId);
        User seller = userGateway.findUser(userIdToFollow);
        Verifications.verifyUserExist(user, userId);
        Verifications.verifyUserExist(seller, userIdToFollow);
        Verifications.verifyDistinctsUser(user, seller);
        Verifications.verifyUserIsSeller(seller);
        Verifications.verifyUserAlreadyFollowsSeller(user, seller);

        seller.getFollowersId().add(userId);
        user.getFollowedId().add(userIdToFollow);
        return new SimpleMessageDTO("El usuario con id:" + userId + " ahora sigue a vendedor con id:" + userIdToFollow);
    }

    /**
     * Retrieves the count of followers for a specified user and encapsulates the result in a SellerDTO.
     *
     * @param userId The ID of the user whose follower count is to be retrieved.
     * @return SellerDTO containing the user's ID, name, and number of followers.
     * @throws NotFoundException If the user with the given userId does not exist.
     */
    @Override
    public SellerDTO followersCount(Integer userId) {
        User user = userGateway.findUser(userId);

        Verifications.verifyUserExist(user, userId);

        return new SellerDTO(user.getId(), user.getName(), user.getFollowersId().size());
    }

    /**
     * Retrieves and sorts a user's followed sellers based on the specified order.
     *
     * @param userId ID of the user to retrieve followed sellers for.
     * @param order  Sorting order for the list, defaulting to 'name_asc'.
     * @return BuyerDTO with user details and sorted list of followed UserDTOs, or 204 No Content if none are followed.
     * @throws NotFoundException  If the user with the given userId doesn't exist.
     * @throws NoContentException If the user exists but follows no sellers.
     */

    @Override
    public BuyerDTO getFollowedByUserId(Integer userId, String order) {
        Verifications.verifyOrderCriteriaExists(order);
        User user = this.userGateway.findUser(userId);

        Verifications.verifyUserExist(user, userId);

        List<User> userFollowers = userGateway.getByIds(user.getFollowedId());

        Verifications.validateEmptyResponseList(userFollowers);

        List<com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO> followed = sortedFollow(userFollowers, order);

        return new BuyerDTO(user.getId(), user.getName(), followed);
    }


    /**
     * Retrieves and sorts a user's followed sellers based on the specified order.
     *
     * @param userId The ID of the user whose followers are to be retried.
     * @param order  The shorting criteria for the returned list.
     * @return BuyerDTO with user details and sorted list of followed UserDTOs
     * @throws NotFoundException  If the user with the given userId doesn't exist.
     * @throws NoContentException If the user exists but follows no sellers.
     */
    @Override
    public BuyerDTO getFollowersByUserId(Integer userId, String order) {
        Verifications.verifyOrderCriteriaExists(order);

        User user = this.userGateway.findUser(userId);

        Verifications.verifyUserExist(user, userId);

        List<User> userFollowers = userGateway.getByIds(user.getFollowersId());

        Verifications.validateEmptyResponseList(userFollowers);

        List<UserDTO> followed = sortedFollow(userFollowers, order);

        return new BuyerDTO(user.getId(), user.getName(), followed);
    }

    private List<UserDTO> sortedFollow(List<User> follows, String order) {
        if (order.equals("name_dsc")) {
            return follows.stream()
                    .map(UserMapper::mapUser)
                    .sorted(Comparator.
                            comparing(UserDTO::getName)
                            .reversed())
                    .toList();
        } else {
            return follows.stream()
                    .map(UserMapper::mapUser)
                    .sorted(Comparator.comparing(UserDTO::getName))
                    .toList();
        }

    }

    /**
     * Performs the action of unfollowing a seller from a buyer
     *
     * @param userId The ID of the user who is unfollowing (a buyer).
     * @param unfollowId  The ID of the user who is being unfollowed (a seller).
     * @return SimpleMessageDTO with a message confirming the action was performed
     * @throws NotFoundException  If any of the users with the given userIds don't exist.
     * @throws BadRequestException If the user exists but doesn't follow the specific seller on which the action is being performed.
     */
    @Override
    public SimpleMessageDTO unfollowUser(int userId, int unfollowId) {
        User user = userGateway.findUser(userId);
        User unfollowedUser = userGateway.findUser(unfollowId);

        verifyUserExist(user, userId);
        verifyUserExist(unfollowedUser, unfollowId);
        verifySellerIsFollowedByUser(user, unfollowedUser);
        verifyUserFollowsSeller(user, unfollowedUser);

        userGateway.unfollowUser(userId, unfollowId);

        return new SimpleMessageDTO("El usuario " + unfollowedUser.getName() + " Id: " + unfollowedUser.getId() + " ya no es seguido por el usuario " + user.getName() + " Id: " + user.getId());
    }
}
