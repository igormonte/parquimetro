package br.com.fiap.parquimetro.infraestructure.postgre.builder;

import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CondutorEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;

import java.util.UUID;

public class VeiculoEntityBuilder {

    private VeiculoEntity veiculo;

    public VeiculoEntityBuilder() {
        this.veiculo = new VeiculoEntity();
    }

    public VeiculoEntityBuilder withUuid(UUID uuid){
        this.veiculo.setUuid(uuid);
        return this;
    }

    public VeiculoEntityBuilder withCondutor(CondutorEntity condutor){
        this.veiculo.setCondutor(condutor);
        return this;
    }
    public VeiculoEntityBuilder withPlaca(String placa){
        this.veiculo.setPlaca(placa);
        return this;
    }
    public VeiculoEntityBuilder withNome(String nome){
        this.veiculo.setNome(nome);
        return this;
    }
    public VeiculoEntityBuilder withInativo(Boolean inativo){
        this.veiculo.setInativo(inativo);
        return this;
    }

    public VeiculoEntity build() {
        return this.veiculo;
    }

}
