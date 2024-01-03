package com.sprint.be_java_hisp_w23_g04.gateway;

import com.sprint.be_java_hisp_w23_g04.entity.Post;
import com.sprint.be_java_hisp_w23_g04.repository.IPostMediaRepository;
import com.sprint.be_java_hisp_w23_g04.repository.PostMediaRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostGatewayImpl implements  IPostGateway{

    private final IPostMediaRepository postMediaRepository;

    public PostGatewayImpl(PostMediaRepositoryImpl postMediaRepository) {
        this.postMediaRepository = postMediaRepository;
    }

    /**
    * Get posts by list ids
    *
    * @param postsIds list with posts ids to get.
    * @return the list of Post
    **/
    @Override
    public List<Post> getByIds(List<Integer> postsIds) {
        return this.postMediaRepository.getByIds(postsIds);
    }
}
