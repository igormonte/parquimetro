package br.com.fiap.parquimetro.infraestructure.gateway.builder;

import br.com.fiap.parquimetro.infraestructure.gateway.model.Pagador;
import lombok.Data;

@Data
public class PagadorBuilder {

    private Pagador pagador;

    public PagadorBuilder() {
        this.pagador = new Pagador();
    }

    public PagadorBuilder withCpfPagador(String cpfPagador){
        this.pagador.setCpfPagador(cpfPagador);
        return this;
    }
    public PagadorBuilder withNumeroCartao(String numeroCartao){
        this.pagador.setNumeroCartao(numeroCartao);
        return this;
    }
    public PagadorBuilder withNomeTitular(String nomeTitular){
        this.pagador.setNomeTitular(nomeTitular);
        return this;
    }
    public PagadorBuilder withCvv(String cvv){
        this.pagador.setCvv(cvv);
        return this;
    }

    public Pagador build() {
        return this.pagador;
    }

}
