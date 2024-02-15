package com.gachashop.shop.ExceptionHandler.exception;

public class UniqueEntityException extends RuntimeException {
    public UniqueEntityException(String message) {
        super(message);
    }
}