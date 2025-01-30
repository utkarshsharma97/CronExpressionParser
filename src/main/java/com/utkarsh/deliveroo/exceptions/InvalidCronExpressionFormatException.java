package com.utkarsh.deliveroo.exceptions;

public class InvalidCronExpressionFormatException extends Exception {
    public InvalidCronExpressionFormatException(String message) {
        super(message);
    }
}
