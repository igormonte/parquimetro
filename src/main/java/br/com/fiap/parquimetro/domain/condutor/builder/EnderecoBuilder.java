package br.com.fiap.parquimetro.domain.condutor.builder;

import br.com.fiap.parquimetro.domain.condutor.Endereco;

public class EnderecoBuilder extends Endereco {
    public EnderecoBuilder() {
    }

    public EnderecoBuilder withUUid(String uuid){
        this.setUuid(uuid);
        return this;
    }

    public EnderecoBuilder withRua(String rua){
        this.setRua(rua);
        return this;
    }

    public EnderecoBuilder withNumero(Integer numero){
        this.setNumero(numero);
        return this;
    }

    public EnderecoBuilder withBairro(String bairro){
        this.setBairro(bairro);
        return this;
    }

    public EnderecoBuilder withCidade(String cidade){
        this.setCidade(cidade);
        return this;
    }

    public EnderecoBuilder withUf(String uf){
        this.setUf(uf);
        return this;
    }

    public EnderecoBuilder withCep(String cep) {
        this.setCep(cep);
        return this;
    }

    public Endereco build() {
        return this;
    }

}
