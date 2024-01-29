package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class FormaPagamentoNaoHabilitadaParaPeriodosVariaveisException extends RuntimeException{

    public FormaPagamentoNaoHabilitadaParaPeriodosVariaveisException() {
        super();
    }
    public FormaPagamentoNaoHabilitadaParaPeriodosVariaveisException(String message) {
        super(message);
    }

}
