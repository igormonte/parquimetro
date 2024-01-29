package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class DadosInvalidosException extends RuntimeException{

    public DadosInvalidosException() {
        super();
    }
    public DadosInvalidosException(String message) {
        super(message);
    }

}
