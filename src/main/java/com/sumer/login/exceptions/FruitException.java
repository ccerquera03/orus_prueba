package com.sumer.login.exceptions;

public class FruitException extends Exception {
    public static final String FRUIT_NOT_FOUND = "fruit not found";
    public static final String FRUIT_NOT_AVAILABLE = "fruit not available";
    public FruitException(String message) {
        super(message);
    }
}
