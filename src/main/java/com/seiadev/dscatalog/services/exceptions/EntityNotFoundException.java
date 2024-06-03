package com.seiadev.dscatalog.services.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
