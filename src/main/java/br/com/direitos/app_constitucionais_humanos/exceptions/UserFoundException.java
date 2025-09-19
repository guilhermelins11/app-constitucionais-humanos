package br.com.direitos.app_constitucionais_humanos.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuario já existe.");
    }
}
