package com.sumer.login.controllers;

import com.sumer.login.dto.LoginUserDto;
import com.sumer.login.exceptions.LoginException;
import com.sumer.login.repository.dto.User;
import com.sumer.login.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private LoginService loginService;

    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("user/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user) {
        try {
            return new ResponseEntity(loginService.registerUser(user), HttpStatus.CREATED);
        } catch (LoginException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("user/login")
    public ResponseEntity loginUser(@RequestBody LoginUserDto loginUserDto) {
        try {
            return new ResponseEntity(loginService.loginUser(loginUserDto), HttpStatus.OK);
        } catch (LoginException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> helloWorld() {

        return new ResponseEntity<String>("hello world", HttpStatus.CREATED);

    }
}
