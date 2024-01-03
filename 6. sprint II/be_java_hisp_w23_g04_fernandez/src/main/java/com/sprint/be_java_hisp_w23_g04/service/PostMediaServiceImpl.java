package com.sprint.be_java_hisp_w23_g04.service;

import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.entity.Post;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;
import com.sprint.be_java_hisp_w23_g04.gateway.IUserGateway;
import com.sprint.be_java_hisp_w23_g04.gateway.UserGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.repository.IPostMediaRepository;
import com.sprint.be_java_hisp_w23_g04.repository.PostMediaRepositoryImpl;
import com.sprint.be_java_hisp_w23_g04.utils.PostMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sprint.be_java_hisp_w23_g04.utils.Verifications.verifyUserExist;

@Service
public class PostMediaServiceImpl implements IPostMediaService {
    private final IPostMediaRepository postMediaRepository;
    private final IUserGateway userGateway;

    public PostMediaServiceImpl(PostMediaRepositoryImpl postMediaRepository,
                                UserGatewayImpl userGateway) {
        this.postMediaRepository = postMediaRepository;
        this.userGateway = userGateway;
    }

    /**
     * Save new post if the user with the given userId exists
     *
     * @param postDTO The post to save
     * @return A SimpleMessageDTO containing successfully saving message
     * @throws NotFoundException If the user with the given userId does not exist
     */
    @Override
    public SimpleMessageDTO savePost(PostDTO postDTO) {
        //TODO remove unused list posts
        List<Post> posts = new ArrayList<>();
        User user = userGateway.findUser(postDTO.getUserId());

        verifyUserExist(user, postDTO.getUserId());
        int postId = postMediaRepository.getNextId();
        postMediaRepository.save(PostMapper.map(postDTO, postId));

        return new SimpleMessageDTO("El post para el user: " + postDTO.getUserId() + " se guardó exitosamente");
    }
}