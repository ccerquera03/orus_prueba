package com.sumer.login.services;

import com.sumer.login.controllers.FruitBody;
import com.sumer.login.exceptions.FruitException;
import com.sumer.login.repository.FruitRepository;
import com.sumer.login.repository.dto.Fruit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FruitServiceImpl implements  FruitService{

    private FruitRepository fruitRepository;
    @Override
    public Fruit registerFruit(FruitBody input) {
        Fruit fruit = new Fruit();
        fruit.setPrice(input.getPrice());
        fruit.setType(input.getType());
        fruit.setAmount(input.getAmount());
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> getFruits(Integer page, Integer size) {
        return fruitRepository.findAll(PageRequest.of(page,size)).getContent();
    }

    @Override
    public Fruit findFruitById(Long id) throws FruitException {
        return fruitRepository.findFruitById(id).orElseThrow(()->new FruitException(FruitException.FRUIT_NOT_FOUND));
    }

    @Override
    public Fruit updateFruit(FruitBody fruitData, Long id) throws FruitException {
        Fruit fruit = findFruitById(id);
        fruit.setAmount(fruitData.getAmount());
        fruit.setType(fruitData.getType());
        fruit.setPrice(fruitData.getPrice());
        return fruitRepository.save(fruit);
    }

    @Override
    public double getPriceByType(String type) throws FruitException {
        Fruit fruit = fruitRepository.findFruitByType(type).orElseThrow(()->new FruitException(FruitException.FRUIT_NOT_FOUND));
        return fruit.getPrice();
    }

    @Override
    public Integer getAmountByType(String type) throws FruitException {
        Fruit fruit = fruitRepository.findFruitByType(type).orElseThrow(()->new FruitException(FruitException.FRUIT_NOT_FOUND));
        return fruit.getAmount();
    }

    @Override
    public void deleteFruit(Long id) {
        fruitRepository.deleteById(id);
    }

}
