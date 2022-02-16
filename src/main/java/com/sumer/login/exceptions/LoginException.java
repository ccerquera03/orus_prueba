package com.sumer.login.exceptions;

public class LoginException extends Exception {
    public static final String USER_ALREADY_TAKEN="user email already taken";
    public static final String INCORRECT_USER_OR_PASSWORD="user or paswword incorrect";

    public LoginException(String message) {
        super(message);
    }
}
