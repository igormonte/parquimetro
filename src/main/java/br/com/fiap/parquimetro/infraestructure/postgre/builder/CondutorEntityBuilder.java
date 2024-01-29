package br.com.fiap.parquimetro.infraestructure.postgre.builder;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Endereco;
import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CondutorEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;

import java.util.List;
import java.util.UUID;

public class CondutorEntityBuilder {

    private CondutorEntity condutor;

    public CondutorEntityBuilder() {
        this.condutor = new CondutorEntity();
    }

    public CondutorEntityBuilder withUuid(UUID uuid){
        this.condutor.setUuid(uuid);
        return this;
    }
    public CondutorEntityBuilder withNome(String nome){
        this.condutor.setNome(nome);
        return this;
    }
    public CondutorEntityBuilder withEmail(String email){
        this.condutor.setEmail(email);
        return this;
    }
    public CondutorEntityBuilder withSenha(String senha){
        this.condutor.setSenha(senha);
        return this;
    }
    public CondutorEntityBuilder withCpf(String cpf){
        this.condutor.setCpf(cpf);
        return this;
    }
    public CondutorEntityBuilder withFormaPagamentoPadrao(FormaPagamentoEnum formaPagamentoPadrao){
        this.condutor.setFormaPagamentoPadrao(formaPagamentoPadrao);
        return this;
    }
    public CondutorEntityBuilder withEndereco(EnderecoEntity endereco){
        this.condutor.setEndereco(endereco);
        return this;
    }
    public CondutorEntityBuilder withVeiculos(List<VeiculoEntity> veiculo) {
        this.condutor.setVeiculo(veiculo);
        return this;
    }

    public CondutorEntity build() {
        return this.condutor;
    }

}
