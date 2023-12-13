package com.exceptions.blog.service;

import com.exceptions.blog.dto.request.RequestBlogDTO;
import com.exceptions.blog.dto.response.ResponseBlogDTO;
import com.exceptions.blog.entity.Blog;
import com.exceptions.blog.exception.IllegalArgumentException;
import com.exceptions.blog.mapper.BlogMapper;
import com.exceptions.blog.reposotiry.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    IBlogRepository repository;

    @Override
    public ResponseBlogDTO saveBlog(RequestBlogDTO blogDTO) {
        Boolean response = checkBlog(blogDTO.getId());
        ObjectMapper mapper = new ObjectMapper();

        if(response == null){
            Blog blog = BlogMapper.toBlog(blogDTO);

            repository.saveBlog(blog, blogDTO.getId());

            return mapper.convertValue(blogDTO, ResponseBlogDTO.class);
        }else {
            throw new IllegalArgumentException("El id "+ blogDTO.getId() + " ya se encuentra usado.");
        }
    }

    @Override
    public ResponseBlogDTO searchBlog(int id) {
        Blog response = repository.searchBlog(id);

        if(response != null){
            return BlogMapper.toResponseDTO(response, id);
        }else {
            throw new IllegalArgumentException("No se encuentra ningun blog con el id: "+ id);
        }
    }

    @Override
    public List<ResponseBlogDTO> listBlogs() {
        Map<Integer, Blog> list = repository.listBlogs();

        return list.entrySet().stream()
                .map(entry -> {
                    Blog blog = entry.getValue();

                    ResponseBlogDTO responseDTO = new ResponseBlogDTO();

                    responseDTO.setId(entry.getKey());
                    responseDTO.setTitle(blog.getTitle());
                    responseDTO.setName(blog.getName());
                    responseDTO.setDate(blog.getDate());

                    return responseDTO;
                })
                .toList();
    }

    @Override
    public Boolean checkBlog(int id) {
        Blog response = repository.searchBlog(id);

        return response != null;
    }
}
