package com.tdd.laboratorio_tdd_spring.exception;

public class EmailIncorrectException extends RuntimeException{
    public EmailIncorrectException(){
        super("El Email tiene un formato incorrecto");
    }
}
