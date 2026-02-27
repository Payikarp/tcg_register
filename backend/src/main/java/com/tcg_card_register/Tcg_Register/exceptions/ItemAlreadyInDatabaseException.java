package com.tcg_card_register.Tcg_Register.exceptions;

public class ItemAlreadyInDatabaseException extends RuntimeException {
    public ItemAlreadyInDatabaseException(String message) {
        super(message);
    }
}
