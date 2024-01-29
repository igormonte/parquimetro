package br.com.fiap.parquimetro.infraestructure.postgre.builder;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.CartaoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

public class CartaoEntityBuilder extends CartaoEntity {

    private CartaoEntity cartao;

    public CartaoEntityBuilder(){
        this.cartao = new CartaoEntity();
    }

    public CartaoEntityBuilder withUuid(UUID uuid) {
        this.cartao.setUuid(uuid);
        return this;
    }
    
    public CartaoEntityBuilder withNumeroCartao(String numeroCartao) {
        this.cartao.setNumeroCartao(numeroCartao);
        return this;
    }
    
    public CartaoEntityBuilder withNomeTitular(String nomeTitular) {
        this.cartao.setNomeTitular(nomeTitular);
        return this;
    }
    
    public CartaoEntityBuilder withCvv(String cvv) {
        this.cartao.setCvv(cvv);
        return this;
    }

    public CartaoEntity build() {
        return this.cartao;
    }

}
