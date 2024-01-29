package br.com.fiap.parquimetro.domain.condutor.builder;

import br.com.fiap.parquimetro.domain.condutor.Veiculo;

import java.util.UUID;

public class VeiculoBuilder extends Veiculo {

    public VeiculoBuilder() {
    }

    public VeiculoBuilder withUuid(String uuid){
        this.setUuid(uuid);
        return this;
    }
    public VeiculoBuilder withPlaca(String placa){
        this.setPlaca(placa);
        return this;
    }
    public VeiculoBuilder withNome(String nome){
        this.setNome(nome);
        return this;
    }
    public VeiculoBuilder withInativo(Boolean inativo){
        this.setInativo(inativo);
        return this;
    }

    public Veiculo build() {
        return this;
    }

}
