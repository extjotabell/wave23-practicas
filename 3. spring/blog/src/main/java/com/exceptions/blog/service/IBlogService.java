package com.exceptions.blog.service;

import com.exceptions.blog.dto.request.RequestBlogDTO;
import com.exceptions.blog.dto.response.ResponseBlogDTO;

import java.util.List;

public interface IBlogService {
    ResponseBlogDTO saveBlog(RequestBlogDTO blog);
    ResponseBlogDTO searchBlog(int id);
    List<ResponseBlogDTO> listBlogs();
    Boolean checkBlog(int id);
}
