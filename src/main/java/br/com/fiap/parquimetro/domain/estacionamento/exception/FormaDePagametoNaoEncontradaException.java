package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class FormaDePagametoNaoEncontradaException extends RuntimeException{

    public FormaDePagametoNaoEncontradaException() {
        super();
    }
    public FormaDePagametoNaoEncontradaException(String message) {
        super(message);
    }

}
