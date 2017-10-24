package com.test.countriesapp.unautorize;

/**
 * Created by sma on 24.10.17.
 */

public class UnatorizeException extends Exception {

    private int code;
    private String message;

    public UnatorizeException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
