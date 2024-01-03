package com.sprint.be_java_hisp_w23_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.entity.Post;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostMediaRepositoryImpl implements IPostMediaRepository {
    private List<Post> posts = new ArrayList<>();

    public PostMediaRepositoryImpl() {
        this.posts = loadDataBase();
    }

    private List<Post> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:post.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        TypeReference<List<Post>> typeRef = new TypeReference<>() {
        };
        List<Post> posts = null;
        try {
            posts = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts;
    }

    /**
     * Retrieves the next available id from the list of posts
     *
     * @return The next available id from the list of posts
     */
    @Override
    public int getNextId() {
        return posts.size() + 1;
    }

    @Override
    public List<Post> getByIds(List<Integer> listIds) {
        return posts.stream().filter(
                        p -> listIds.contains(p.getId())).
                collect(Collectors.toCollection(ArrayList::new));

    }

    /**
     * Adds a new post to the list of posts
     *
     * @param post The post to be saved
     */
    @Override
    public void save(Post post) {
        posts.add(post);
    }
}
