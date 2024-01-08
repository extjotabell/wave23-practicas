package com.youtube.practice.service;

import com.youtube.practice.dto.BlogEntriesDTO;
import com.youtube.practice.dto.BlogEntryDTO;
import com.youtube.practice.dto.response.BlogEntryResponse;
import com.youtube.practice.entity.BlogEntry;
import com.youtube.practice.exception.DuplicatedRecord;
import com.youtube.practice.exception.NotFoundException;
import com.youtube.practice.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BlogServiceImp implements IBlogService {
    @Autowired
    IBlogRepo blogRepo;

    ArrayList<BlogEntryDTO> blogEntries = new ArrayList<>();
    BlogEntriesDTO blogEntriesDTO = new BlogEntriesDTO(blogEntries);

    @Override
    public BlogEntryResponse addNewEntry(BlogEntryDTO blogEntry) {
        if (blogRepo.findByTitle(blogEntry.getBlogTitle()) != null) {
            throw new DuplicatedRecord("A blog with this name already exists");
        } else {
            blogEntries.add(blogEntry);
            BlogEntry newBlogEntry = new BlogEntry(blogEntry.getBlogTitle(), blogEntry.getAuthorName(), blogEntry.getPublishDate());
            blogRepo.addNewEntry(newBlogEntry);
            return new BlogEntryResponse("Blog entry created successfully, blog id: " + newBlogEntry.getIdBlog());
        }
    }

    @Override
    public BlogEntryDTO findById(int id) {
        BlogEntry blogEntry = blogRepo.findById(id);

        if (blogEntry == null) {
            throw new NotFoundException("Blog not found");
        } else {
            BlogEntryDTO blogEntryDTO = new BlogEntryDTO();
            blogEntryDTO.setBlogTitle(blogEntry.getBlogTitle());
            blogEntryDTO.setAuthorName(blogEntry.getAuthorName());
            blogEntryDTO.setPublishDate(blogEntry.getPublishDate());

            return blogEntryDTO;
        }
    }

    @Override
    public BlogEntriesDTO getAll() {
        if (!blogEntriesDTO.getBlogEntries().isEmpty()) {
            return blogEntriesDTO;
        } else {
            throw new NotFoundException("Blogs not found");
        }
    }
}
