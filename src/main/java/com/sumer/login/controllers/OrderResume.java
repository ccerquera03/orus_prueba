package com.sumer.login.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderResume {

    private Double totalPrice;
    private List<FruitResume> fruitResume;
}
