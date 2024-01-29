package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class PagamentoNaoAprovadoException extends RuntimeException{

    public PagamentoNaoAprovadoException() {
        super();
    }
    public PagamentoNaoAprovadoException(String message) {
        super(message);
    }

}
