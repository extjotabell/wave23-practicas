package com.exceptions.blog.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ResponseBlogDTO {
    private int id;
    private String title;
    private String name;
    private Date date;
}