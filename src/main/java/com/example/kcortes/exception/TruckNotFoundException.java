package com.example.kcortes.exception;

public class TruckNotFoundException extends RuntimeException {

    public TruckNotFoundException(String message) {
        super(message);
    }
}
