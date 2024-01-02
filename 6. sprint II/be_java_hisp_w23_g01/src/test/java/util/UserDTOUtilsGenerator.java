package util;

import com.meli.socialmeli.dtos.response.UserFollowedDTO;
import com.meli.socialmeli.dtos.response.UserFollowersDTO;
import com.meli.socialmeli.dtos.response.UserInfoDTO;

import java.util.List;

public class UserDTOUtilsGenerator {

    public static UserFollowersDTO getUserFollowersDTOWithThreeFollowersOrderAsc(){
        UserInfoDTO userOne = new UserInfoDTO(100000,"User with followers");
        UserInfoDTO userDTOFollowerOne = new UserInfoDTO(200000,"A-Follower One");
        UserInfoDTO userDTOFollowerTwo = new UserInfoDTO(300000,"B-Follower Two");
        UserInfoDTO userDTOFollowerThree = new UserInfoDTO(400000,"Z-Follower Three");
        return new UserFollowersDTO(userOne.getUser_id(), userOne.getUser_name(),
                List.of(userDTOFollowerOne, userDTOFollowerTwo, userDTOFollowerThree));
    }
    public static UserFollowersDTO getUserFollowersDTOWithThreeFollowersOrderDesc(){
        UserInfoDTO userOne = new UserInfoDTO(100000,"User with followers");
        UserInfoDTO userDTOFollowerOne = new UserInfoDTO(200000,"A-Follower One");
        UserInfoDTO userDTOFollowerTwo = new UserInfoDTO(300000,"B-Follower Two");
        UserInfoDTO userDTOFollowerThree = new UserInfoDTO(400000,"Z-Follower Three");
        return new UserFollowersDTO(userOne.getUser_id(), userOne.getUser_name(),
                List.of(userDTOFollowerThree, userDTOFollowerTwo, userDTOFollowerOne));
    }

    public static UserFollowedDTO getUserFollowedDTOWithThreeFollowedOrderAsc() {
        UserInfoDTO userOne = new UserInfoDTO(100000,"User with followers");
        UserInfoDTO userDTOFollowerOne = new UserInfoDTO(200000,"A-Follower One");
        UserInfoDTO userDTOFollowerTwo = new UserInfoDTO(300000,"B-Follower Two");
        UserInfoDTO userDTOFollowerThree = new UserInfoDTO(400000,"Z-Follower Three");
        return new UserFollowedDTO(userOne.getUser_id(), userOne.getUser_name(),
                List.of(userDTOFollowerOne, userDTOFollowerTwo, userDTOFollowerThree));
    }

    public static UserFollowedDTO getUserFollowedDTOWithThreeFollowedOrderDesc() {
        UserInfoDTO userOne = new UserInfoDTO(100000,"User with followers");
        UserInfoDTO userDTOFollowerOne = new UserInfoDTO(200000,"A-Follower One");
        UserInfoDTO userDTOFollowerTwo = new UserInfoDTO(300000,"B-Follower Two");
        UserInfoDTO userDTOFollowerThree = new UserInfoDTO(400000,"Z-Follower Three");
        return new UserFollowedDTO(userOne.getUser_id(), userOne.getUser_name(),
                List.of(userDTOFollowerThree, userDTOFollowerTwo, userDTOFollowerOne));

    }
}