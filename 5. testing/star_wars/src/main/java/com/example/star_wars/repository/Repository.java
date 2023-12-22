package com.example.star_wars.repository;

import com.example.star_wars.entity.Character;

import java.util.List;

public interface Repository {
    List<Character> filterByName(String filterParam);
}
