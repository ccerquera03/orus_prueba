package com.sumer.login.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sumer.login.controllers.OrderBody;
import com.sumer.login.exceptions.FruitException;
import com.sumer.login.repository.dto.OrderFruit;

public interface OrderService {

    OrderFruit findOrderById(Long id) throws JsonProcessingException;

    OrderFruit saveOrder(OrderBody order) throws JsonProcessingException, FruitException;
}
