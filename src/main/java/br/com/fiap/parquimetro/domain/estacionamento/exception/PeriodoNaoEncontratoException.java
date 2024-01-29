package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class PeriodoNaoEncontratoException extends RuntimeException{

    public PeriodoNaoEncontratoException() {
        super();
    }
    public PeriodoNaoEncontratoException(String message) {
        super(message);
    }

}
