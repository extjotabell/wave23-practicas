package com.ejercicioBlog.ejercicioBlog.service;
import com.ejercicioBlog.ejercicioBlog.dto.request.BlogRequestDTO;
import com.ejercicioBlog.ejercicioBlog.dto.response.BlogCreateDTO;
import com.ejercicioBlog.ejercicioBlog.dto.response.BlogResponseDTO;
import com.ejercicioBlog.ejercicioBlog.dto.response.BlogsResponseDTO;
import com.ejercicioBlog.ejercicioBlog.entity.Blog;
import com.ejercicioBlog.ejercicioBlog.repository.BlogRepositoryImpl;
import com.ejercicioBlog.ejercicioBlog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.ejercicioBlog.ejercicioBlog.exception.BadRequestException;
import com.ejercicioBlog.ejercicioBlog.exception.NotFoundException;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    IBlogRepository repository;

    public BlogServiceImpl(BlogRepositoryImpl repository) {
        this.repository = repository;
    }

    ObjectMapper mapper = new ObjectMapper();


    @Override
    public BlogCreateDTO crearBlog(BlogRequestDTO blogrequest) {
        if (blogrequest == null){
            throw new BadRequestException("Error al crear blog");
        }

        Blog entradaBlog =  repository.buscarId(blogrequest.getId());

        if (entradaBlog != null) {
            throw new BadRequestException("El blog ya existe");
        }

        entradaBlog = repository.crearBlog(mapper.convertValue(blogrequest, Blog.class));
        return mapper.convertValue(entradaBlog, BlogCreateDTO.class);
    }

    @Override
    public BlogResponseDTO buscarId(Integer id) {
        Blog blogId = repository.buscarId(id);

        if (blogId == null){
            throw new NotFoundException("No existe blog con id " +id);
        }
        return mapper.convertValue(blogId,BlogResponseDTO.class);
    }

    @Override
    public BlogsResponseDTO buscarTodos() {
        List<Blog> blogs = repository.buscarTodos();

        if (blogs.isEmpty()){
            throw new NotFoundException("No existen blogs creados");
        }

        return new BlogsResponseDTO(blogs.stream()
                .map(blog -> mapper.convertValue(blog,BlogResponseDTO.class)).toList());
    }
}
