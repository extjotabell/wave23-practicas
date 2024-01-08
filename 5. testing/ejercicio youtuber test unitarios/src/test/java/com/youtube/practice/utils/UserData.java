package com.youtube.practice.utils;

import com.youtube.practice.dto.BlogEntriesDTO;
import com.youtube.practice.dto.BlogEntryDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserData {
    public static BlogEntryDTO getBlogEntry() {
        return new BlogEntryDTO("Title", "Name", new Date(1228944000000L));
    }

    public static BlogEntriesDTO getBlogEntires() {
        BlogEntryDTO entry1 = new BlogEntryDTO("Title", "Name", new Date(1228944000000L));
        BlogEntryDTO entry2 = new BlogEntryDTO("Title 2", "Name 2", new Date(1228944000000L));
        BlogEntryDTO entry3 = new BlogEntryDTO("Title 3", "Name 3", new Date(1228944000000L));
        ArrayList<BlogEntryDTO> entries = new ArrayList<>(List.of(entry1, entry2, entry3));
        return new BlogEntriesDTO(entries);
    }
}
