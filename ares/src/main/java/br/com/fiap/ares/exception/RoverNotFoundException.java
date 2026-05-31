package br.com.fiap.ares.exception;

public class RoverNotFoundException
        extends RuntimeException {

    public RoverNotFoundException(String mensagem) {
        super(mensagem);
    }
}