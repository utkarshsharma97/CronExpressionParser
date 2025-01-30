package com.utkarsh.deliveroo.exceptions;

public class InvalidCronFieldFormatException extends Exception {
    public InvalidCronFieldFormatException(String message) {
        super(message);
    }
}
