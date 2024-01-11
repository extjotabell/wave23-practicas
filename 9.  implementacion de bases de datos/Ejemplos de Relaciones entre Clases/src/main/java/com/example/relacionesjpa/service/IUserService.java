package com.example.relacionesjpa.service;

import com.example.relacionesjpa.dto.OneToMany.CartDto;
import com.example.relacionesjpa.dto.OneToMany.RespCartDto;
import com.example.relacionesjpa.dto.OneToOne.RespUserDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> buscarTodos();
    RespUserDto guardarUser(UserDto user);
    RespUserDto borrarUser(Long id);
    UserDto obtenerPorId(Long id);
}
