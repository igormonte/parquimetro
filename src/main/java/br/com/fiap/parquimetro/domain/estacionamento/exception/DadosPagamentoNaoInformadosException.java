package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class DadosPagamentoNaoInformadosException extends RuntimeException{

    public DadosPagamentoNaoInformadosException() {
        super();
    }
    public DadosPagamentoNaoInformadosException(String message) {
        super(message);
    }

}
