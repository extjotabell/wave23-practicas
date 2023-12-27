package com.example.blog.repository;

import com.example.blog.entity.EntryBlog;
import com.example.blog.exception.EntryBlogDuplicateException;
import com.example.blog.exception.EntryBlogListEmptyException;
import com.example.blog.exception.EntryBlogNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BlogRepositoryTest {


    IBlogRepository repository;
    @BeforeEach
    void setUp(){
        repository=new BlogRepository();
    }

    @Test
    void addEntryNotExists(){
        //Arrange
        EntryBlog entryBlog = new EntryBlog();
        Long expected = 10L;
        entryBlog.setId(expected);
        //Act
        Long result = repository.addEntryBlog(entryBlog);
        //Assertion
        Assertions.assertEquals(expected,result);
    }

    @Test
    void addEntryAlreadyExists(){
        //Arrange
        EntryBlog entryBlog = new EntryBlog();
        Long expected = 10L;
        entryBlog.setId(expected);
        repository.addEntryBlog(entryBlog);
        //Act & Assert
        Assertions.assertThrows(EntryBlogDuplicateException.class, ()->repository.addEntryBlog(entryBlog));
    }

    @Test
    void getEntryBlogAlreadyExists(){
        //Arrange
        Long id = 10L;
        EntryBlog expected = new EntryBlog();
        expected.setId(id);
        repository.addEntryBlog(expected);
        //Act
        EntryBlog result = repository.getEntryBlogById(id);
        //Assertion
        Assertions.assertEquals(expected,result);
    }

    @Test
    void getEntryBlogNotExists(){
        //Arrange
        Long id = 10L;
        //Act & Assert
        Assertions.assertThrows(EntryBlogNotFoundException.class, ()->repository.getEntryBlogById(id));
    }

    @Test
    void getAllOk(){
        //Arrange
        EntryBlog e1 = new EntryBlog();
        e1.setId(1L);
        EntryBlog e2 = new EntryBlog();
        e2.setId(2L);
        repository.addEntryBlog(e1);
        repository.addEntryBlog(e2);
        List<EntryBlog> expected = List.of(e1,e2);

        //Act
        List<EntryBlog> result = repository.getAllEntryBlog();
        //Assertion
        Assertions.assertEquals(expected,result);
    }

    @Test
    void getAllEmptyList(){
        Assertions.assertThrows(EntryBlogListEmptyException.class, ()->repository.getAllEntryBlog());
    }
}
