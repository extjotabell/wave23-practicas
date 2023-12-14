package com.bootcamp.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Blog {

    protected Integer id;
    protected String name, autor;
    protected Date dateRelease;

}
