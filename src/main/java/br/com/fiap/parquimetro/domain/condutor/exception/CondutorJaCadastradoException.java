package br.com.fiap.parquimetro.domain.condutor.exception;

public class CondutorJaCadastradoException extends RuntimeException{

    public CondutorJaCadastradoException() {
        super();
    }
    public CondutorJaCadastradoException(String message) {
        super(message);
    }

}
