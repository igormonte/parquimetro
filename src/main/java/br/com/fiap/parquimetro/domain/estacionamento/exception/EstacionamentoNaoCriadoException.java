package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class EstacionamentoNaoCriadoException extends RuntimeException{

    public EstacionamentoNaoCriadoException() {
        super();
    }
    public EstacionamentoNaoCriadoException(String message) {
        super(message);
    }

}
