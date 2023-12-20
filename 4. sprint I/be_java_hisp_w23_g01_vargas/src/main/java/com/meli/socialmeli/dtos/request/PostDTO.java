package com.meli.socialmeli.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.meli.socialmeli.dtos.response.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    @JsonProperty("user_id")
    protected int userId;
    protected LocalDate date;
    protected ProductDTO product;
    protected int category;
    protected double price;
}

