package br.com.fiap.parquimetro.domain.estacionamento.exception;

public class TempoPermanenciaNaoInformadoException extends RuntimeException{

    public TempoPermanenciaNaoInformadoException() {
        super();
    }
    public TempoPermanenciaNaoInformadoException(String message) {
        super(message);
    }

}
