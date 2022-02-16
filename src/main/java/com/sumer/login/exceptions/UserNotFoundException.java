package com.sumer.login.exceptions;

public class UserNotFoundException extends  Exception{

    public static final String USER_NOT_FOUND="user not found";

    public UserNotFoundException(String message) {
        super(message);
    }
}
