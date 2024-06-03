package com.arquitecturasoftware.apiescuelaenlinea.exceptions;

public class EntityNoFoundException extends RuntimeException{
    public EntityNoFoundException(String message){
        super(message);
    }
}
