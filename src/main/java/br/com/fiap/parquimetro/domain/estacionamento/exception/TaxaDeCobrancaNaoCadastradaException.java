package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class TaxaDeCobrancaNaoCadastradaException extends RuntimeException{

    public TaxaDeCobrancaNaoCadastradaException() {
        super();
    }
    public TaxaDeCobrancaNaoCadastradaException(String message) {
        super(message);
    }

}
