package com.youtube.practice.dto;

import java.util.ArrayList;

public class BlogEntriesDTO {
    ArrayList<BlogEntryDTO> blogEntries;

    public BlogEntriesDTO() {
    }

    public BlogEntriesDTO(ArrayList<BlogEntryDTO> blogEntries) {
        this.blogEntries = blogEntries;
    }

    public ArrayList<BlogEntryDTO> getBlogEntries() {
        return blogEntries;
    }

    public void setBlogEntries(ArrayList<BlogEntryDTO> blogEntries) {
        this.blogEntries = blogEntries;
    }
}
