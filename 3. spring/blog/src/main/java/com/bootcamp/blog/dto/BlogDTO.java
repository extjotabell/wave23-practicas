package com.bootcamp.blog.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BlogDTO {

    protected Integer id;
    protected String name, autor;
    protected Date dateRelease;

}
