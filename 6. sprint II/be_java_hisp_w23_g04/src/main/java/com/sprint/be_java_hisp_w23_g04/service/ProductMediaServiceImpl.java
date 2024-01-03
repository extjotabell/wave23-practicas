package com.sprint.be_java_hisp_w23_g04.service;

import com.sprint.be_java_hisp_w23_g04.dto.response.*;
import com.sprint.be_java_hisp_w23_g04.entity.*;
import com.sprint.be_java_hisp_w23_g04.exception.*;
import com.sprint.be_java_hisp_w23_g04.gateway.*;
import com.sprint.be_java_hisp_w23_g04.utils.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMediaServiceImpl implements IProductMediaService {

    private final IUserGateway userGateway;
    private final IPostGateway postGateway;
    private final IProductGateway productGateway;

    public ProductMediaServiceImpl(UserGatewayImpl userGateway,
                                   PostGatewayImpl postGateway,
                                   ProductGatewayImpl productGateway) {
        this.userGateway = userGateway;
        this.postGateway = postGateway;
        this.productGateway = productGateway;
    }

    /**
     * Returns all published posts in the last 2 weeks of the sellers followed by the given user, sorted by date.
     *
     * @param userId user id ho do the request.
     * @param order indicates if de posts will be sorted by date ASC or DESC. Can be date_desc or date_asc.
     * @return posts list of followed sellers sorted by date published in the last 2 weeks.
     * @throws NotFoundException if not exists user with the given userId
     * @throws NotFoundException if the user does not have any followed sellers.
     * @throws NoContentException if the list of filtered posts is empty.
     * @throws BadRequestException if the order isn't date_desc or date_asc
     */
    @Override
    public PostListDTO getFilteredPosts(int userId, String order) {
        Verifications.verifyOrderCriteriaExists(order);

        User user = userGateway.findUser(userId);

        Verifications.verifyUserExist(user,userId);

        Verifications.verifyUserHasFollowedSellers(user);

        LocalDate filterDate = LocalDate.now().minusWeeks(2);

        List<Integer>followedIds = user.getFollowedId();

        List<User> sellers = userGateway.getByIds(followedIds);

        List<PostResponseDTO> listToReturn = new ArrayList<>();

        for(User seller: sellers) {
            List<Post> sellerPosts = postGateway.getByIds(seller.getPostsId());

            for (Post post: sellerPosts) {
                if(!post.getDate().isBefore(filterDate)){
                    Product product = productGateway.getById(post.getProductId());
                    listToReturn.add(PostMapper.mapperToPostResponseDTO(seller,post,product));
                }
            }
        }

        Verifications.validateEmptyResponseList(listToReturn);

        switch (order) {
            case "date_asc" -> listToReturn = orderAsc(listToReturn);
            case "date_desc" -> listToReturn = orderDesc(listToReturn);
        }

        return new PostListDTO(userId,listToReturn);
    }

    /**
     * Sort the given list by date ASC
     *
     * @param list list to sort.
     * @return sorted list by date ASC.
     */
    private List<PostResponseDTO> orderAsc(List<PostResponseDTO> list) {
        return list.stream()
                .sorted(Comparator.comparing(PostResponseDTO::getDate))
                .collect(Collectors.toList());
    }

    /**
     * Sort the given list by date DESC
     *
     * @param list list to sort.
     * @return sorted list by date DESC.
     */
    private List<PostResponseDTO> orderDesc(List<PostResponseDTO> list) {
        return list.stream()
                .sorted((p1, p2) -> p2.getDate().compareTo(p1.getDate()))
                .collect(Collectors.toList());
    }

}
