package com.sumer.login.services;

import com.sumer.login.dto.LoginUserDto;
import com.sumer.login.exceptions.LoginException;
import com.sumer.login.repository.dto.User;


public interface LoginService {

    User registerUser(User user) throws LoginException;

    String loginUser(LoginUserDto loginUserDto) throws LoginException;
}
