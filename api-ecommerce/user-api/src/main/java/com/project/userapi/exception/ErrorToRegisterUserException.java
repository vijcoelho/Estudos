package com.project.userapi.exception;

public class ErrorToRegisterUserException extends RuntimeException {
    public ErrorToRegisterUserException() {
        super("Erro to save (register) user in the database");
    }
}
