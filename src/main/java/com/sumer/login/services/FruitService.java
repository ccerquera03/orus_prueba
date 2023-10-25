package com.sumer.login.services;

import com.sumer.login.controllers.FruitBody;
import com.sumer.login.exceptions.FruitException;
import com.sumer.login.repository.dto.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit registerFruit(FruitBody input);
    List<Fruit> getFruits(Integer page, Integer size);

    Fruit findFruitById(Long id) throws FruitException;

    Fruit updateFruit(FruitBody fruitData, Long id) throws FruitException;

    double getPriceByType(String type) throws FruitException;
    Integer getAmountByType(String type) throws FruitException;

    void deleteFruit(Long id);

}
