package com.sprint.be_java_hisp_w23_g04.repository;


import com.sprint.be_java_hisp_w23_g04.entity.Post;

import java.util.List;

public interface IPostMediaRepository {
    /**
     * Retrieves the next available id for saving posts
     *
     * @return The next available id for saving posts
     */
    int getNextId();
    List<Post> getByIds(List<Integer> listIds);

    /**
     * Saves a new post
     *
     * @param post The post to be saved
     */
    void save(Post post);
}
