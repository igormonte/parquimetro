package br.com.fiap.parquimetro.domain.estacionamento.builder;

import br.com.fiap.parquimetro.domain.estacionamento.Cartao;

import java.util.UUID;

public class CartaoBuilder extends Cartao {

    public CartaoBuilder(){}

    public CartaoBuilder withUuid(String uuid) {
        this.setUuid(uuid);
        return this;
    }
    
    public CartaoBuilder withNumeroCartao(String numeroCartao) {
        this.setNumeroCartao(numeroCartao);
        return this;
    }
    
    public CartaoBuilder withNomeTitular(String nomeTitular) {
        this.setNomeTitular(nomeTitular);
        return this;
    }
    
    public CartaoBuilder withCvv(String cvv) {
        this.setCvv(cvv);
        return this;
    }

    public Cartao build() {
        return this;
    }

}
