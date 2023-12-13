package com.exceptions.blog.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RequestBlogDTO {
    private int id;
    private String title;
    private String name;
    private Date date;
}
