package br.com.fiap.parquimetro.infraestructure.postgre.builder;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;

import java.util.UUID;

public class EnderecoEntityBuilder {

    private EnderecoEntity endereco;
    public EnderecoEntityBuilder() {
        this.endereco = new EnderecoEntity();
    }

    public EnderecoEntityBuilder withUUid(UUID uuid){
        this.endereco.setUuid(uuid);
        return this;
    }

    public EnderecoEntityBuilder withRua(String rua){
        this.endereco.setRua(rua);
        return this;
    }

    public EnderecoEntityBuilder withNumero(Integer numero){
        this.endereco.setNumero(numero);
        return this;
    }

    public EnderecoEntityBuilder withBairro(String bairro){
        this.endereco.setBairro(bairro);
        return this;
    }

    public EnderecoEntityBuilder withCidade(String cidade){
        this.endereco.setCidade(cidade);
        return this;
    }

    public EnderecoEntityBuilder withUf(String uf){
        this.endereco.setUf(uf);
        return this;
    }

    public EnderecoEntityBuilder withCep(String cep) {
        this.endereco.setCep(cep);
        return this;
    }

    public EnderecoEntity build() {
        return this.endereco;
    }

}
