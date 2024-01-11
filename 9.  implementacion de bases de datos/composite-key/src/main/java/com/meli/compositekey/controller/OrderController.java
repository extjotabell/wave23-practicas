package com.meli.compositekey.controller;

import com.meli.compositekey.dto.OrderDTO;
import com.meli.compositekey.service.IOrderService;
import com.meli.compositekey.service.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    IOrderService service;
    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(service.createOrder(orderDTO), HttpStatus.CREATED);
    }
}
