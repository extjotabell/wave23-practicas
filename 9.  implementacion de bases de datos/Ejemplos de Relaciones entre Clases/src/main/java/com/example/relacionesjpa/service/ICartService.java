package com.example.relacionesjpa.service;

import com.example.relacionesjpa.dto.OneToMany.CartDto;
import com.example.relacionesjpa.dto.OneToMany.RespCartDto;

import java.util.List;

public interface ICartService {

    List<CartDto> buscarTodos();
    RespCartDto guardarCart(CartDto cart);
    RespCartDto borrarCart(Long id);
    CartDto obtenerPorId(Long id);
}
