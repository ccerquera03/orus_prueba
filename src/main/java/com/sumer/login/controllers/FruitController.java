package com.sumer.login.controllers;

import com.sumer.login.dto.LoginUserDto;
import com.sumer.login.exceptions.FruitException;
import com.sumer.login.exceptions.LoginException;
import com.sumer.login.repository.dto.User;
import com.sumer.login.services.FruitService;
import com.sumer.login.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FruitController {
    private FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("fruits")
    public ResponseEntity registerFruit(@RequestBody FruitBody fruitBody) {

        return new ResponseEntity(fruitService.registerFruit(fruitBody), HttpStatus.CREATED);

    }

    @GetMapping("fruits")
    public ResponseEntity getFruits(@RequestParam Integer page, @RequestParam Integer size) {

        return new ResponseEntity(fruitService.getFruits(page,size), HttpStatus.OK);

    }

    @PutMapping("fruits/{id}")
    public ResponseEntity updateFruit(@RequestBody FruitBody fruitBody, @PathVariable Long id) {

        try {
            return new ResponseEntity(fruitService.updateFruit(fruitBody, id), HttpStatus.OK);
        } catch (FruitException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("fruits/{id}")
    public ResponseEntity deleteFruit(@PathVariable Long id) {

        fruitService.deleteFruit(id);
        return new ResponseEntity(HttpStatus.OK);

    }

}


