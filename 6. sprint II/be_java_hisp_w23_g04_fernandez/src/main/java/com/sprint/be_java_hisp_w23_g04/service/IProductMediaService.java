package com.sprint.be_java_hisp_w23_g04.service;


import com.sprint.be_java_hisp_w23_g04.dto.response.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostListDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;

public interface IProductMediaService {

    PostListDTO getFilteredPosts(int userId, String order);
}
