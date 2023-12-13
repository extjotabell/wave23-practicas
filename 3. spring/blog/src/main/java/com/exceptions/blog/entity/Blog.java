package com.exceptions.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Blog {
    private String title;
    private String name;
    private Date date;
}
