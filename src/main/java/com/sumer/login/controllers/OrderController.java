package com.sumer.login.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sumer.login.exceptions.FruitException;
import com.sumer.login.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("orders")
    public ResponseEntity registerOrder(@RequestBody OrderBody orderBody) throws JsonProcessingException {

        try {
            return new ResponseEntity(orderService.saveOrder(orderBody), HttpStatus.CREATED);
        } catch (FruitException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("orders/{id}")
    public ResponseEntity getFruits(@PathVariable Long id) throws JsonProcessingException {

        return new ResponseEntity(orderService.findOrderById(id), HttpStatus.OK);

    }
}
