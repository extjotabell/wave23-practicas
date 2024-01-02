package com.sprint.be_java_hisp_w23_g04.service;

import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;

public interface IPostMediaService {

    /**
     * Saves a new post
     *
     * @param postDTO The post to be saved
     * @return A SimpleMessageDTO containing successfully saving message
     * @throws NotFoundException If the user with de given userId does not exist
     */
    SimpleMessageDTO savePost(PostDTO postDTO);
}
