package com.meli.compositekey.service;

import com.meli.compositekey.dto.OrderDTO;
import com.meli.compositekey.dto.OrdersDTO;
import com.meli.compositekey.dto.ResponseDTO;

public interface IOrderService {
    ResponseDTO createOrder(OrderDTO orderDTO);
}
