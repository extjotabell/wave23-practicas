package com.meli.compositekey.service;

import com.meli.compositekey.dto.OrderDTO;
import com.meli.compositekey.dto.ResponseDTO;
import com.meli.compositekey.entity.Order;
import com.meli.compositekey.repository.IOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    IOrderRepository repository;
    public OrderServiceImpl(IOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getCustomerId(), orderDTO.getDate());
        repository.save(order);
        return new ResponseDTO("Order created successfully");
    }
}
