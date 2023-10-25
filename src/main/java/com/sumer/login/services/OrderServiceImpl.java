package com.sumer.login.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumer.login.controllers.FruitResume;
import com.sumer.login.controllers.OrderBody;
import com.sumer.login.controllers.OrderResume;
import com.sumer.login.dto.FruitDto;
import com.sumer.login.exceptions.FruitException;
import com.sumer.login.repository.OrderRepository;
import com.sumer.login.repository.dto.OrderFruit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private FruitService fruitService;
    @Override
    public OrderFruit findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public OrderFruit saveOrder(OrderBody input) throws JsonProcessingException, FruitException {
        OrderFruit orderFruit = new OrderFruit();
        orderFruit.setFruits(input.getFruits());
        ObjectMapper mapper = new ObjectMapper();

        List<FruitDto> fruitOrders = mapper.readValue(orderFruit.getFruits(), new TypeReference<List<FruitDto>>(){});

        double totalOrder = 0;
        List<FruitResume> fruitResume = new java.util.ArrayList<>(Collections.emptyList());
        for (FruitDto fruitOrder: fruitOrders) {

            double fruitPrice = fruitService.getPriceByType(fruitOrder.getType());
            int fruitAmount = fruitService.getAmountByType(fruitOrder.getType());

            if(fruitAmount<fruitOrder.getAmount()){
                throw new FruitException(FruitException.FRUIT_NOT_AVAILABLE);
            }

            double fruitTotalPrice = fruitPrice*fruitOrder.getAmount();
            if(fruitOrder.getAmount()>10){
                fruitTotalPrice-=fruitTotalPrice*0.05;
            }
            totalOrder+=fruitTotalPrice;
            fruitResume.add(new FruitResume(fruitTotalPrice,fruitOrder.getType()));
        }

        if(fruitOrders.size()>5){
            totalOrder-= totalOrder*0.10;
        }

        orderFruit.setTotalPrice(totalOrder);

        OrderResume orderResume = new OrderResume(totalOrder,fruitResume);
        System.out.println(orderResume);
        return orderRepository.save(orderFruit);
    }
}
