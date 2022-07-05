package com.nunueffe.todo.item.exception;

public class ItemDomainException extends RuntimeException {

    public ItemDomainException(String message) {
        super(message);
    }

    public ItemDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}

