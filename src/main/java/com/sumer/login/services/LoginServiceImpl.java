package com.sumer.login.services;

import com.sumer.login.dto.LoginUserDto;
import com.sumer.login.exceptions.LoginException;
import com.sumer.login.exceptions.UserNotFoundException;
import com.sumer.login.repository.UserRepository;
import com.sumer.login.repository.dto.User;
import lombok.AllArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public User registerUser(User user) throws LoginException {

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new LoginException(LoginException.USER_ALREADY_TAKEN);
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());

        user.setPassword(encodedPassword);
        return  userRepository.save(user);
    }

    @Override
    public String loginUser(LoginUserDto user) throws LoginException {

        User userRegistered = userRepository.findByEmail(user.getEmail()).orElseThrow(()-> new LoginException(LoginException.INCORRECT_USER_OR_PASSWORD));
        boolean passwordMatches = bCryptPasswordEncoder.matches(user.getPassword(),userRegistered.getPassword());
        if(!passwordMatches){
            throw new LoginException(LoginException.INCORRECT_USER_OR_PASSWORD);
        }
        return "Login Successfully";
    }


}
