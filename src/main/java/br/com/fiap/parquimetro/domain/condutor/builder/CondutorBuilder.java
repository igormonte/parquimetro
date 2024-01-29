package br.com.fiap.parquimetro.domain.condutor.builder;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Endereco;
import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;

import java.util.List;
import java.util.UUID;

public class CondutorBuilder extends Condutor {

    public CondutorBuilder() {
        this.setUuid(UUID.randomUUID().toString());
    }

    public CondutorBuilder withUuid(String uuid){
        this.setUuid(uuid);
        return this;
    }
    public CondutorBuilder withNome(String nome){
        this.setNome(nome);
        return this;
    }
    public CondutorBuilder withEmail(String email){
        this.setEmail(email);
        return this;
    }
    public CondutorBuilder withSenha(String senha){
        this.setSenha(senha);
        return this;
    }
    public CondutorBuilder withCpf(String cpf){
        this.setCpf(cpf);
        return this;
    }
    public CondutorBuilder withFormaPagamentoPadrao(FormaPagamentoEnum formaPagamentoPadrao){
        this.setFormaPagamentoPadrao(formaPagamentoPadrao);
        return this;
    }
    public CondutorBuilder withEndereco(Endereco endereco){
        this.setEndereco(endereco);
        return this;
    }
    public CondutorBuilder withVeiculos(List<Veiculo> veiculo) {
        this.setVeiculo(veiculo);
        return this;
    }

    public Condutor build() {
        return this;
    }

}
