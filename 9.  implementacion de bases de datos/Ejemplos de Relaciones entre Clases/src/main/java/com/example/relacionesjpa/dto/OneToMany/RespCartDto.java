package com.example.relacionesjpa.dto.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RespCartDto {
    private CartDto cart;
    private String mensaje;
}
